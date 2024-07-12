package com.app.config;

import com.app.service.UserDetailServiceImp;
import org.hibernate.annotations.Bag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    AuthenticationConfiguration authenticationConfiguration;

    //Configuration FilterChain
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        return httpSecurity
//                .csrf(csrf -> csrf.disable())
//                .httpBasic(Customizer.withDefaults())
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .authorizeHttpRequests(http -> {
//                    //Public EndPoints
//                    http.requestMatchers(HttpMethod.GET, "/auth/hello").permitAll();
//                    //Private EndPoints
//                    http.requestMatchers(HttpMethod.GET, "/auth/hello-secured").hasAnyAuthority("CREATE");
//                    //No Specify EndPoints
//                    //http.anyRequest().authenticated();
//                    //Reject All Endpoints No Specify
//                    http.anyRequest().denyAll();
//                })
//                .build();
//    }
//Configuration FilterChain
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }

    //Configuration Authentication Manager
    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    //Configuration authentication Provider
    @Bean
    public AuthenticationProvider authenticationProvider(UserDetailServiceImp userDetailsService) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailsService);

        return provider;
    }

    //Configuration Password Encoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    //Configuration UserDetailsService
//    @Bean
//    public UserDetailsService userDetailsService() {
////        UserDetails userDetails = User.withUsername("user")
////                .password("123")
////                .roles("ADMIN")
////                .authorities("READ", "CREATE")
////                .build();
//        List<UserDetails> userDetailsList = new ArrayList<>();
//
//        //ADMIN
//        userDetailsList.add(
//                User.withUsername("admin")
//                        .password("123")
//                        .roles("ADMIN")
//                        .authorities("READ", "CREATE")
//                        .build()
//        );
//        //USER
//        userDetailsList.add(
//                User.withUsername("user")
//                        .password("123")
//                        .roles("USER")
//                        .authorities("READ")
//                        .build()
//        );
//
//        //USER
//        userDetailsList.add(
//                User.withUsername("user2")
//                        .password("123")
//                        .roles("USER")
//                        .authorities("WRITE")
//                        .build()
//        );
//
//        return new InMemoryUserDetailsManager(userDetailsList);
//    }

}
