package _05BillsPaymentSystem.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "credit_cards")
public class CreditCard extends BillingDetail {
    private String cardType;
    private byte expirationMonth;
    private int expirationYear;

    public CreditCard() {
    }


    public CreditCard(int number, User owner, String cardType, byte expirationMonth, int expirationYear) {
        super(number, owner);
        this.cardType = cardType;
        this.expirationMonth = expirationMonth;
        this.expirationYear = expirationYear;
    }

    @Column(name="card_type", nullable = false)
    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    @Column(name="expiration_month", nullable = false)
    public byte getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(byte expirationMonth) {
        if (expirationMonth < 1 || expirationMonth > 12) {
            throw new IllegalArgumentException("The value of the `expirationMonth` must be between 1 and 12");
        }
        this.expirationMonth = expirationMonth;
    }

    @Column(name="expiration_year", nullable = false)
    public int getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(int expirationYear) {
        if (expirationYear < 0) {
            throw new IllegalArgumentException("The value of the `expirationYear` must be positive");
        }
        this.expirationYear = expirationYear;
    }
}
