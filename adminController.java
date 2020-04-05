package zjut.lhd.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import zjut.lhd.po.Admin;
import zjut.lhd.po.MentorStudent;
import zjut.lhd.po.MentorStudentKey;
import zjut.lhd.po.Notice;
import zjut.lhd.po.Request;
import zjut.lhd.po.Student;
import zjut.lhd.po.Teacher;
import zjut.lhd.service.adminService;

@Controller
@RequestMapping("/adminController")
//@SessionAttributes(value={"admin","allDepartment"})
public class adminController {
	@Autowired
	private adminService as;
	
//	@ModelAttribute
//	public void setAdmin(ModelMap m ,Admin a){
//		m.addAttribute("newAdmin", a);
//	}
	
	@RequestMapping("/login")
	public String login(Admin s,ModelMap m,HttpSession session ){
		Admin stemp = as.find(s);
		if(stemp!=null && stemp.getPassword().equals(s.getPassword())){
			session.setAttribute("admin",stemp);
			return "/WEB-INF/pages/admin";
		}
		m.addAttribute("msg", "账号密码错误");
		return "WEB-INF/pages/login";
	}
	@RequestMapping("/changeAdmin")
	public String changeAdmin(Admin ns,ModelMap m,HttpSession session ){
		try{
			if(ns.getPassword()=="")
				ns.setPassword(null);
			as.changeDetail(ns);
			session.setAttribute("admin", ns);
			m.addAttribute("msg", "修改成功");
		}catch(Exception e){
			e.printStackTrace();
		}
		return "/WEB-INF/pages/Success";
	}
    /*
     * 查看公告
     * 查出来所有公告
     * 超过截止日期的删除
     */
    @RequestMapping("/findNotice")
    public String findNotice( Notice i,HttpSession session){
    	Notice a = new Notice();
    	session.setAttribute("AllNotice",as.findNotice(a));
    	return "WEB-INF/pages/noticeContent";
    }
    /*
     * 按条件查找老师
     */
    @RequestMapping("/preFindTeacher")
    public String preFindTeacher(HttpSession session){
    	session.setAttribute("allDepartment", as.getAllDepartment());
    	return "allTeacher";
    }
    @RequestMapping("/findTeacher")
    public String findTeacher(Teacher t,ModelMap m){
    	System.out.println("findTeacher"+t.toString());
    	List<Teacher> lt = as.findTeacher(t);
    	m.addAttribute("allTeacher", lt);
    	System.out.println();
    	return "allTeacher";
    }
    /*
     * 按条件查找学生
     */
    @RequestMapping("/findStudent")
    public String findStudent(Student t,ModelMap m,HttpSession session ){
    	Admin a = (Admin) session.getAttribute("admin");
    	t.setGrade(a.getGrade());
    	m.addAttribute("allStudent", as.findStudent(t));
    	return "/WEB-INF/pages/Success";
    }
    /*
     * 查看第一轮双向选择
     */
    @RequestMapping("/findFirstChoose")
    public String findFirstChoose(ModelMap m,HttpSession session){
    	Admin a = (Admin) session.getAttribute("admin");
    	m.addAttribute("firstChoose",as.findFirstChoose(a.getGrade()));
    	return "WEB-INF/pages/firstChooseFinal";
    }
    /*
     * 查看第一轮双向选择
     */
    @RequestMapping("/findSecondChoose")
    public String findSecondChoose(ModelMap m,HttpSession session ){
    	Admin a = (Admin) session.getAttribute("admin");
    	m.addAttribute("secondChoose",as.findSecondChoose(a.getGrade()));
    	return "WEB-INF/pages/secondChooseFinal";
    }
    /*
     * 对老师生成快速处理的提示
     */
    @RequestMapping("/GenerateRequestToTeacher")
    public String GenerateRequestToTeacher(Integer teacherid,ModelMap m,HttpSession session ){
    	Admin a = (Admin)session.getAttribute("admin");
    	as.createRequestToTeacher(a.getAdminid(),teacherid,"请快速处理学生的请求");
    	return "addRequest";
    }
    /*
     * 生成通知
     */
    @RequestMapping("/generateRequest")
    public String generateRequest(ModelMap m,Integer rqid,byte rqtype,Integer rpid,byte rptype,String message){
    	as.createRequestTo(rqid,rqtype,rpid,rptype,message);
    	System.out.println("发送成功");
    	return "addRequest";
    }
    
    /*
     * 生成导师生关系
     * 删除数据库中的请求数据后存入导师生关系
     */
    @RequestMapping("/generateMentor")
    public String generateMentor(Request r){
    	as.generateMentor(r);
    	return "/WEB-INF/pages/Success";
    }
    /*
     * 管理员直接批量调度导师关系
     */
    @RequestMapping("/arrangeMentor")
    public String arrangeMentor(@RequestParam("studentid") List<Integer> studentid,@RequestParam("teacherid")List<Integer> teacherid,@RequestParam("type")boolean type){
    	as.arrangeMentor(studentid, teacherid, type);
    	System.out.println("安排成功");
    	return "/WEB-INF/pages/Success";
    }
    /*
     * 开始第一轮选择
     * 生成学生的第一次请求
     */
    @RequestMapping("/startFirstChoose")
    public String startFirstChoose(HttpSession session){
    	Student s = new Student();
    	Admin a = (Admin) session.getAttribute("admin");
    	s.setGrade(a.getGrade());
    	as.createFirstRequest(s);
    	return "/WEB-INF/pages/Success";
    }
    /*
     * 开始第二轮选择
     * 生成学生的第二次请求
     */
    @RequestMapping("/startSecondChoose")
    public String startSecondChoose(){
    	as.createSecondRequest();
    	return "/WEB-INF/pages/Success";
    }
    /*
     * 结果公示
     * 参数是公示时间，单位是天
     */
    @RequestMapping("/generateFinalNotice")
    public String generateFinalNotice(int a,HttpSession session){
    	as.createMentorNotice(a);
    	session.setAttribute("allNotice", as.findNotice(new Notice()));
    	return "WEB-INF/pages/noticeContent";
    }
    @RequestMapping("/generateNotice")
    public String generateFinalNotice(Notice n,HttpSession session){
    	as.createNotice(n);
    	session.setAttribute("allNotice", as.findNotice(new Notice()));
    	return "WEB-INF/pages/noticeContent";
    }
    /*
     * 查看请求
     */
    @RequestMapping("/findAllRequest")
    public String findAllRequest(ModelMap m){
    	Request r = new Request();
    	r.setResponseType((byte) 2);
    	List<Request> lr = as.getALLRequest(r);
    	m.addAttribute("allRequest",lr);
    	return "WEB-INF/pages/adminRequest";
    }
    @RequestMapping("/responseRequest")
    public String responseRequest(Request r,ModelMap m){
    	as.responseRequest(r);
    	return "WEB-INF/pages/adminRequest";
    }
    /*
     * 再分配前
     */
    @RequestMapping("/preArrange")
    public String preArrange(MentorStudent ms,ModelMap m,HttpSession session){
    	Admin a = (Admin) session.getAttribute("admin");
    	m.addAttribute("leftStudent", as.leftStudent(a.getGrade(),ms.getMentorType()));
    	m.addAttribute("leftTeacher", as.leftTeacher());
    	return "WEB-INF/pages/mentorArrange";
    }
    
}
