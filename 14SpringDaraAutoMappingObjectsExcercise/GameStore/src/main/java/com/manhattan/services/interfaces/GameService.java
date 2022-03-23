package com.manhattan.services.interfaces;

import com.manhattan.models.dtos.GameAddDto;
import com.manhattan.models.entities.Game;

public interface GameService {
    String add(GameAddDto gameAddDto);

    String editGame(int id, String... values);

    String deleteGame(int id);

    String getAll();

    String getGameDetails(String title);

    Game getGame(String gameTitle);
}
