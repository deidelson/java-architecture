package ar.com.proyecto.modulo;

import ar.com.proyecto.modulo.arquitectura.securitytoken.JwtCustomFilter;
import ar.com.proyecto.modulo.arquitectura.securitytoken.JwtLoginFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;

@SpringBootApplication
//@EnableAutoConfiguration(exclude = {HibernateJpaAutoConfiguration.class, DataSourceAutoConfiguration.class})
public class SpringBootMain {

    @Value("${login.url}") String loginUrl;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMain.class, args);
    }


    @Bean
    public JwtLoginFilter jwtLoginFilter(AuthenticationManager authenticationManager) {
        return new JwtLoginFilter(loginUrl, authenticationManager);
    }

    @Bean
    public JwtCustomFilter jwtCustomFilter() {
        return new JwtCustomFilter();
    }


}
