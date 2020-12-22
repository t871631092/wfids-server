package TwentyA101.WFIDS.A101.controller;

import TwentyA101.WFIDS.A101.model.User;
import TwentyA101.WFIDS.A101.service.IUserService;
import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("/User")
public class UserController {
    @Autowired
    private IUserService userS;
    @RequestMapping("/islogin")
    public String isLogin(HttpSession session){
        System.out.println(session);
        if(session.getAttribute("islogin")!=null&&session.getAttribute("islogin").equals("1")){
            Map data = new HashMap();
            data.put("islogin","1");
            data.put("username",session.getAttribute("username"));
            return Json.toJson(data);
        }else{
            Map data = new HashMap();
            data.put("Username","");
            data.put("islogin","0");
            System.out.println(Json.toJson(data));
            return Json.toJson(data);
        }
    }
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(@RequestBody Map<String,Object> user,HttpSession session){
        boolean u = userS.register(user.get("username").toString(),user.get("password").toString());
        System.out.println(user.get("username").toString()+user.get("password").toString());
        Map data = new HashMap();
        if (u){
            if(userS.login(user.get("username").toString(),user.get("password").toString())){
                session.setAttribute("islogin","1");
                session.setAttribute("username",user.get("username").toString());
                data.put("success","1");
                data.put("islogin","1");
                data.put("username",user.get("username").toString());
            }else{
                session.setAttribute("islogin","0");
                data.put("msg","未知错误");
                data.put("success","0");
                data.put("islogin","0");
            }
        }else{
            session.setAttribute("islogin","0");
            data.put("msg","用户名输入错误");
            data.put("success","0");
            data.put("islogin","0");
        }
        return Json.toJson(data);
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestBody Map<String,Object> user,HttpSession session){
        Map data = new HashMap();
        if(userS.login(user.get("username").toString(),user.get("password").toString())){
            session.setAttribute("islogin","1");
            session.setAttribute("username",user.get("username").toString());
            data.put("success","1");
            data.put("islogin","1");
            data.put("username",user.get("username").toString());
        }else{
            session.setAttribute("islogin","0");
            data.put("msg","用户名密码错误");
            data.put("success","0");
            data.put("islogin","0");
        }
        return Json.toJson(data);
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.setAttribute("islogin","0");
        session.setAttribute("username","");
        Map data = new HashMap();
        data.put("success","1");
        data.put("islogin","0");
        return Json.toJson(data);
    }
}
