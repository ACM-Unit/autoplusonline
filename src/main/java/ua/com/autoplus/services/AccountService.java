package ua.com.autoplus.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ua.com.autoplus.entity.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService extends UserDetailsService {
    Account save(String username, String password, String email, String phone);

    Account findById(Integer userId);

    List<Account> allUsers();

    boolean deleteUser(Integer userId);

    Account login(String username, String password);

    Optional findByToken(String token);

}
