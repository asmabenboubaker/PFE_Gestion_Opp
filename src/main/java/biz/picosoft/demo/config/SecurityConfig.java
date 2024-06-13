package biz.picosoft.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {


    @Configuration
    @Order(1)
    public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
        @Bean
        public CorsFilter corsFilter() {
            UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
            CorsConfiguration config = new CorsConfiguration();
            config.setAllowCredentials(true);
            config.setAllowedOrigins(Arrays.asList("http://localhost.picosoft.biz:4302/", "https://boubaker-asma.atlassian.net")); // Add your allowed origins here
            config.setAllowedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization"));
            config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
            source.registerCorsConfiguration("/**", config);
            return new CorsFilter(source);
        }

        @Bean
        public HttpFirewall allowUrlEncodedSlashHttpFirewall() {
            StrictHttpFirewall firewall = new StrictHttpFirewall();
            firewall.setAllowSemicolon(true);
            return firewall;
        }

        @Override
        public void configure(WebSecurity web) {
            web.httpFirewall(allowUrlEncodedSlashHttpFirewall());
            web.ignoring().antMatchers("/v2/api-docs/**", "/configuration/ui", "/swagger-resources", "/configuration/security",
                    "/swagger-ui.html", "/webjars/**", "/v3/api-docs/**", "/swagger-ui/**");
        }


        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable();
            http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
            http.authorizeRequests().antMatchers("/build-number").permitAll()
            .antMatchers("/ws/**").permitAll()
               .antMatchers("/stomp").permitAll()
                            .antMatchers("/api/**").permitAll()
                    .antMatchers("https://boubaker-asma.atlassian.net/rest/api/2/project/").permitAll();
            http.authorizeRequests().anyRequest().authenticated();
            http.addFilterBefore(new JWTAutorizationFilter(), UsernamePasswordAuthenticationFilter.class);

        }

    }
}
