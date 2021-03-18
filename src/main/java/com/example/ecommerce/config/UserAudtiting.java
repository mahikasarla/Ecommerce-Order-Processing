package com.example.ecommerce.config;

import java.util.Optional;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.context.SecurityContextHolder;

@Configuration
@EnableJpaAuditing
public class UserAudtiting implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		String uname = SecurityContextHolder.getContext().getAuthentication().getName();
		return Optional.of(uname);
	}

}
