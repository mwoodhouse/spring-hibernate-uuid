package qmetric.repository;

import qmetric.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CustomerService
{
    private HibernateTemplate hibernateTemplate;

    /**
     * This is for cglib
     */
    CustomerService()
    {
    }

    @Autowired
    public CustomerService(final HibernateTemplate hibernateTemplate)
    {
        this.hibernateTemplate = hibernateTemplate;
    }

    public Customer findBy(final String id)
    {
        return hibernateTemplate.get(Customer.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Customer> getAll()
    {
        return hibernateTemplate.find("from Customer customer");
    }

    public void save(Customer customer)
    {
        if (hibernateTemplate.contains(customer))
        {
            hibernateTemplate.merge(customer);
        }
        else
        {
            hibernateTemplate.saveOrUpdate(customer);
        }
    }
}
