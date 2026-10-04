package com.ems.config;
import com.ems.repository.AppUserRepository; import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
@Service public class CustomUserDetailsService implements UserDetailsService {
 private final AppUserRepository repo; public CustomUserDetailsService(AppUserRepository r){repo=r;}
 public UserDetails loadUserByUsername(String username){var u=repo.findByUsername(username).orElseThrow(()->new UsernameNotFoundException(username));
 return User.withUsername(u.getUsername()).password(u.getPassword()).roles("ADMIN").build();}
}