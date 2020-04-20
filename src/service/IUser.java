package service;

import model.LoginUser;

public interface IUser {
    LoginUser findUserLogin(String email,String password);
}
