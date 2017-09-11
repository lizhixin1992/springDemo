package com.blue.ssm.controller;

import com.blue.ssm.log.SystemLog;
import com.blue.ssm.service.UserService;
import com.blue.ssm.model.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private Logger logger = Logger.getLogger(UserController.class);
    @Resource
    private UserService userService;


    @RequestMapping("/showUser")
    @SystemLog(operationName = "测试操作",operationType = "1111111")
    public String showUser(HttpServletRequest request, Model model){
        logger.info("查询所有用户信息");
        List<User> userList = userService.getAllUser();
        model.addAttribute("userList",userList);
        return "showUser";
    }
}
