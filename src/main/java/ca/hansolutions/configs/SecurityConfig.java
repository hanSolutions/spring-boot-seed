package ca.hansolutions.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity
//this annotation enables @PreAuthorize annotation in resources controller
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Profile(value = "default")
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //customize security to use login form
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/login", "/health").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasRole("USER")
                .anyRequest().authenticated().and()
                .formLogin().loginPage("/login").successForwardUrl("/home")
                .usernameParameter("username").passwordParameter("password")
        .and()
                .logout().logoutSuccessUrl("/login?logout");

    }

}
