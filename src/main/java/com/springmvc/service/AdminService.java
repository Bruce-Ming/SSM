package com.springmvc.service;

import com.springmvc.dao.AdminMapper;
import com.springmvc.pojo.Admin;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("AdminService")

public class AdminService {
    @Resource
    private AdminMapper adminMapper;


    public Admin getAdmin(int id){
        Admin a=this.adminMapper.selectByPrimaryKey(id);
        if(a!=null){
            return a;
        }
        return null;
    }

    public int insertAdmin(Admin admin){
        return this.adminMapper.insert(admin);
    }
    public int delAdmin(int id){
        return this.adminMapper.deleteByPrimaryKey(id);
    }
    public int upAdmin(Admin admin){
        return  this.adminMapper.updateByPrimaryKeySelective(admin);
    }
    public List<Admin> getName(String name ){
        return  this.adminMapper.selectByName(name);
    }

}
