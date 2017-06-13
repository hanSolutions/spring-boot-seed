package ca.hansolutions.listeners;

import ca.hansolutions.models.User;
import ca.hansolutions.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
public class ServerListener implements ServletContextListener {

    private final UserRepository userRepository;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        System.out.println("server context in building up");

        userRepository.deleteAll();
        User user = new User();
        user.setUsername("nate");
        user.setPassword("password");
        userRepository.save(user);

        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword("password");
        userRepository.save(admin);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

        System.out.println("server context is destroying down");

    }
}
