package com.inet.code.controller;


import com.inet.code.service.UserService;
import com.inet.code.utlis.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 基础操作
 * @author HCY
 * @since 2020-11-14
 */
@RestController
@RequestMapping("/based")
@Api(tags = {"管理和用户页面的基础操作"},description = "通用模块")
public class Base {
    @Resource
    private UserService userService;

    /**
     * 登录操作
     * @author HCY
     * @since 2020-11-14
     * @param account 账号等同于邮箱
     * @param password 密码
     * @return Result风格的返回值
     */
    @ApiOperation("登录操作")
    @ApiImplicitParams({
            @ApiImplicitParam(name="Account",value="账号等同于邮箱",dataType="String", paramType = "query"),
            @ApiImplicitParam(name="Password",value="密码",dataType="String", paramType = "query"),
    })
    @PostMapping("/login")
    public Result getLogin(@RequestParam(value = "Account",defaultValue = "") String account,
                           @RequestParam(value = "Password",defaultValue = "") String password){
        return userService.getLogin(account,password,"/scratch/based/login");
    }

    /**
     * 退出操作
     * @author HCY
     * @since 2020-11-14
     * @param token 令牌
     * @return Result风格的返回值
     */
    @ApiOperation("退出操作")
    @GetMapping("/exit")
    @RequiresRoles(logical = Logical.OR,value = {"admin","member"})
    public Result getExit(@RequestHeader(value = "Token",defaultValue = "") String token){
        return userService.getExit(token,"/scratch/based/exit");
    }

}