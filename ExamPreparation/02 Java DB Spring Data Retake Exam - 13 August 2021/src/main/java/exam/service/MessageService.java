package exam.service;

public interface MessageService {
    <T> String getMessage(T dto, boolean isValid);
}
