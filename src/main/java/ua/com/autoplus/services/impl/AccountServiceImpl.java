package ua.com.autoplus.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.com.autoplus.entity.Account;
import ua.com.autoplus.entity.Role;
import ua.com.autoplus.repositories.AccountRepository;
import ua.com.autoplus.repositories.RoleRepository;
import ua.com.autoplus.services.AccountService;

import java.util.*;
import java.util.stream.Collectors;

@Service("customerService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private RoleRepository roleRepository;
    private static final Integer ADMIN_ROLE_ID = Integer.valueOf(2);

    public Account save(String username, String password, String email, String phone) {
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        account.setEmail(email);
        account.setPhone(phone);
        Set<Role> set = new HashSet<>();
        set.add(roleRepository.findById(ADMIN_ROLE_ID).get());
        String token = UUID.randomUUID().toString();
        account.setToken(token);
        account.setRoles(set);
        accountRepository.saveAndFlush(account);
        return account;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account user = accountRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }

    public Account findById(Integer userId) {
        Optional<Account> userFromDb = accountRepository.findById(userId);
        return userFromDb.orElse(new Account());
    }

    public List<Account> allUsers() {
        return accountRepository.findAll();
    }


    public boolean deleteUser(Integer userId) {
        if (accountRepository.findById(userId).isPresent()) {
            accountRepository.deleteById(userId);
            return true;
        }
        return false;
    }

    public Account login(String username, String password) {
        Optional optional = accountRepository.findByUsernameAndPassword(username, password);
        if (optional.isPresent()) {
            String token = UUID.randomUUID().toString();
            Account account = (Account) optional.get();
            account.setToken(token);
            accountRepository.save(account);
            return account;
        }
        return null;
    }

    public Optional findByToken(String token) {
        Optional customer = accountRepository.findByToken(token);
        if (customer.isPresent()) {
            Account account = (Account) customer.get();
            List<GrantedAuthority> authorities = account.getRoles().stream().map(
                    role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
            Account user = new Account(account.getUsername(), account.getPassword(), true, true, true, true,
                    authorities);
            return Optional.of(user);
        }
        return Optional.empty();
    }


}
