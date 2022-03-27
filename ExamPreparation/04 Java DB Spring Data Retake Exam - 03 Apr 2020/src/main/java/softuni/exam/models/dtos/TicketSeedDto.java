package softuni.exam.models.dtos;

import softuni.exam.util.MessageName;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@XmlRootElement(name="ticket")
@XmlAccessorType(XmlAccessType.FIELD)
@MessageName(name="Ticket")
public class TicketSeedDto {

    @XmlElement(name = "serial-number")
    private String serialNumber;

    @XmlElement(name = "price")
    private BigDecimal price;

    @XmlElement(name = "take-off")
    private LocalDateTime takeoff;

    @XmlElement(name = "from-town")
    private TicketTownDto fromTown;

    @XmlElement(name = "to-town")
    private TicketTownDto toTown;

    @XmlElement(name = "passenger")
    private TicketPassengerDto passenger;

    @XmlElement(name = "plane")
    private TicketPlaneDto plane;

    /**
     * A combination from letters and numbers with minimum length of 2 .
     * The serial numbers are unique.
     */
    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     * A price of the ticket. Must be positive.
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * A date and time of plane taking off.
     */
    public LocalDateTime getTakeoff() {
        return takeoff;
    }

    public TicketTownDto getFromTown() {
        return fromTown;
    }

    public TicketTownDto getToTown() {
        return toTown;
    }

    public TicketPassengerDto getPassenger() {
        return passenger;
    }

    public TicketPlaneDto getPlane() {
        return plane;
    }
}
