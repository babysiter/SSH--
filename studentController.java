package zjut.lhd.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import zjut.lhd.po.Notice;
import zjut.lhd.po.Request;
import zjut.lhd.po.Student;
import zjut.lhd.po.StudentPicture;
import zjut.lhd.po.StudentVolunteer;
import zjut.lhd.po.Teacher;
import zjut.lhd.service.studentService;

@Controller
@RequestMapping("/studentController")
//@SessionAttributes(value={"student","firstVolunteer","secondVolunteer","imagePath"})
public class studentController {
	@Autowired
	private studentService ss;
	
	/*
	 * 
	 */
//	@ModelAttribute
//	public void setNewStudent(ModelMap m,Student s){
//		System.out.println("modelAttribut"+s.toString());
//		m.addAttribute("newStudent",s);
//	}
	@RequestMapping("/login")
	public String login(Student s,ModelMap m,HttpSession session ){
		Student stemp = ss.getStudent(s);
		if(stemp!=null && stemp.getPassword().equals(s.getPassword())){
			session.setAttribute("student", stemp);
//			m.addAttribute("student",stemp);
			//s.getIdnumber().substring(12)
			if(stemp.getPassword().equals(stemp.getIdnumber().substring(12))){
				m.addAttribute("msg", "首次登陆需要修改密码");
				return "changeStudent";
			}
			return "/WEB-INF/pages/student";
		}
		m.addAttribute("emsg", "账号密码有问题，请确定是否有输入错误。提示：账号为学号，密码初始值为身份证号后6位");
		return "WEB-INF/pages/login";
	}
	@RequestMapping("/changeStudent")
	public String changeStudent(
//			@ModelAttribute("newStudent") 
			Student ns,HttpSession session){
		try{
			if(ns.getMajor()=="")
				ns.setMajor(null);
			if(ns.getIdnumber()=="")
				ns.setIdnumber(null);
			if(ns.getName()=="")
				ns.setName(null);
			if(ns.getPassword()=="")
				ns.setPassword(null);
			ss.changeDetail(ns);
			session.setAttribute("student", ss.getStudent(ns));
			return "WEB-INF/pages/Success";
		}catch(Exception e){
			e.printStackTrace();
			return "changeStudent";
		}
	}
	
	@RequestMapping("/showPicture")
	public String showPicture(ModelMap m,HttpSession session) throws IOException {
		Student s = (Student) session.getAttribute("student");
		StudentPicture sp = new StudentPicture();
		sp.setStudentid(s.getStudentid());
		List<StudentPicture> lsp = ss.findInformation(sp);
//		if(!m.containsAttribute("imagePath")){
//			String currentPath = this.getClass().getClassLoader().getResource("../../").toString()+"image/";
//			currentPath= currentPath.substring(6);
//			m.addAttribute("imagePath", currentPath);
//		}
		m.addAttribute("lsp", lsp);
		return "WEB-INF/pages/showPicture";
	}
	
	/**
	 * 多文件上传
	 * @throws IOException 
	 */
	@RequestMapping("/uploadPicture")
	public String oneFileUpload(
			@RequestParam("file") CommonsMultipartFile file[],
			 @RequestParam("studentid") Integer studentID,
			 ModelMap m,HttpSession session) throws IOException {
		for(int i = 0;i<file.length;i++){
			if(!file[i].getContentType().equals("application/octet-stream")){
			StudentPicture sp = new StudentPicture();
			sp.setFileType(file[i].getContentType());
			sp.setFileName(file[i].getOriginalFilename());
			sp.setStudentid(studentID);
			sp.setPicture(file[i].getBytes());
			sp.setStudentPictureid(UUID.randomUUID().toString());
			ss.load(sp);
			}
		}
		return showPicture(m,session);
	}
 
