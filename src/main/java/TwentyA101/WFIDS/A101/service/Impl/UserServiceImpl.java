package TwentyA101.WFIDS.A101.service.Impl;

import TwentyA101.WFIDS.A101.model.User;
import TwentyA101.WFIDS.A101.service.IUserService;
import org.nutz.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private Dao dao;

    @Override
    public User isLogin() {
        return null;
    }

    @Override
    public User login() {
        return null;
    }

    @Override
    public boolean logout() {
        return false;
    }

    @Override
    public boolean register(String username, String password) {
        User newuser = new User();
        System.out.println(dao.fetch(User.class,username));
        if (dao.fetch(User.class,username).getId()==null){
            newuser.setId(UUID.randomUUID().toString());
            newuser.setUsername(username);
            newuser.setPassword(password);
            dao.insert(newuser);
            return  true;
        }else {
            return  false;
        }
    }

    @Override
    public boolean forget() {
        return false;
    }
}
