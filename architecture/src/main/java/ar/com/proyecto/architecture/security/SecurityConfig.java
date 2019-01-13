package ar.com.proyecto.architecture.security;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/*@Configuration
@EnableWebSecurity*/
@Deprecated
public class SecurityConfig extends WebSecurityConfigurerAdapter {

/*    //Aca estoy inyectando UserServiceImpl, su interface extiende de UserDetails por lo que sirve para el auth
    @Autowired
    UserDetailsService userDetailsService;

    @Autowired JwtCustomFilter customFilter;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/login").permitAll() //permitimos el acceso a /login a cualquiera
                .anyRequest().authenticated() //cualquier otra peticion requiere autenticacion
                .and()
                // Las peticiones /login pasaran previamente por este filtro
                .addFilterBefore(new JwtLoginFilter("/login", authenticationManager()),
                        UsernamePasswordAuthenticationFilter.class)

                // Las demás peticiones pasarán por este filtro para validar el token
                .addFilterBefore(customFilter,
                        UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //autenticacion con cualquier service que implemente userDetails
        auth.userDetailsService(userDetailsService);
    }*/
}
