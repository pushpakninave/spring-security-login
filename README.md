# spring-security-login

```
package com.aliencode.loginauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    /*
     * In Spring Security 5.7.0-M2 WebSecurityConfigurerAdapter is deprecated, to
     * adapt component-based security configuration.
     */

    /*
     * The recommended way of configuring an in-memory user store with a single user
     * is by registering an InMemoryUserDetailsManager bean instead of configuration
     * using the WebSecurityConfigurerAdapter :
     */
    @Bean
    public InMemoryUserDetailsManager userDetailService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("userpassword")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }

    /*
     * configuring security for a Spring Boot application using the Spring Security
     * DSL (Domain Specific Language).
     * Below example define SecurityFilterChain bean which specifies security rules
     * for different URL patterns and eventually enable form based login.
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                (request) -> request.requestMatchers("/statement").authenticated()
                        .requestMatchers("/loan").authenticated()
                        .requestMatchers("/welcome").permitAll()
                        .requestMatchers("/contact").permitAll());
        http.formLogin(Customizer.withDefaults());
        return http.build();
    }
}
```
