package ar.com.proyecto.architecture.securitytoken;


import ar.com.proyecto.architecture.securitytoken.interfaces.TokenProvider;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityTokenConfig extends WebSecurityConfigurerAdapter {

    //Aca estoy inyectando UserServiceImpl, su interface extiende de UserDetails por lo que sirve para el auth
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private BeanFactory beanFactory;

    @Value("${login.url}")
    public String loginUrl;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers(loginUrl).permitAll() //permitimos el acceso a /login a cualquiera
                .anyRequest().authenticated() //cualquier otra peticion requiere autenticacion
                .and()
                // Las peticiones /login pasaran previamente por este filtro (mirar el bean)

                .addFilterBefore(beanFactory.getBean("jwtLoginFilter", JwtLoginFilter.class),
                        UsernamePasswordAuthenticationFilter.class)

                // Las demás peticiones pasarán por este filtro para validar el token
                .addFilterBefore(beanFactory.getBean("jwtCustomFilter", JwtCustomFilter.class),
                        UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //autenticacion con cualquier service que implemente userDetails
        auth.userDetailsService(userDetailsService);
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
