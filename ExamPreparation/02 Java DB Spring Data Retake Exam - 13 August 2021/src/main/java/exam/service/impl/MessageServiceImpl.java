package exam.service.impl;

import exam.service.MessageService;
import exam.util.MessageName;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {
    @Override
    public <T> String getMessage(T dto, boolean isValid) {
        String message;
        MessageName messageName = dto.getClass().getAnnotation(MessageName.class);
        String entityName = messageName == null ? dto.getClass().getSimpleName() : messageName.name();

        if (isValid) {
            message = String.format("Successfully imported %s %s", entityName, dto.toString());
        } else {
            message = String.format("Invalid %s", entityName);
        }
        return message;
    }
}