	/**
	 * 文件下载
	 */
	 @RequestMapping(value = "/download")
	    public ResponseEntity<byte[]> download(@RequestParam("picture")byte[] p,@RequestParam("type") String type,@RequestParam("fileName") String fileName) throws IOException {
	        HttpHeaders headers = new HttpHeaders();
	        headers.add("Content-Disposition", "attchement;filename="+fileName);
	        switch(type){
	        case "image/gif":
	        	headers.setContentType(MediaType.IMAGE_GIF);break;
	        case "img/jpeg":
	        	headers.setContentType(MediaType.IMAGE_JPEG);break;
	        case "img/png":
	        	headers.setContentType(MediaType.IMAGE_PNG);break;
	        }
	        HttpStatus statusCode = HttpStatus.OK;
	        ResponseEntity<byte[]> entity = new ResponseEntity<>(p, headers, statusCode);
	        return entity;
	    }
    /*
     * 查看公告
     * 查出来所有公告
     * 超过截止日期的删除
     */
	    @RequestMapping("/findNotice")
	    public String findNotice(ModelMap m,HttpSession session){
	    	Student a = (Student) session.getAttribute("student");
	    	Notice s = new Notice();
	    	s.setNoticeType((byte)0);
	    	s.setNoticeTo(a.getStudentid());
	    	session.setAttribute("allNotice",ss.findNotice(s));
	    	return "WEB-INF/pages/noticeContent";
	    }
    /*
     * 查找导师信息
     */
	    @RequestMapping("/findMentor")
	    public String findMentor(boolean type, ModelMap m,HttpSession session){
	    	Student s = (Student) session.getAttribute("student");
	    	m.addAttribute("mentor",ss.findMentor(s,type));
	    	return "WEB-INF/pages/mentor";
	    }
	    @RequestMapping("/preChooseMentor")
	    public String preChooseMentor(@RequestParam("type") boolean type,HttpSession session){
	    	session.setAttribute("AllTeacher", ss.findTeacher(new Teacher()));
	    	session.setAttribute("type", type);
	    	session.removeAttribute("firstVolunteer");
	    	session.removeAttribute("secondVolunteer");
	    	return  "WEB-INF/pages/chooseMentor";
	    }
	    /*
	     * 选择第一志愿
	     */
	    @RequestMapping("/firstVolunteer")
	    public String firstVolunteer(@RequestParam("firstVolunteer") Integer firstVolunteer,
	    		HttpSession session){
	    	Teacher fid= (Teacher) session.getAttribute("firstVolunteer");
	    	Teacher sid= (Teacher) session.getAttribute("secondVolunteer");
	    	if(fid!=null && firstVolunteer == fid.getTeacherid())
//	    		JOptionPane.showMessageDialog(null, "该老师已是你的第一志愿，请勿重复添加");
	    		System.out.println("该老师已是你的第一志愿，请勿重复添加");
	    	else if(sid!=null &&firstVolunteer == sid.getTeacherid())
//	    		JOptionPane.showMessageDialog(null, "该老师已是你的第二志愿，请勿重复添加");
	    		System.out.println("该老师已是你的第二志愿，请勿重复添加");
	    	else{
	    		Teacher t = new Teacher();
	    		t.setTeacherid(firstVolunteer);
	    		session.setAttribute("firstVolunteer",ss.findTeacherByID(t));
//	    		JOptionPane.showMessageDialog(null, "添加成功");
	    		System.out.println("添加成功");
	    	}
	    	return "WEB-INF/pages/chooseMentor";
	    }
	    /*
	     * 选择第二志愿
	     */
	    @RequestMapping("/secondVolunteer")
	    public String secondVolunteer(@RequestParam("secondVolunteer") Integer secondVolunteer,
	    		HttpSession session){
	    	Teacher fid= (Teacher) session.getAttribute("firstVolunteer");
	    	Teacher sid= (Teacher) session.getAttribute("secondVolunteer");
	    	if(fid!=null &&secondVolunteer == fid.getTeacherid())
	    		System.out.println("该老师已是你的第一志愿，请勿重复添加");
	    	else if(sid!=null &&secondVolunteer == sid.getTeacherid())
	    		System.out.println("该老师已是你的第二志愿，请勿重复添加");
	    	else{
	    		Teacher t = new Teacher();
	    		t.setTeacherid(secondVolunteer);
	    		session.setAttribute("secondVolunteer",ss.findTeacherByID(t));
	    		System.out.println("添加成功");
	    	}
	    	return "WEB-INF/pages/chooseMentor";
	    }
	    /*
	     * 提交志愿
	     */
	    @RequestMapping("/chooseMentor")
	    public String chooseMentor(StudentVolunteer sv){
	    	ss.saveStudentVolunteer(sv);
	    	JOptionPane.showMessageDialog(null, "志愿提交成功");
	    	return "/WEB-INF/pages/Success";
	    }
	    @RequestMapping("/cancelChoose")
	    public String cancelChoose(Integer teacherid,HttpSession session){
	    	Teacher fid= (Teacher) session.getAttribute("firstVolunteer");
	    	Teacher sid= (Teacher) session.getAttribute("secondVolunteer");
	    	if(fid!=null &&teacherid == fid.getTeacherid())
	    		session.removeAttribute("firstVolunteer");
	    	else if(sid!=null &&teacherid == sid.getTeacherid())
	    		session.removeAttribute("secondVolunteer");
	    	else 
	    		System.out.println("您没有添加该老师作为您的志愿");
//	    		JOptionPane.showMessageDialog(null, "您没有添加该老师作为您的志愿");
	    	return "WEB-INF/pages/chooseMentor";
	    }
	    @RequestMapping("/deleteVolunteer")
	    public String deleteVolunteer(HttpSession session){
	    	session.removeAttribute("firstVolunteer");
	    	session.removeAttribute("secondVolunteer");
	    	System.out.println("删除成功");
//	    	JOptionPane.showMessageDialog(null, "删除成功");
	    	return "WEB-INF/pages/chooseMentor";
	    }
}
