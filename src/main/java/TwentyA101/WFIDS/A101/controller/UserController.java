package TwentyA101.WFIDS.A101.controller;

import TwentyA101.WFIDS.A101.service.IUserService;
import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("/User")
public class UserController {
    @Autowired
    private IUserService userS;

    @RequestMapping("/isLogin")
    public String isLogin(HttpSession session){
        System.out.println(session);
        if(session.getAttribute("isLogin")!=null&&session.getAttribute("isLogin").equals("1")){
            Map data = new HashMap();
            data.put("islogin","1");
            data.put("Username","kqq");

            return Json.toJson(data);
        }else{
            Map data = new HashMap();
            data.put("Username","");
            data.put("islogin","0");
            System.out.println(Json.toJson(data));
            return Json.toJson(data);
        }
    }
}
