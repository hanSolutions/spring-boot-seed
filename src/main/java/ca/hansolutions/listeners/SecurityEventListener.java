package ca.hansolutions.listeners;

import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.stereotype.Component;

@Component
public class SecurityEventListener implements ApplicationListener<AbstractAuthenticationFailureEvent> {

    @Override
    public void onApplicationEvent(AbstractAuthenticationFailureEvent authenticationFailureEvent) {

        System.out.println(authenticationFailureEvent.getException().getMessage());

    }
}
