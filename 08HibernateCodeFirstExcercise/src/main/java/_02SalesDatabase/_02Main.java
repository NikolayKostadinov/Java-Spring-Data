package _02SalesDatabase;

import _02SalesDatabase.entities.Customer;
import _02SalesDatabase.entities.Product;
import _02SalesDatabase.entities.Sale;
import _02SalesDatabase.entities.StoreLocation;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class _02Main {
    public static void main(String[] args) {
        EntityManager dbManager =
                Persistence.createEntityManagerFactory("salesDb")
                        .createEntityManager();


        dbManager.getTransaction().begin();

        Product product = new Product("Socks", 5, BigDecimal.valueOf(1.20));
        Customer customer = new Customer("Baj Ivan", "bay_ivan@test.com", "1234567890");
        StoreLocation storeLocation = new StoreLocation("Pazara");
        Sale sale = new Sale(product, customer, storeLocation);

        dbManager.persist(sale);

        dbManager.getTransaction().commit();

        dbManager.close();
    }
}
