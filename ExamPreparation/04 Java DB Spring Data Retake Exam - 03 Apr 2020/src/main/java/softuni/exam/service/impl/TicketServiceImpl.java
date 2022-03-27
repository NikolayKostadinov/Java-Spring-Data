package softuni.exam.service.impl;

import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.PassengerSeedDto;
import softuni.exam.models.dtos.PlaneSeedRootDto;
import softuni.exam.models.dtos.TicketSeedRootDto;
import softuni.exam.models.entities.Passenger;
import softuni.exam.models.entities.Town;
import softuni.exam.repository.TicketRepository;
import softuni.exam.service.TicketService;
import softuni.exam.util.FileService;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService {
    public static final String TICKETS_FILE_PATH = "src/main/resources/files/xml/tickets.xml";
    private final TicketRepository repository;
    private final FileService fileService;

    public TicketServiceImpl(TicketRepository repository, FileService fileService) {
        this.repository = repository;
        this.fileService = fileService;
    }


    @Override
    public boolean areImported() {
        return repository.count() > 0;
    }

    @Override
    public String readTicketsFileContent() throws IOException {
        return fileService.readString(TICKETS_FILE_PATH);
    }

    @Override
    public String importTickets() throws JAXBException, IOException {
        return this.fileService.readXmlFile(TICKETS_FILE_PATH, TicketSeedRootDto.class)
                .getTickets()
                .stream()
                .map(this::persistIfValid)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    private String persistIfValid(PassengerSeedDto passenger) {
        Optional<Town> town = townService.getByName(passenger.getTown());
        boolean isValid = this.validator.isValid(passenger, this::isUnique) && town.isPresent();
        String message = this.messageService.getMessage(passenger, isValid);

        if (isValid){
            Passenger dbPassenger = this.mapper.map(passenger, Passenger.class);
            dbPassenger.setTown(town.get());
            this.repository.save(dbPassenger);
        }

        return message;
    }

    private boolean isUnique(PassengerSeedDto c) {
        return !repository.existsByEmail(c.getEmail());
    }
}
