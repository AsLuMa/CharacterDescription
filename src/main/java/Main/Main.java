package Main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ComponentScan
@EnableConfigurationProperties
public class Main {

    public static void main(String[] args) {

        final Logger log = LoggerFactory.getLogger(Main.class);

        SpringApplication.run(Main.class, args);

        log.info("Run application");

    }

}
