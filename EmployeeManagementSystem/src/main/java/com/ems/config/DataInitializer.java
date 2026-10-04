package com.ems.config;
import com.ems.model.AppUser;
import com.ems.repository.AppUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
public class DataInitializer {
 @Bean CommandLineRunner createAdmin(AppUserRepository repo, PasswordEncoder encoder){
  return args->{ if(repo.findByUsername("admin").isEmpty()){
   AppUser u=new AppUser(); u.setUsername("admin"); u.setPassword(encoder.encode("Admin@123")); repo.save(u);
  }};
 }
}