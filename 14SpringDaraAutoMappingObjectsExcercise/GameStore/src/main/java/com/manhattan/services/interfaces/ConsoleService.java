package com.manhattan.services.interfaces;

import java.io.IOException;

public interface ConsoleService {
    String readStringFromConsole(String message) throws IOException;

    int readIntFromConsole(String message) throws IOException;

    void printMessage(String message);

    void printResultMessage(String message);

    void printInfoMessage(String message);

    void printErrorMessage(String message);

    void printSuccessMessage(String message);

    void holdUntilKeyPressed() throws IOException;
}
