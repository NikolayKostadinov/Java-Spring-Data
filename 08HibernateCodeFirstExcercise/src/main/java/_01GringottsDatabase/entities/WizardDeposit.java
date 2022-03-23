package _01GringottsDatabase.entities;

import Common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "wizard_deposits")
public class WizardDeposit extends BaseEntity<Integer> {

    private String firstName;

    private String lastName;

    private String notes;

    private int age;

    private String magicWandCreator;

    private short magicWandSize;

    private String depositGroup;
    private LocalDateTime depositStartDate;

    private BigDecimal depositAmount;

    private BigDecimal depositInterest;

    private BigDecimal depositCharge;

    private LocalDateTime depositExpirationDate;

    private Boolean depositExpired;

    @Column(name = "first_name", length = 50)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", length = 60, nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(columnDefinition = "TEXT", length = 1000)
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Column(nullable = false)
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Column(name = "magic_wand_creator", length = 100)
    public String getMagicWandCreator() {
        return magicWandCreator;
    }

    public void setMagicWandCreator(String magicWandCreator) {
        this.magicWandCreator = magicWandCreator;
    }

    @Column(name = "magic_wand_size")
    public short getMagicWandSize() {
        return magicWandSize;
    }

    public void setMagicWandSize(short magic_wand_size) {
        this.magicWandSize = magic_wand_size;
    }

    @Column(name = "deposit_group", length = 20)
    public String getDepositGroup() {
        return depositGroup;
    }

    public void setDepositGroup(String deposit_group) {
        this.depositGroup = deposit_group;
    }

    @Column(name = "deposit_start_date", nullable = false)
    public LocalDateTime getDepositStartDate() {
        return depositStartDate;
    }

    public void setDepositStartDate(LocalDateTime deposit_start_date) {
        this.depositStartDate = deposit_start_date;
    }

    @Column(name = "deposit_amount", nullable = false)
    public BigDecimal getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(BigDecimal deposit_amount) {
        this.depositAmount = deposit_amount;
    }

    @Column(name = "deposit_interest", nullable = false)
    public BigDecimal getDepositInterest() {
        return depositInterest;
    }

    public void setDepositInterest(BigDecimal deposit_interest) {
        this.depositInterest = deposit_interest;
    }

    @Column(name = "deposit_charge", nullable = false)
    public BigDecimal getDepositCharge() {
        return depositCharge;
    }

    public void setDepositCharge(BigDecimal deposit_charge) {
        this.depositCharge = deposit_charge;
    }

    @Column(name = "deposit_expiration_date", nullable = false)
    public LocalDateTime getDepositExpirationDate() {
        return depositExpirationDate;
    }

    public void setDepositExpirationDate(LocalDateTime deposit_expiration_date) {
        this.depositExpirationDate = deposit_expiration_date;
    }

    @Column(name = "is_deposit_expired", nullable = false)
    public Boolean getDepositExpired() {
        return depositExpired;
    }

    public void setDepositExpired(Boolean is_deposit_expired) {
        this.depositExpired = is_deposit_expired;
    }

}
