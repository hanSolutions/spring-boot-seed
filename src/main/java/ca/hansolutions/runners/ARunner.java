package ca.hansolutions.runners;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Order(2)
public class ARunner implements ApplicationRunner{

    @Override
    public void run(ApplicationArguments args) throws Exception {

        System.out.println("This is from Application Runner");
        System.out.printf("  optional arguments is %s%n", args.getOptionValues("name").get(0));
        System.out.printf("  contains optional arguments `debug` : %s%n", args.containsOption("debug"));
        System.out.printf("  there are none optional arguments %s%n", args.getNonOptionArgs().size());

    }
}
