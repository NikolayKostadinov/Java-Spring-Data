package com.manhattan.services.interfaces;

import com.manhattan.models.dtos.UserLoginDto;
import com.manhattan.models.dtos.UserRegisterDto;
import com.manhattan.models.entities.Game;
import com.manhattan.models.entities.User;

import java.util.Set;

public interface UserService {

    String registerUser(UserRegisterDto mode);

    String loginUser(UserLoginDto model);

    String logout();

    boolean isAdminLogged();

    User getCurrentUser();

    String addGamesToUser(Set<Game> games);
}
