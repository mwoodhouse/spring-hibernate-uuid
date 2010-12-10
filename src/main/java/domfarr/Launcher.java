package domfarr;

import domfarr.model.Customer;
import domfarr.repository.CustomerService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Launcher
{
    private CustomerService userService;

    public static void main(String[] arguments)
    {
        CustomerService customerService = (CustomerService) new ClassPathXmlApplicationContext("spring/spring-context.xml").getBean("customerService");

        Customer customer = new Customer("Dom", "Farr", "dfarr@qmetri.co.uk");

        customerService.save(customer);

        System.out.println(customer);
    }
}
