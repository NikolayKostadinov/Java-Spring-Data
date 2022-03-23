package _05BillsPaymentSystem.entities;

import Common.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name="billing_details")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BillingDetail {
    int id;
    int number;
    User owner;

    public BillingDetail(int number, User owner) {
        this.number = number;
        this.owner = owner;
    }

    public BillingDetail() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @ManyToOne
    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
