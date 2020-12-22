package TwentyA101.WFIDS.A101.service.Impl;

import TwentyA101.WFIDS.A101.model.User;
import TwentyA101.WFIDS.A101.service.IUserService;
import org.nutz.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IUserServiceImpl implements IUserService {
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
    public User register() {
        return null;
    }

    @Override
    public boolean forget() {
        return false;
    }
}
