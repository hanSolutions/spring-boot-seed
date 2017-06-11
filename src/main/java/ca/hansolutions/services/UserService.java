package ca.hansolutions.services;

import ca.hansolutions.models.User;
import ca.hansolutions.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User addUser(User user){

        user.setCreatedTime(new DateTime());
        return userRepository.save(user);
    }

    public User getUser(String username){

        return userRepository.getByUsername(username);
    }
}
