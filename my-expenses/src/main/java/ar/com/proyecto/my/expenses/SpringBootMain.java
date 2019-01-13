package ar.com.proyecto.my.expenses;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("ar.com.proyecto")
@EntityScan("ar.com.proyecto")
public class SpringBootMain {


    public static void main(String[] args) {
        SpringApplication.run(SpringBootMain.class, args);
    }



}
