package com.itheima.actions;

import com.itheima.domain.User;
import com.itheima.service.BusinessService;
import com.itheima.service.impl.BusinessServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.TokenHelper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserAction extends ActionSupport implements ModelDriven<User> {
    private User user = new User();
    private BusinessService businessService;
    private List<User> userList = new ArrayList<>();

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public BusinessService getBusinessService() {
        return businessService;
    }

    public void setBusinessService(BusinessService businessService) {
        this.businessService = businessService;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public String list() {
        //吧list数据放到值站当中
         userList = businessService.findAllUsers();
        return SUCCESS;
    }

    public String login() {
        User logonUser = businessService.login(user.getLogonName(), user.getLogonPwd());
        if (logonUser == null) {
            addActionError("错误的用户名或密码");
            return LOGIN;

        }
        ActionContext.getContext().getSession().put("user", logonUser);

        return SUCCESS;
    }

    @Override
    public User getModel() {
        return user;
    }
}
 