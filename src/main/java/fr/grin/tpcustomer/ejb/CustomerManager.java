package fr.grin.tpcustomer.ejb;

import fr.grin.tpcustomer.entities.Customer;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;

/**
 * Gère la persistance des Customers.
 */
@Stateless
public class CustomerManager {

    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;

    public void persist(Customer customer) {
        em.persist(customer);
    }

    public List<Customer> getAllCustomers() {
        Query query = em.createNamedQuery("Customer.findAll");
        return query.getResultList();
    }

    public Customer update(Customer customer) {
        return em.merge(customer);
    }

    public Customer getCustomer(int idCustomer) {
        return em.find(Customer.class, idCustomer);
    }
}
