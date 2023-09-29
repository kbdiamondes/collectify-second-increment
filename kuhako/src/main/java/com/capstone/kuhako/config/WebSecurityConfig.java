package com.capstone.kuhako.config;


import com.capstone.kuhako.services.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// This annonation enables web securities in our application defined by WebSecurityConfig implementations.
@Configuration
// This annonation enables the web securities defined by WebSecurityConfigurerAdapter automatically.
@EnableWebSecurity
// This annotation is used in Spring Security to enable global method-level security for protecting methods in your application.
// This is used to apply security measures at the method level, rather than just at the URL level.
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    // injects the "JwtAuthenticate" class which implements the "AuthenticateEntryPoint"
    @Autowired
    private JwtAuthenticate jwtAuthenticate;

    // injects the "JwtUserDetailsService" class which handles the user details for JWT authentication
    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;

    // injects the "JwtRequestFilter" class which has a custom filter for handling JWT requests.
    // Filters to be applied on the request
    // Jwt authentication
    // username authentication
    @Autowired
    private JwtRequestFilter jwtRequestFilter;


    @Autowired
    // This method configures the "AuthenticationManager" by specifying the "jwtUserDetailsService".
    // This allows the authentication manager to authenticate users based on the provided user details service and password encoder.
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());

    }


    // @Bean annotation is used in Spring Boot to make a special method that creates a manages an object that can be used in different parts of our application.

    // What to do during authentication
    // This serves as the authentication entry point for handling unauthorized requests.
    @Bean
    public JwtAuthenticate jwtAuthenticationEntryPointBean() throws Exception {
        return new JwtAuthenticate();
    }

    // Instantiates a BCryptPasswordEncoder object for password hashing/encoding.
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // The method is used in the configuration of Spring Security to expose the "AuthenticationManager" as a Bean in the Spring context. By doing this, it can be injected into other parts of the application for authentication-related tasks.
    // Example: it can be used to authenticate user credentials during the login process.
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();

    }

    // Routes that will not require Jwt Tokens
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers( "/login").permitAll()
                .antMatchers( "/registerClient").permitAll()
                .antMatchers( "/registerReseller").permitAll()
                .antMatchers( "/registerCollector").permitAll()
                .antMatchers("/public/**").permitAll() // Allow public access
                .antMatchers(HttpMethod.POST, "/client").permitAll() // Permit POST requests to /client
                .antMatchers(HttpMethod.POST, "/reseller").permitAll() // Permit POST requests to /reseller
                .antMatchers(HttpMethod.POST, "/collector").permitAll() // Permit POST requests to /collector
                .antMatchers(HttpMethod.GET, "/client").permitAll() //Permit GET request to /client but request Authorization header or token
                .antMatchers(HttpMethod.GET, "/collector").permitAll() //Permit GET request to /client but request Authorization header or token
                .antMatchers(HttpMethod.GET, "/reseller").permitAll()//Permit GET request to /client but request Authorization header or token
                .antMatchers("/client/**").hasRole("CLIENT") // Protect client endpoints
                .antMatchers("/collector/**").hasRole("COLLECTOR") // Protect collector endpoints
                .antMatchers("/reseller/**").hasRole("RESELLER") // Protect reseller endpoints
                .anyRequest().authenticated()
                .and()
                // This configures the authentication entry point for handling authentication failures.
                .exceptionHandling().authenticationEntryPoint(jwtAuthenticate).and()
                // This is used to specify that the application should not create or use any sessions, as it is following a stateless authentication approach using JSON Web Tokens (JWT).
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().formLogin().disable();


    }

}
