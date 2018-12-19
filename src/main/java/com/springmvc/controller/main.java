package com.springmvc.controller;

import com.springmvc.pojo.Admin;
import com.springmvc.pojo.Employee;
import com.springmvc.dao.AdminMapper;
import com.springmvc.dao.EmployeeMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;
/*直接dao调用接口中的AdminMapper,和mapping中的xml文件,省掉了service中的AdminService文件*/
@Controller
public class main {

    @Resource
    AdminMapper adminMapper;
    @RequestMapping("/")
    @ResponseBody
    public String index(){
        return "hello world";
    }

    @RequestMapping(value = "/admin",method = RequestMethod.POST)
    @ResponseBody
    public int insertUser(Admin admin){
       return adminMapper.insert(admin);

    }
    @RequestMapping(value = "/admin/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Admin getUser(@PathVariable  Integer id){
        return adminMapper.selectByPrimaryKey(id);

    }
    @RequestMapping(value = "/admin/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public int delUser(@PathVariable  Integer id){
        return adminMapper.deleteByPrimaryKey(id);

    }
    @RequestMapping(value = "/admin",method = RequestMethod.PUT)
    @ResponseBody
    public int upUser(Admin admin){
        return adminMapper.updateByPrimaryKey(admin);

    }
    @RequestMapping(value = "/admin/byname/{name}",method = RequestMethod.GET)
    @ResponseBody
    public List<Admin> getName(@PathVariable  String name){
        return adminMapper.selectByName(name);

    }
    @Resource
    EmployeeMapper employeeMapper;
    @RequestMapping(value = "/employee/",method = RequestMethod.GET)

    public ModelAndView getEmployees(){
        /*查询employee表*/
        List<Employee> items= employeeMapper.selectByExample(null);
        ModelAndView mav = new ModelAndView();
        //数据
        mav.addObject("itemList", items);
        mav.setViewName("itemList");
        return mav;
    }
    /*json数据交互*/
    @RequestMapping(value = "/json.action",method = RequestMethod.POST)
    public @ResponseBody
    Admin json(@RequestBody Admin admin){

		System.out.println(admin);

        return admin;
    }


}
/* 原始类型方法,通过service调用接口dao层AdminMapper在调用mapping xml文件查询数据库
package com.springmvc.controller;

import com.springmvc.pojo.Admin;
import com.springmvc.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class main1 {

    @Resource
    AdminService adminService;
    @RequestMapping("/")
    @ResponseBody
    public String index(){
        return "hello world";
    }

    @RequestMapping(value = "/admin",method = RequestMethod.POST)
    @ResponseBody
    public int insertUser(Admin admin){
       return adminService.insertAdmin(admin);

    }
    @RequestMapping(value = "/admin/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Admin getUser(@PathVariable  Integer id){
        return adminService.getAdmin(id);

    }
    @RequestMapping(value = "/admin/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public int delUser(@PathVariable  Integer id){
        return adminService.delAdmin(id);

    }
    @RequestMapping(value = "/admin",method = RequestMethod.PUT)
    @ResponseBody
    public int upUser(Admin admin){
        return adminService.upAdmin(admin);

    }
    @RequestMapping(value = "/admin/byname/{name}",method = RequestMethod.GET)
    @ResponseBody
    public List<Admin> getName(@PathVariable  String name){
        return adminService.getName(name);

    }
}
*/