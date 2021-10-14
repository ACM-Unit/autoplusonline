package ua.com.autoplus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.autoplus.entity.Account;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    Account findByUsername(String username);
    Optional<Account> findByUsernameAndPassword(String username,String password);
    Optional<Account> findByToken(String token);
}
