package com.example.emploee.config;

import com.example.emploee.security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityWebConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .formLogin()
                .loginPage("/loginPage")
                .loginProcessingUrl("/perform_login")
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and()
                .exceptionHandling().accessDeniedPage("/403")
                .and()
                .authorizeRequests()
                .antMatchers("index").permitAll()
               // .antMatchers(HttpMethod.GET,"/formMassage").permitAll()
                //.antMatchers("/addTopic","/allTopic","/topics{id}").hasAnyAuthority("USER","ADMIN")
                .antMatchers("/adminPanel").hasAnyAuthority("ADMIN")
                .antMatchers("/employee").hasAnyAuthority("ADMIN","USER")
                .antMatchers("/employeeAdmin").hasAnyAuthority("ADMIN")
                .antMatchers("/employee/add").hasAnyAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/addCompany").hasAnyAuthority( "ADMIN")
                .antMatchers(HttpMethod.POST, "/addCompany").hasAnyAuthority( "ADMIN")
                .antMatchers(HttpMethod.GET, "/deleteCompany").hasAnyAuthority("ADMIN")
//                .and()
//                .logout()
//                .logoutSuccessUrl("/")
//                .deleteCookies("JSSESIONID")
//                .invalidateHttpSession(true)
        ;

    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("arm")
//                .password(passwordEncoder.encode("arm"))
//                .roles("USER")
//                .and()
//                .withUser("admin")
//                .password(passwordEncoder.encode("admin"))
//                .roles("ADMIN");
//        auth.userDetailsService(userDetailsService)
//                .passwordEncoder(passwordEncoder);
//    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
//    }
}
