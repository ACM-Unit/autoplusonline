package ua.com.autoplus.services;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}