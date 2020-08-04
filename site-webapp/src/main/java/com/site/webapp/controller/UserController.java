package com.site.webapp.controller;


import com.site.common.vo.UserVo;
import com.site.service.entity.User;
import com.site.service.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
@RequestMapping("/user")
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
    public void getOne(@PathVariable int id){
        if(log.isTraceEnabled()) {
            log.trace("getOne " + id);
        }

    }


    @PostMapping
    public void insertOne(@RequestBody UserVo userVo) {

    }





}

