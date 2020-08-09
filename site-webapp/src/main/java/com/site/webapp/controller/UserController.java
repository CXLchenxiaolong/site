package com.site.webapp.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.site.common.page.PageVo;
import com.site.common.req.UserReq;
import com.site.common.vo.UserVo;
import com.site.service.entity.User;
import com.site.service.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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
@RestController
@Api(tags = "用户模块")
@RequestMapping("/api/v1/user")
public class UserController extends BaseController{

    @Autowired
    private UserService userService;


    @GetMapping
    @ApiOperation(value = "获取所有用户", notes = "查询所有")
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

    @ApiOperation(value = "查询单个用户", notes = "查询单个用户")
    @ApiImplicitParam(name = "id", value = "用户的唯一标识", required = true, dataType = "int")
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


    @ApiOperation(value = "分页查询用户", notes = "分页查询用户")
    @PostMapping("/queryByPage")
    public PageVo queryByPage(){
        int pageNo = 1;
        int pageSize = 1;
        IPage<User> page = new Page<>(pageNo, pageSize);
        userService.page(page,null);
        return  new PageVo<>(page.getCurrent(),page.getSize(),page.getTotal(),page.getRecords());
    }



    @PostMapping
    @ApiOperation(value = "添加用户", notes = "添加用户")
    public Boolean insertOne(@RequestBody UserReq req) {
        User user = new User();
        user.setName(req.getName());
        user.setPwd(req.getPwd());
        return userService.save(user);
    }





}

