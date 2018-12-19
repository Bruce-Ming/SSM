package com.springmvc.pojo; 

import com.springmvc.dao.EmployeeMapper;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/** 
* Employee Tester. 
* 
* @author <Authors name> 
* @since <pre>12/17/2018</pre> 
* @version 1.0 
*/ 
public class EmployeeTest { 

/*测试EmployeeExample功能*/
@Test
public void testSetPwd() throws Exception {
    ApplicationContext ac=new ClassPathXmlApplicationContext("spring-mybatis.xml");
    EmployeeMapper employeeMapper=ac.getBean(EmployeeMapper.class);
    EmployeeExample employeeExample=new EmployeeExample();
    String name="ming";
    /*用EmployeeExample添加查询条件,再添加模糊查询条件*/
    employeeExample.createCriteria().andEmailEqualTo("435@qq,com").andNameLike("%"+name+"%").andGradeEqualTo(2);
    /*设置排序*/
    employeeExample.setOrderByClause("id desc");
    /*统计总和*/
    long countByExample= employeeMapper.countByExample(employeeExample);
    System.out.println(countByExample);
    /*按照条件查询*/
    Employee employee=employeeMapper.selectByPrimaryKey(5);
    System.out.println(employee);
    /*输出employeeExample的查询结果*/
    List<Employee> employees =employeeMapper.selectByExample(employeeExample);
    for (Employee employees2:employees) {
        System.out.println(employees2.getId());
        /*System.out.println(employees2.getDepartmentId());
        System.out.println(employees2.getEmail());
        System.out.println(employees2.getGrade());
        System.out.println(employees2.getHiredate());*/
        System.out.println(employees2.getName());
    }
    /*更新update,删除deleteByExample,保存insert*/
    //employeeMapper.insert();
} 




} 
