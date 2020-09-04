package albotest.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Entry point
 */
@SpringBootApplication
@EnableScheduling
public class TestAlbo {
    public static void main(String[] args) {
        SpringApplication.run(TestAlbo.class, args);
    }

}
