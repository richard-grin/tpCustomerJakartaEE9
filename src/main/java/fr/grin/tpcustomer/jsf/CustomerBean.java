package fr.grin.tpcustomer.jsf;

import fr.grin.tpcustomer.ejb.CustomerManager;
import fr.grin.tpcustomer.entities.Customer;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

/**
 * Backing bean pour la page qui liste les Customer.
 * @author grin
 */
@Named(value = "customerBean")
@ViewScoped
public class CustomerBean implements Serializable {
  private List<Customer> customerList;  

  @EJB
  private CustomerManager customerManager;  
        
  public CustomerBean() {  }  
        
  /** 
   * Retourne la liste des clients pour affichage dans une DataTable 
   * @return 
   */  
  public List<Customer> getCustomers() {
    if (customerList == null) {
      customerList = customerManager.getAllCustomers();
    }
    return customerList;
  }
}
