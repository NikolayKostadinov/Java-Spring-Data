package com.example.football.service;

public interface MessageService {
    <T> T addMessage(StringBuilder response, T dto, String additionalMessage);
}
