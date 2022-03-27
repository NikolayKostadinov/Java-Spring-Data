package softuni.exam.models.dtos;

import javax.xml.bind.annotation.XmlElement;

public class TicketPassengerDto {
    @XmlElement(name = "email")
    private String email;

    public String getEmail() {
        return email;
    }
}
