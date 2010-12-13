package qmetric.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import qmetric.model.InsuranceEnquiry;

import javax.persistence.EntityManagerFactory;

@Repository
@Transactional
public class EnquiryService {
    private JpaTemplate jpaTemplate;

    /**
     * This is for Cglib2AopProxy    cleverness
     */
    EnquiryService() {
    }

    @Autowired
    public EnquiryService(EntityManagerFactory emf)
    {
        this.jpaTemplate = new JpaTemplate(emf);
    }

    public void save(InsuranceEnquiry enquiry)
    {
        jpaTemplate.persist(enquiry);
    }
    public void remove(final InsuranceEnquiry enquiry)
    {
        jpaTemplate.remove(enquiry);
    }
}
