package com.site.webapp.controller;

import com.site.common.constants.SystemConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 基础controller
 */
@Component
public class BaseController {



    @Autowired
    HttpServletRequest request;


    /**
     * 获取用户信息
     * @return
     */
    public Object getUserInfo(){
        return  request.getSession().getAttribute(SystemConstants.USER_INFO);
    }



}
