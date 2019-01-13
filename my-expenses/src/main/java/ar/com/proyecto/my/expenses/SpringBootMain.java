package ar.com.proyecto.my.expenses;

import ar.com.proyecto.architecture.arquitectura.securitytoken.JwtCustomFilter;
import ar.com.proyecto.architecture.arquitectura.securitytoken.JwtLoginFilter;
import ar.com.proyecto.architecture.arquitectura.securitytoken.TokenProviderImpl;
import ar.com.proyecto.architecture.arquitectura.securitytoken.interfaces.TokenProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
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
    @ConfigurationProperties(prefix = "token")
    public JwtLoginFilter jwtLoginFilter(AuthenticationManager authenticationManager) {
        return new JwtLoginFilter(loginUrl, authenticationManager);
    }

    @Bean
    @ConfigurationProperties(prefix = "token")
    public JwtCustomFilter jwtCustomFilter() {
        return new JwtCustomFilter();
    }

    @Bean
    @ConfigurationProperties(prefix = "token")
    public TokenProvider tokenProvider(){
        return new TokenProviderImpl();
    }


}
