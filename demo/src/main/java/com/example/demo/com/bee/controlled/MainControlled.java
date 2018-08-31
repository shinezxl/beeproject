package com.example.demo.com.bee.controlled;

import com.bee.model.BeeUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("main")
public class MainControlled {
    @Autowired
    private BeeUser beeUser;
    @RequestMapping("test")
    public String test(@RequestParam("name") String name){
        name=beeUser.getName();
        return "your name is "+name;
    }

    @RequestMapping("getUser")
    public BeeUser getUser(@RequestParam("name") String name){
        BeeUser beeUser = new BeeUser();
        beeUser.setName(name);
        beeUser.setIdCard("88888888");
        return beeUser;
    }
}
