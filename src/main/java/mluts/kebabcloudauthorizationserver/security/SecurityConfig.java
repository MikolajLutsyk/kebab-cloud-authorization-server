package mluts.kebabcloudauthorizationserver.security;

import mluts.kebabcloudauthorizationserver.domain.Users;
import mluts.kebabcloudauthorizationserver.repos.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Collection;
import java.util.HashSet;


@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain defaultChain(HttpSecurity http) throws Exception{
        return http.authorizeHttpRequests(authorizeRequest ->authorizeRequest.anyRequest().authenticated())
                .formLogin()
                .and()
                .build();
    }

    @Bean
    UserDetailsService userDetailsService(UserRepository userRepository){
        return userRepository::findByUsername;
    }



    @Bean
    public ApplicationRunner dataLoader(UserRepository repo, PasswordEncoder encoder){
        return args -> {
          repo.save(new Users("user1", encoder.encode("password"), "ROLE_ADMIN"));
          repo.save(new Users("user2", encoder.encode("password"), "ROLE_ADMIN"));
        };
    }
}
