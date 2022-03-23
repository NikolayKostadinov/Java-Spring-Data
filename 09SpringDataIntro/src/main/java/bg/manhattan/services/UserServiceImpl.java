package bg.manhattan.services;

import bg.manhattan.models.User;
import bg.manhattan.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void registerUser(User user) {
        //Optional<User> found = this.userRepository.findByUsername(user.getUsername());
        if (!this.userRepository.existsByUsername(user.getUsername())) {
            this.userRepository.save(user);
        }
    }
}
