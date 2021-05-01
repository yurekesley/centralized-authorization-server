package org.spcbrasil.cadastropositivo.centralizedauthorizationserver.app.config;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

/**
 * @author yure.placido
 *
 */
public class ShaPasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(CharSequence rawPassword) {
		String hashed = BCrypt.hashpw(rawPassword.toString(), BCrypt.gensalt(1));
		return hashed;
	}

	@Override
	@SuppressWarnings("deprecation")
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		StandardPasswordEncoder sha256 = new StandardPasswordEncoder();
	
		String string = rawPassword.toString();

		return sha256.matches(string.toUpperCase(), encodedPassword);

	}

}
