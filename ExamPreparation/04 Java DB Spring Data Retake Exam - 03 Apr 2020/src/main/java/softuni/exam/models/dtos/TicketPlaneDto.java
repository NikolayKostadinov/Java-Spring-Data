package softuni.exam.models.dtos;

import javax.xml.bind.annotation.XmlElement;

public class TicketPlaneDto {
    @XmlElement(name="register-number")
    private String registerNumber;

    public String getRegisterNumber() {
        return registerNumber;
    }
}
