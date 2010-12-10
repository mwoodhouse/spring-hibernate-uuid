package qmetric.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import qmetric.model.Customer;
import qmetric.model.InsuranceEnquiry;

import java.util.List;

@Repository
@Transactional
public class InsuranceEnquiryService
{
    private HibernateTemplate hibernateTemplate;

    /**
     * This is for cglib
     */
    InsuranceEnquiryService()
    {
    }

    @Autowired
    public InsuranceEnquiryService(final HibernateTemplate hibernateTemplate)
    {
        this.hibernateTemplate = hibernateTemplate;
    }

    public InsuranceEnquiry findBy(final String id)
    {
        return hibernateTemplate.get(InsuranceEnquiry.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<InsuranceEnquiry> getAll()
    {
        return hibernateTemplate.find("from InsuranceEnquiry enquiry");
    }

    public void save(InsuranceEnquiry insuranceEnquiry)
    {
        if (hibernateTemplate.contains(insuranceEnquiry))
        {
            hibernateTemplate.merge(insuranceEnquiry);
        }
        else
        {
            hibernateTemplate.saveOrUpdate(insuranceEnquiry);
        }
    }

    public void delete(final InsuranceEnquiry enquiry)
    {
        hibernateTemplate.delete(enquiry);
    }
}
