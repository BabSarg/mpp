package com.example.mpprest.config;

import com.example.mpprest.security.JwtAuthenticationEntryPoint;
import com.example.mpprest.security.JwtAuthenticationTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class
WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    @Qualifier("currentUserDetailServiceImpl")
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtAuthenticationEntryPoint unauthorizedHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/rest/users").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/rest/movies").hasAnyAuthority("USER", "ADMIN")
                .antMatchers(HttpMethod.GET, "/rest/multiCat").hasAnyAuthority("USER", "ADMIN")
                .antMatchers(HttpMethod.GET, "/rest/categories").hasAnyAuthority("USER", "ADMIN")
                .antMatchers(HttpMethod.GET, "/rest/actor").hasAnyAuthority("USER", "ADMIN")
                .antMatchers(HttpMethod.PUT, "/rest/users/addImage/{userId}").hasAnyAuthority("USER", "ADMIN")
                .antMatchers(HttpMethod.PUT, "/rest/movies").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.PUT, "/rest/multiCat").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.PUT, "/rest/categories").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.PUT, "/rest/users").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.PUT, "/rest/users/auth").hasAnyAuthority("USER", "ADMIN")
                .antMatchers(HttpMethod.DELETE, "/rest/users/{id}").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/rest/users").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/rest/movies").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/rest/multiCat").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/rest/categories").hasAuthority("ADMIN")
                .anyRequest().permitAll();
        http
                .addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
        http.headers().cacheControl();
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtAuthenticationTokenFilter authenticationTokenFilterBean() throws Exception {
        return new JwtAuthenticationTokenFilter();
    }

}
