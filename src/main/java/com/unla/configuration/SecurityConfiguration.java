package com.unla.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {

	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests()
<<<<<<< HEAD
				.requestMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/img-tp/**","/Alumbrado/**","/MedicionAlumbrado/**", "/banios/**","/mediciones-estacionamiento/**","/estacionamientos/**","/estacionamiento/**").permitAll()
=======
				.requestMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/img-tp/**", "/banios/**","/mediciones-estacionamiento/**","/estacionamientos/**","/estacionamiento/**","/mediciones/**").permitAll()
>>>>>>> 80dcbc8c3459c69131beaf177acf1736c3fd2443

				.anyRequest().authenticated()
			.and()
				.formLogin().loginPage("/login").loginProcessingUrl("/loginprocess")
				.usernameParameter("username").passwordParameter("password")
				.defaultSuccessUrl("/loginsuccess").permitAll()
			.and()
				.logout().logoutUrl("/logout").logoutSuccessUrl("/logout").permitAll();
		return http.build();
	}

	/* No usado en este ejemplo
	@Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/images/**", "/js/**", "/webjars/**");
    }*/
}

