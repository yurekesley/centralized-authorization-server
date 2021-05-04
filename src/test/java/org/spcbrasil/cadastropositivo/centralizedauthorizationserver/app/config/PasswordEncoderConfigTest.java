package org.spcbrasil.cadastropositivo.centralizedauthorizationserver.app.config;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.spcbrasil.cadastropositivo.centralizedauthorizationserver.app.config.encoder.PasswordEncoderConfig;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderConfigTest {

	private PasswordEncoderConfig config = new PasswordEncoderConfig();
	
	/* @Test senhas do spc tem um encriptador padrao dependente de uma versão antiga do spring, verificar se devemos implementar 
		ou forçar a atualização de senha para um encriptador padrao 
	 **/
	public void deveCombinarSenhaComEncoderPadrao() {
		PasswordEncoder passwordEncoder = config.passwordEncoder();
		boolean matches = passwordEncoder.matches("spcjava111",
				"b2a3bd8bc40a800c2512698b00a261467352764b8d5fb63a847f0863468c83d3");
		assertTrue(matches);
	}

	@Test
	public void deveCombinarSenhaComEncoderBcrypt() {
		PasswordEncoder passwordEncoder = config.passwordEncoder();
		boolean matches = passwordEncoder.matches("secret",
				"{bcrypt}$2a$10$vCXMWCn7fDZWOcLnIEhmK.74dvK1Eh8ae2WrWlhr2ETPLoxQctN4.");
		assertTrue(matches);
	}

}
