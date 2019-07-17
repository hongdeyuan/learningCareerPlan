package cn.jxufe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.jxufe.bean.Message;
import cn.jxufe.entity.College;
import cn.jxufe.entity.Economy;
import cn.jxufe.entity.MajorMembers;
import cn.jxufe.entity.Student;
import cn.jxufe.entity.Target;
import cn.jxufe.service.CollegeService;
import cn.jxufe.service.EconomyService;
import cn.jxufe.service.MajorMembersService;
import cn.jxufe.service.StudentService;
import cn.jxufe.service.TargetService;
import cn.jxufe.service.TremService;
import cn.jxufe.service.UserService;

@Controller
@RequestMapping("test")
public class TestController {
	@Autowired
	UserService userService;
	@Autowired
	StudentService studentService;
	@Autowired
	TremService tremService;
	@Autowired
	CollegeService collegeService;
	@Autowired
	EconomyService economyService;
	@Autowired
	TargetService targetService;
	@Autowired
	MajorMembersService majorMembersService;
	
	/**
	 * 页面跳转到首页
	 * @return
	 */
	@RequestMapping(value = "/workbench")
	 public String welcome() {
	        return "base/workbench";
	}
	
	/**
	 * 查询学校列表
	 * @return
	 */
	@RequestMapping(value="collegeList",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<College> collegeList(){
        return collegeService.findAll();
    }
	
	/**
	 * 查询经济等级列表
	 * @return
	 */
	@RequestMapping(value="economyList",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Economy> economyList(){
        return economyService.findAll();
    }
	
	/**
	 * 查询毕业目标列表
	 * @return
	 */
	@RequestMapping(value="targetList",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Target> targetList(){
        return targetService.findAll();
    }
	
	/**
	 * 删除一个家庭成员
	 * @param majorMembers实例对象
	 * @param model
	 * @return
	 */
	@RequestMapping(value="deleteMember",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Message deleteMember(Long id,Model model){
        return majorMembersService.delete(id);
    }
	
	@RequestMapping(value="findAllStu",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Student> findAllStu(){
        return studentService.findAll();
    }
	
	@RequestMapping(value="memberList",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<MajorMembers> memberList(){
        return majorMembersService.findAll();
    }
	
	@RequestMapping(value="addMember",produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Message addMember(MajorMembers majorMembers,Model model){
        return majorMembersService.save(majorMembers);
    }
}
