package qmetric.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import qmetric.model.Customer;

import javax.persistence.EntityManagerFactory;

@Repository
@Transactional
public class CustomerService {
    private JpaTemplate jpaTemplate;

    /**
     * This is for Cglib2AopProxy    cleverness 
     */
    CustomerService() {
    }

    @Autowired
    public CustomerService(EntityManagerFactory emf)
    {
        this.jpaTemplate = new JpaTemplate(emf);
    }

    public void save(Customer customer)
    {
        jpaTemplate.persist(customer);
    }
    public void remove(final Customer customer)
    {
        jpaTemplate.remove(customer);
    }
}
