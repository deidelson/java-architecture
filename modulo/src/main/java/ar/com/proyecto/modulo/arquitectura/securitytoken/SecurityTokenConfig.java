package ar.com.proyecto.modulo.arquitectura.securitytoken;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.PostConstruct;

@Configuration
@EnableWebSecurity
public class SecurityTokenConfig extends WebSecurityConfigurerAdapter {

        //Aca estoy inyectando UserServiceImpl, su interface extiende de UserDetails por lo que sirve para el auth
        @Autowired private UserDetailsService userDetailsService;


        @Value("${login.url}") private String loginUrl;


        @Override
        protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/login").permitAll() //permitimos el acceso a /login a cualquiera
                .anyRequest().authenticated() //cualquier otra peticion requiere autenticacion
                .and()
                // Las peticiones /login pasaran previamente por este filtro (mirar el bean)

                .addFilterBefore(jwtLoginFilter(),
                        UsernamePasswordAuthenticationFilter.class)

                // Las demás peticiones pasarán por este filtro para validar el token
                .addFilterBefore(jwtCustomFilter(),
                        UsernamePasswordAuthenticationFilter.class);
    }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //autenticacion con cualquier service que implemente userDetails
        auth.userDetailsService(userDetailsService);
    }

    @Bean
    public JwtLoginFilter jwtLoginFilter() throws Exception{
            return new JwtLoginFilter(loginUrl, authenticationManager());
    }

    @Bean
    public JwtCustomFilter jwtCustomFilter(){
            return new JwtCustomFilter();
    }
}
