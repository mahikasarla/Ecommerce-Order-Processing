package com.example.ecommerce.config;

import java.util.Optional;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author MahenderKasarla
 *
 */
@Configuration
@EnableJpaAuditing
public class UserAudtiting implements AuditorAware<String> {

	/**
	 * gets current user for auditing
	 */
	@Override
	public Optional<String> getCurrentAuditor() {
		String uname = SecurityContextHolder.getContext().getAuthentication().getName();
		return Optional.of(uname);
	}

}
