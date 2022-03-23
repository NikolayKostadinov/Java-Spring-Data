package _05BillsPaymentSystem.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="bank_accounts")
public class BankAccount extends BillingDetail {
    private String name;
    private String SWIFT;

    public BankAccount() {
    }

    public BankAccount(int number, User owner, String name, String SWIFT) {
        super(number, owner);
        this.name = name;
        this.SWIFT = SWIFT;
    }

    @Column(name="bank_name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="swift_code", nullable = false)
    public String getSWIFT() {
        return SWIFT;
    }

    public void setSWIFT(String SWIFT) {
        this.SWIFT = SWIFT;
    }
}
