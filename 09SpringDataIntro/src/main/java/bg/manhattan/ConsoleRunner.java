package bg.manhattan;

import bg.manhattan.models.User;
import bg.manhattan.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleRunner implements CommandLineRunner {
    @Autowired
    private UserService userService;
    @Override
    public void run(String... args) throws Exception {
        User firstUser = new User("Kolio", 22);
        userService.registerUser(firstUser);

        User secondUser = new User("Kolio", 22);
        userService.registerUser(secondUser);
    }
}
