package qmetric.model;

import qmetric.repository.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import qmetric.repository.InsuranceEnquiryService;
import qmetric.repository.InsuranceQuoteService;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class) @ContextConfiguration(locations = {"classpath:spring/spring-context.xml"})
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = false)
@Transactional
public class IntegrationTest
{
    @Autowired
    private CustomerService customerService;

    @Autowired
    private InsuranceEnquiryService insuranceEnquiryService;

    @Autowired
    private InsuranceQuoteService insuranceQuoteService;

    @Test
    public void shouldPersistInsuranceEnquiry()
    {
        final Customer customer = createCustomerAndValidatePersistence();

        System.out.println(customer);

        final InsuranceEnquiry enquiry1 = createEnquiry();
        final InsuranceQuote quote1 = createQuoteWithClassDetails(1);
        final InsuranceQuote quote2 = createQuoteWithClassDetails(2);
        final InsuranceQuote quote3 = createQuoteWithClassDetails(3);
        final InsuranceQuote quote4 = createQuoteWithClassDetails(4);
        final InsuranceQuote quote5 = createQuoteWithClassDetails(5);
        associate(enquiry1, quote1, quote2,quote3, quote4, quote5);

        final InsuranceEnquiry enquiry2 = createEnquiry();
        final InsuranceQuote quote21 = createQuoteWithClassDetails(21);
        final InsuranceQuote quote22 = createQuoteWithClassDetails(22);
        final InsuranceQuote quote23 = createQuoteWithClassDetails(23);
        final InsuranceQuote quote24 = createQuoteWithClassDetails(24);
        final InsuranceQuote quote25 = createQuoteWithClassDetails(25);
        associate(enquiry2, quote21, quote22,quote23, quote24, quote25);

        persistEnquiryAndValidate(enquiry2);

        associate(customer, enquiry1);
        associate(customer, enquiry2);

        customerService.save(customer);

        System.out.println(customer);

        customer.deleteInsuranceEnquiry(enquiry2);

        customerService.save(customer);

        System.out.println(customer);
    }

    private void persistEnquiryAndValidate(final InsuranceEnquiry enquiry)
    {
        insuranceEnquiryService.save(enquiry);

        assertThat(enquiry.getId(), notNullValue());
    }

    private InsuranceQuote createQuoteWithClassDetails(int ref)
    {
        Set<ClassDetail> classDetails = new HashSet<ClassDetail>();

        ClassDetail classDetailA = new ClassDetail("desc A " + ref, 100D);
        classDetails.add(classDetailA);
        ClassDetail classDetailB = new ClassDetail("desc B" + ref, 120D);
        classDetails.add(classDetailB);
        ClassDetail classDetailC = new ClassDetail("desc C" + ref, 30.95D);
        classDetails.add(classDetailC);

        return new InsuranceQuote(classDetails);
    }

    private void associate(final Customer customer, final InsuranceEnquiry enquiry)
    {
        customer.addInsuranceEnquiry(enquiry);

        customerService.save(customer);
    }

    private void associate(final InsuranceEnquiry enquiry, final InsuranceQuote... quotes)
    {
        for(InsuranceQuote quote : quotes)
        enquiry.addInsuranceQuote(quote);
    }

    private InsuranceEnquiry createEnquiry()
    {
        return new InsuranceEnquiry("home insurance enquiry");
    }

    private Customer createCustomerAndValidatePersistence()
    {
        final Customer customer = new Customer("Dom", "Farr", "dominicfarr@gmail.com");
        customerService.save(customer);

        assertThat(customer.getId(), notNullValue());
        
        return customer;
    }
}