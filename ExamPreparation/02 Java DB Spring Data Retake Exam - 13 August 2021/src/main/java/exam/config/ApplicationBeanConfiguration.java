package exam.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import exam.model.entity.enums.WarrantyType;
import exam.util.MessageService;
import exam.util.impl.MessageServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class ApplicationBeanConfiguration {
    @Bean
    public Gson gson() {
        return new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();

        mapper.addConverter(ctx -> LocalDate.parse(ctx.getSource(), DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                String.class, LocalDate.class);

        mapper.addConverter(ctx -> LocalDateTime.parse(ctx.getSource(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                String.class, LocalDateTime.class);

        mapper.addConverter(ctx -> WarrantyType.valueOf(ctx.getSource()),
                String.class, WarrantyType.class);

        return mapper;
    }
}
