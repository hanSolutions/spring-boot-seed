package ca.hansolutions.models;

import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Setter
@Getter
@Document
public class User implements UserDetails {

    @Id
    String id;
    String username;
    String password;
    DateTime createdTime;
    boolean enable;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {


        if("nate".equals(username)){
            return AuthorityUtils.createAuthorityList("ROLE_USER");
        } else if("admin".equals(username)) {

            return AuthorityUtils.createAuthorityList("ROLE_ADMIN", "ROLE_ACTUATOR");
        } else {
            System.out.println("No Role added for this user");
            return null;
        }
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
