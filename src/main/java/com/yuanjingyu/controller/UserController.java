package com.yuanjingyu.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("/login")
    public String toIndex(String email, String password,String rm, Model model){
        //1.封住前端发送的用户名+密码
        UsernamePasswordToken token = new UsernamePasswordToken(email,password);
        System.out.println(token);
        /*和记住我界面相关联*/
        System.out.println("rm========>"+rm);
        //记住我被勾选
        if (rm!=null && rm.equals("1")){
            token.setRememberMe(true);
        }

        //2.获取当前用户实体类
        Subject subject = SecurityUtils.getSubject();
        //通过实体的login方法将用户名和密码传递到安全管理器
        try {
            subject.login(token);
        }catch (UnknownAccountException uae){//用户名错误异常
            String s = "用户名错误";
            model.addAttribute("s",s);
            return "login";
        }catch (IncorrectCredentialsException ice){//密码错误异常
            String s = "密码错误";
            model.addAttribute("s",s);
            return "login";
        }catch (AuthenticationException ae){//其他认证异常
            String s = "其他错误";
            model.addAttribute("s",s);
            return "login";
        }
        return "book_list";
    }
    /*登录界面*/
    @RequestMapping(value = "/toIndex")
    public String login(){
        return "login";
    }
    /**
     * 跳转未授权界面
     * @return
     */
    @RequestMapping(value = "/toOut")
    public String toOut(){
        System.out.println("这个未是授权的页面...");
        return "out";
    }



}
