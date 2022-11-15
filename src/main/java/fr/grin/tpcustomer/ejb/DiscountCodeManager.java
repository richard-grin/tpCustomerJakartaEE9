package fr.grin.tpcustomer.ejb;

import fr.grin.tpcustomer.entities.DiscountCode;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;

/**
 *
 * @author grin
 */
@Stateless
public class DiscountCodeManager {
    @PersistenceContext
    private EntityManager em;
    
    public List<DiscountCode> getAllDiscountCodes() {
        Query query = em.createNamedQuery("DiscountCode.findAll");
        return query.getResultList();
    }
    
    public DiscountCode findById(String discountCode) {
        return em.find(DiscountCode.class, discountCode);
    }

    public void persist(DiscountCode discountCode) {
        em.persist(discountCode);
    }
    
}
