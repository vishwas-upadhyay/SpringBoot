package com.vishwas.springsecurity.security;



import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
// if we are configuring spring security then we need to use this @ on class which has the
// configuration.
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


// This is just a implementation of Authentication use case.
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);  comment this as we don't need any default configuration to be passed via application property.

            auth.inMemoryAuthentication()
                    .withUser("jack")
                    .password("123456")
                    .roles("USER")
                    .and()
                    .withUser("jill")
                    .password("123456")
                    .roles("ADMIN");

    }


//    Spring doesn't wants it's developer to have plain text password. so we need
//    to configure password encoder as well else it will throw error.
    @Bean
    public PasswordEncoder getpasswordEncoder (){
        return NoOpPasswordEncoder.getInstance();

    }

//  Authorization use case is implemented here
//  HttpSecurity class gives us feature to control application role wise.
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        http.authorizeRequests()
                .antMatchers("/spring-security/admin").hasRole("ADMIN")
                .antMatchers("/spring-security/user").hasAnyRole("USER","ADMIN")
                .antMatchers("/spring-security/").permitAll()
                .and()
                .formLogin();
    }
}
