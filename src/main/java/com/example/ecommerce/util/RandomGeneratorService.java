/**
 *
 */
package com.example.ecommerce.util;

import java.security.SecureRandom;

import org.springframework.stereotype.Service;

/**
 * @author MahenderKasarla
 *
 */
@Service
public class RandomGeneratorService {

	private final String randomString = "12345efghjkmnpqrGHJKMNPstuvw6789abcdxyzABCDEFQRSTUVWXYZ";

	/**
	 * generates random string based on given length
	 *
	 * @param maxLengthOfString
	 * @return
	 */
	public String generateRandomString(int maxLengthOfString) {

		SecureRandom rand = new SecureRandom();
		StringBuilder rs = new StringBuilder();

		for (int i = 0; i < maxLengthOfString; i++) {
			int randIndex = rand.nextInt(randomString.length());
			rs.append(randomString.charAt(randIndex));
		}

		return rs.toString();
	}

}
