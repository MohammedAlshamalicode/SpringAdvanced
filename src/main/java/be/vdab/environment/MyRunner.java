package be.vdab.environment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
class MyRunner implements CommandLineRunner {
    private final String myValue;
    MyRunner(@Value("${my.key}") String myValue) {
        this.myValue = myValue;
    }
    @Override
    public void run(String... args) throws Exception {
        System.out.println(myValue);
    }
}