package softuni.exam.models.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name="tickets")
@XmlAccessorType(XmlAccessType.FIELD)
public class TicketSeedRootDto {
    @XmlElement(name="ticket")
    private final List<TicketSeedDto> ticks;

    public TicketSeedRootDto() {
        this.ticks = new ArrayList<>();
    }

    public List<TicketSeedDto> getTicks() {
        return ticks;
    }
}
