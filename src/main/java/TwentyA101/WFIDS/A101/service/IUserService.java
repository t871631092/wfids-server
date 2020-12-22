package TwentyA101.WFIDS.A101.service;

import TwentyA101.WFIDS.A101.model.User;

public interface IUserService {
    User isLogin();
    User login();
    boolean logout();
    User register();
    boolean forget();
}
