package TwentyA101.WFIDS.A101.controller;

import TwentyA101.WFIDS.A101.model.User;
import org.nutz.dao.Dao;
import org.nutz.dao.impl.NutDao;
import org.nutz.dao.impl.SimpleDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@RestController
public class HelloController{
    @Autowired
    private Dao dao;

    @GetMapping("/hello")
    public String hello() {
//        List<User> us = dao.query(User.class,null);
//        System.out.println(us.size());
//        System.out.println(us.size());
        return "Hello Spring Boot!"+ UUID.randomUUID().toString();
    }

}