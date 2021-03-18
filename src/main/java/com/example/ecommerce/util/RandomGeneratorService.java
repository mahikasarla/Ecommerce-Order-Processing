/**
 *
 */
package com.example.ecommerce.util;

import java.security.SecureRandom;

import org.springframework.stereotype.Service;

@Service
public class RandomGeneratorService {

	private final String randomString = "12345efghjkmnpqrGHJKMNPstuvw6789abcdxyzABCDEFQRSTUVWXYZ";

	public String generateRandomString() {

		SecureRandom rand = new SecureRandom();
		StringBuilder rs = new StringBuilder();

		int maximumTransactionIdLength = 6;

		for (int i = 0; i < maximumTransactionIdLength; i++) {
			int randIndex = rand.nextInt(randomString.length());
			rs.append(randomString.charAt(randIndex));
		}

		return rs.toString();
	}

}
