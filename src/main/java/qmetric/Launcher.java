package qmetric;

import qmetric.model.Customer;
import qmetric.repository.CustomerService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Launcher
{
    private CustomerService userService;

    public static void main(String[] arguments)
    {
        CustomerService customerService = (CustomerService) new ClassPathXmlApplicationContext("spring/spring-context.xml").getBean("customerService");
    }
}
