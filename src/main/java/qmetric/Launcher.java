package qmetric;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import qmetric.repository.CustomerService;

public class Launcher
{
    private CustomerService userService;

    public static void main(String[] arguments)
    {
        CustomerService customerService = (CustomerService) new ClassPathXmlApplicationContext("spring/spring-context.xml").getBean("customerService");
    }
}
