package ca.hansolutions.runners;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class CRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        System.out.println("This is from Command Runner");
        for(String arg : args){
            System.out.printf("  %s%n", arg);
        }
    }
}
