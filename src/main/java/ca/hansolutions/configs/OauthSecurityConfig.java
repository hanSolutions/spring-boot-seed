package ca.hansolutions.configs;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableOAuth2Sso
@Profile(value = "oauth")
public class OauthSecurityConfig extends WebSecurityConfigurerAdapter{



    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //customize security to use login form
        http.authorizeRequests().anyRequest().authenticated();

    }
}
