package ua.com.autoplus.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "ap_role")
public class Role implements GrantedAuthority {
    @Id @NonNull
    private Integer id;
    @NonNull
    private String name;
    @Transient
    @ManyToMany(mappedBy = "roles")
    private Set<Account> users;
    @Override
    public String getAuthority() {
        return getName();
    }
}
