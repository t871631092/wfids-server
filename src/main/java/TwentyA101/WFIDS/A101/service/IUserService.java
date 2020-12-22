package TwentyA101.WFIDS.A101.service;

import TwentyA101.WFIDS.A101.model.User;

public interface IUserService {
    User isLogin();
    boolean login(String username, String password);
    boolean logout();
    boolean register(String username, String password);
    boolean forget();
}
