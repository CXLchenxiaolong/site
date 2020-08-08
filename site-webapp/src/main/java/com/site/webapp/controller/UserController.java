package com.site.webapp.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.site.common.page.PageVo;
import com.site.common.req.UserReq;
import com.site.common.vo.UserVo;
import com.site.service.entity.User;
import com.site.service.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cxl
 * @since 2020-08-04
 */
@Slf4j
@Controller
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping
    public List<UserVo> getAll() {
        if(log.isTraceEnabled()) {
            log.trace("getAll() ");
        }
        List<UserVo> vos = new ArrayList<>();
        List<User> users = userService.list();
        for(User param:users){
            UserVo vo = new UserVo();
            vo.setName(param.getName());
            vo.setId(param.getId());
            vo.setPwd(param.getPwd());
            vos.add(vo);
        }
        return vos;
    }

    @GetMapping("/{id}")
    public UserVo getOne(@PathVariable int id){
        if(log.isTraceEnabled()) {
            log.trace("getOne " + id);
        }
        User user = userService.getById(id);
        UserVo vo = new UserVo();
        vo.setName(user.getName());
        vo.setId(user.getId());
        vo.setPwd(user.getPwd());
        return vo;
    }


    @PostMapping("/queryByPage")
    public PageVo queryByPage(){
        int pageNo = 1;
        int pageSize = 1;
        IPage<User> page = new Page<>(pageNo, pageSize);
        userService.page(page,null);
        return  new PageVo<>(page.getCurrent(),page.getSize(),page.getTotal(),page.getRecords());
    }


    @PostMapping
    public Boolean insertOne(@RequestBody UserReq req) {
        User user = new User();
        user.setName(req.getName());
        user.setPwd(req.getPwd());
        return userService.save(user);
    }





}

