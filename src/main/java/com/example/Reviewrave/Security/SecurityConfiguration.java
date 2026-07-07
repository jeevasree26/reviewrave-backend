package com.example.Reviewrave.Security;
import java.beans.Customizer;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtFilter;

    public SecurityConfiguration(JwtAuthenticationFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http) throws Exception {
        http
         .csrf(csrf -> csrf.disable()).cors(cors -> {})
           .sessionManagement(session ->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
           .authorizeHttpRequests(auth ->auth.requestMatchers("/api/auth/**").permitAll()
           .requestMatchers("/api/**").authenticated()
           .anyRequest().authenticated())
           .addFilterBefore(jwtFilter ,UsernamePasswordAuthenticationFilter.class);
            return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(
                List.of(
                        "http://localhost:3000",
                        "http://127.0.0.1:5501" "https://jeevasree26.github.io/"));

        config.setAllowedMethods(
                List.of(
                        "GET",
                        "POST",
                        "PUT",
                        "DELETE",
                        "OPTIONS"));

        config.setAllowedHeaders(
                List.of("*"));
        UrlBasedCorsConfigurationSource source =   new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration(
                "/**",
                config);
        return source;
    }
}
