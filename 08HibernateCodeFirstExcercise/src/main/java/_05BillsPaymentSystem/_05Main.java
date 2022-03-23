package _05BillsPaymentSystem;

import _04HospitalDatabase.AppEngine;
import _05BillsPaymentSystem.entities.BankAccount;
import _05BillsPaymentSystem.entities.BillingDetail;
import _05BillsPaymentSystem.entities.CreditCard;
import _05BillsPaymentSystem.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.HashSet;
import java.util.Set;

public class _05Main{
    public static void main(String[] args) {
        EntityManager dbManager =
                Persistence.createEntityManagerFactory("billsPaymentDB")
                        .createEntityManager();
        User user = new User("Pesho", "Peshev", "test@test.com","P@ssw0rd");
        Set<BillingDetail>billingDetails = new HashSet<>();
        billingDetails.add(new CreditCard(1, user, "Visa", (byte) 12, 2030));
        billingDetails.add(new BankAccount(2, user, "Raiffeisen Bank", "BG 123456566677"));
        user.setBillingDetails(billingDetails);
        dbManager.getTransaction().begin();
        dbManager.persist(user);
        dbManager.getTransaction().commit();
        dbManager.close();
    }
}