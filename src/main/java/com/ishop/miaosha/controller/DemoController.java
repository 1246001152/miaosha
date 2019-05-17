package com.ishop.miaosha.controller;

import com.ishop.miaosha.domain.User;
import com.ishop.miaosha.result.CodeMsg;
import com.ishop.miaosha.result.Result;
import com.ishop.miaosha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping("/")
    @ResponseBody
    public String home(){
        return "helloworld";
    }
    @RequestMapping("/hello")
    @ResponseBody
    public Result<String> hello(){
//        return new Result(0,"success","ishop_hot");
        return Result.success("ishop_hot");
    }
    @RequestMapping("/helloError")
    @ResponseBody
    public Result helloError(){
//        return new Result(500100,"session失效");
//        return new Result(500101,"sessionXX");
//        return new Result(500102,"sessionXXXX");
        return Result.error(CodeMsg.SERVER_ERROR);
    }
    @RequestMapping("/thymeleaf")
    public String thymeleaf(Model model){
        model.addAttribute("name","zhangjinfei");
        return "hello";
    }

    @Autowired
    UserService userService;

    @RequestMapping("/db/getuser")
    @ResponseBody
    public Result<User> getUserById(@RequestParam(value = "id",required = false)Integer id){
        User user = userService.getUserById(id == null ? 1 : id);
        return Result.success(user);
    }

    @RequestMapping("/db/tx")
    @ResponseBody
    public Result<Boolean> tx(){
        boolean flg= userService.tx();
        return Result.success(flg);
    }
}
