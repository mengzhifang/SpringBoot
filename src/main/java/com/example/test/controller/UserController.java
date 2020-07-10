package com.example.test.controller;

import com.example.test.bean.ResObject;
import com.example.test.bean.UserBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;



@Api(description = "用户接口")
@RestController
@RequestMapping("/user")
public class UserController {
    @ApiOperation(value = "新增用户" ,  notes="新增注册")
    @RequestMapping(value="/createUser",method=RequestMethod.POST,consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResObject createUser(@RequestBody UserBean user){
        System.out.println("createUser:::"+user.toString());
        return new ResObject(HttpStatus.OK.value(), "新增成功.");
    }

    @ApiOperation(value = "修改用户" ,  notes="修改用户")
    @RequestMapping(value="/updateUser",method=RequestMethod.POST,consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResObject updateUser(@RequestBody UserBean user){
        System.out.println("updateUser:::"+user.toString());
        return new ResObject(HttpStatus.OK.value(), "修改成功.");
    }

    @ApiOperation(value = "删除用户" ,  notes="删除用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户标识", required = true, paramType = "query", dataType = "int")
    })
    @RequestMapping(value="/deleteUser",method=RequestMethod.DELETE)
    public ResObject deleteUser(@RequestParam("id") int id){
        System.out.println("deleteUser:::"+id);
        return new ResObject(HttpStatus.OK.value(), "删除成功.");
    }

    @ApiOperation(value = "查询用户" ,  notes="查询用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户标识", required = true, paramType = "query", dataType = "int")
    })
    @RequestMapping(value="/queryUser",method=RequestMethod.GET)
    public ResObject queryUser(@RequestParam("id") int id){
        System.out.println("queryUser:::"+id);
        UserBean user = new UserBean();
        return new ResObject(HttpStatus.OK.value(), user);
    }
}
