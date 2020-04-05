package zjut.lhd.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import zjut.lhd.po.Notice;
import zjut.lhd.po.Request;
import zjut.lhd.po.StudentVolunteer;
import zjut.lhd.po.Teacher;
import zjut.lhd.service.teacherService;

@Controller
@RequestMapping("/teacherController")
//@SessionAttributes(value={"teacher","allNotice"})
public class teacherController {
	@Autowired
	private teacherService ts;
	
	/*
	 * 
	 */
//	@ModelAttribute
//	public void setNewTeacher(ModelMap m,Teacher t){
//		System.out.println("modelmap："+t.toString());
//		m.addAttribute("newTeacher",t);
//	}
	@RequestMapping("/login")
	public String login(Teacher s,ModelMap m,HttpSession session){
		Teacher stemp = ts.getTeacher(s);
		if(stemp!=null && stemp.getPassword().equals(s.getPassword())){
			session.setAttribute("teacher",stemp);
			//s.getIdnumber().substring(12)
			if(stemp.getPassword().equals(stemp.getIdnumber().substring(12))){
				m.addAttribute("msg", "首次登陆需要修改密码");
				return "changeTeacher";
			}
			return "/WEB-INF/pages/teacher";
		}
		m.addAttribute("emsg", "账号密码有问题，请确定是否有输入错误。提示：账号为学号，密码初始值为身份证号后6位");
		return "WEB-INF/pages/login";
	}
	/*
	 * 修改老师信息
	 */
	@RequestMapping("/changeTeacher")
	public String changeTeacher(Teacher ns,HttpSession session){
		try{
			if(ns.getIdnumber()=="")
				ns.setIdnumber(null);
			if(ns.getDepartment()!=null){
				if(ns.getDepartment().getDepartmentname()=="全部")
					ns.setDepartment(null);
			}
			if(ns.getName()=="")
				ns.setName(null);
			if(ns.getPassword()=="")
				ns.setPassword(null);
			System.out.println("change:"+ns.toString());
			ts.changeDetail(ns);
			session.setAttribute("teacher", ts.getTeacher(ns));
			return "/WEB-INF/pages/Success";
		}catch(Exception e){
			e.printStackTrace();
			return "changeTeacher";
		}
	}
	/*
	 * 查找我的学生
	 */
	@RequestMapping("findStudent")
	public String findStudent(boolean type,Integer i, ModelMap m){
		m.addAttribute("m_student", ts.findMentorStudent(i,type));
		return "WEB-INF/pages/mentor_StudentInfo";
	}
    /*
     * 查看公告
     * 查出来所有公告
     * 超过截止日期的删除
     */
	    @RequestMapping("/findNotice")
	    public String findNotice(ModelMap m,HttpSession session){
	    	Teacher t = (Teacher) session.getAttribute("teacher");
	    	Notice s = new Notice();
	    	s.setNoticeTo(t.getTeacherid());
	    	s.setNoticeType((byte)1);
	    	m.addAttribute("allNotice",ts.findNotice(s));
	    	return "WEB-INF/pages/noticeContent";
	    }
	    /*
	     * 查看请求
	     */
	    @RequestMapping("/findAllRequest")
	    public String findAllRequest(Request r ,ModelMap m,HttpSession session){
	    	List<Request> lr = ts.getRequest(r);
	    	m.addAttribute("allRequest",lr);
	    	return "WEB-INF/pages/teacherRequest";
	    }
	    /*
	     * 回复请求
	     */
	   @RequestMapping("/responseRequest")
	    public String responseRequest(Request r,ModelMap m,HttpSession session){
		    ts.responseRequest(r);
		    Request temp = new Request();
		    Teacher t = (Teacher) session.getAttribute("teacher");
		    temp.setResponseid(t.getTeacherid());
	    	return findAllRequest(temp,m,session);
	    }
	    /*
	     * 生成请求
	     */
	    @RequestMapping("/addRequest")
	    public String addRequest(Request r){
	    	ts.saveRequest(r);
	    	return "addRequest";
	    }
}
