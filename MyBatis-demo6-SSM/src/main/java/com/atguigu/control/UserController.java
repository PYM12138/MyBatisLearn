package com.atguigu.control;

import com.atguigu.bean.User;
import com.atguigu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/allUsers")
    public String allUsers(Model model){
        List<User> users = userService.getUsers();
        model.addAttribute("allUserss", users);
        return "success";
    }


}
