package com.manhattan.services.interfaces;

import com.manhattan.models.entities.Game;
import com.manhattan.models.entities.User;

import java.util.Set;

public interface OrderService {
    String addToOrder(Game game, User user);

    String removeFromOrder(Game game, User user);

    Set<Game> buyItems(User user);
}
