package org.spcbrasil.cadastropositivo.centralizedauthorizationserver.modules.datasources.oracle.util;

/**
 * @author yure.placido
 *
 */
public class UsuarioPorCodigoOperadorQueryBuilder {

	public String build() {

		StringBuilder sb = new StringBuilder();

		sb.append("SELECT op.id id ");
		sb.append(" , op.cod_operador codigo ");
		sb.append(" , op.nom_operador nome ");
		sb.append(" , op.idc_status status ");
		sb.append(" , op.id_associado idAssociado ");
		sb.append(" , a.cod_associado codigoAssociado ");
		sb.append(
				" , case when a.NOM_COMERCIAL is not null then a.NOM_COMERCIAL else a.NOM_PESSOA_FISICA end nomeAssociado ");
		sb.append(" , case when op.id_entidade is not null  then op.id_entidade  else a.id_entidade end idEntidade ");
		sb.append(" , case when op.id_entidade is not null  then op.id_entidade  else a.id_entidade end idEntidade ");
		sb.append(
				" , case when op.id_entidade is not null  then e.cod_entidade  else ea.cod_entidade end codigoEntidade ");
		sb.append(
				" , case when op.id_entidade is not null  then e.nom_entidade  else ea.nom_entidade end nomeEntidade ");
		sb.append(
				" , DECODE(op.tip_operador, 'P', op.id_processador,'E', e.id_processador,'A', ea.id_processador) idProcessador ");
		sb.append(" , DECODE(op.tip_operador, 'P','processador','E', 'entidade','A', 'associado') tipo ");
		sb.append(" , op.id_perfil idPerfil ");
		sb.append(" , so.des_senha senha ");
		sb.append(" FROM operador op ");
		sb.append(" , associado a ");
		sb.append(" , entidade e ");
		sb.append(" , entidade ea ");
		sb.append(" , senha_operador so ");
		sb.append("  WHERE 1 = 1  ");
		sb.append("  AND so.id_operador = op.id   ");
		sb.append("  AND op.id_associado = a.id(+)   ");
		sb.append("  AND a.id_entidade = ea.id(+)   ");
		sb.append("  AND op.id_entidade = e.id(+)   ");
		sb.append("  AND op.tip_operador = 'P'   ");
		sb.append("  AND so.id_meio_acesso = 1   ");
		sb.append("  AND upper(op.cod_operador) = upper(?) ");
		return sb.toString();
	}

}
