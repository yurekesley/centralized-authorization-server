package org.spcbrasil.cadastropositivo.centralizedauthorizationserver.modules.datasources.oracle.util;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

/**
 * @author yure.placido
 *
 */
public class UsuarioPorCodigoOperadorQueryBuilderTest {

	@Test
	public void deveRetornarQueryDeUsuario() {
		UsuarioPorCodigoOperadorQueryBuilder queryBuilder = new UsuarioPorCodigoOperadorQueryBuilder();
		assertTrue(queryBuilder.build().contains("spcjava"));
	}

}
