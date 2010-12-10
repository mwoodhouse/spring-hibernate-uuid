package qmetric.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import qmetric.model.InsuranceEnquiry;
import qmetric.model.InsuranceQuote;

import java.util.List;

@Repository
@Transactional
public class InsuranceQuoteService
{
    private HibernateTemplate hibernateTemplate;

    /**
     * This is for cglib
     */
    InsuranceQuoteService()
    {
    }

    @Autowired
    public InsuranceQuoteService(final HibernateTemplate hibernateTemplate)
    {
        this.hibernateTemplate = hibernateTemplate;
    }

    public InsuranceQuote findBy(final String id)
    {
        return hibernateTemplate.get(InsuranceQuote.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<InsuranceQuote> getAll()
    {
        return hibernateTemplate.find("from InsuranceQuote quote");
    }

    public void save(InsuranceQuote insuranceQuote)
    {
        if (hibernateTemplate.contains(insuranceQuote))
        {
            hibernateTemplate.merge(insuranceQuote);
        }
        else
        {
            hibernateTemplate.saveOrUpdate(insuranceQuote);
        }
    }
}
