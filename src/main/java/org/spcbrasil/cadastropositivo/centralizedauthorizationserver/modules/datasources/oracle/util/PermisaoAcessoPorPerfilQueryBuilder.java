package org.spcbrasil.cadastropositivo.centralizedauthorizationserver.modules.datasources.oracle.util;

/**
 * @author yure.placido
 * 
 *         <code>

		SELECT * FROM (WITH temp AS (SELECT 	
					ss.NOM_SUBSISTEMA 			sub_sistema
					,  f.NOM_ROLE 				roleSufix
					,  f.NOM_FUNCIONALIDADE 	nome
					,  pa.idc_create 			idc_create
					,  pa.idc_update 			idc_update
					,  pa.idc_remove 			idc_remove 
					,  o.COD_OPERADOR 			cod_operador
					,  perfil.ID 				id_perfil
					 FROM spcjava.permissao_acesso pa
		INNER JOIN spcjava.PERFIL perfil ON perfil.ID  = pa.ID_PERFIL 
		INNER JOIN spcjava.funcionalidade f ON f.id = pa.ID_FUNCIONALIDADE 
		INNER JOIN spcjava.SUBSISTEMA ss ON ss.id = f.ID_SUBSISTEMA
		INNER JOIN spcjava.OPERADOR o ON o.ID_PERFIL = perfil.ID
		WHERE 1 = 1 
		AND f.idc_ativo = 'S' 
		AND ss.idc_rdr = 'S'
		AND f.TIP_SISTEMA = 'J')
		SELECT 
				temp.sub_sistema
		,		temp.id_perfil
		,		CASE WHEN d.id = 1 THEN CONCAT('ROLE_CREATE_', temp.roleSufix) 
			    	WHEN d.id = 2 THEN CONCAT('ROLE_UPDATE_', temp.roleSufix) 
			    	WHEN d.id = 3 THEN CONCAT('ROLE_REMOVE_', temp.roleSufix) 
			  	END ROLE
		  
		,		CASE WHEN d.id = 1 THEN 'CREATE'
					WHEN d.id = 2  THEN	'UPDATE'
					WHEN d.id = 3  THEN	'REMOVE'
				END tipo_permissao
		  
		,		CASE WHEN d.id = 1 THEN temp.idc_create
		        	WHEN d.id = 2 THEN temp.idc_update
		        	WHEN d.id = 3 THEN temp.idc_remove
				END has_permissao
		FROM temp temp
		  CROSS JOIN (SELECT LEVEL ID FROM   dual  CONNECT BY LEVEL <= 3) d 
		WHERE 1 = 1 AND temp.COD_OPERADOR = upper('spcjava') )  X 
		WHERE  x.has_permissao = 'S'
 </code>
 */
public final class PermisaoAcessoPorPerfilQueryBuilder {

	public String build() {

		StringBuilder sb = new StringBuilder();

		sb.append("SELECT * FROM (");
		sb.append("	WITH temp AS (");
		sb.append("	SELECT");
		sb.append("	ss.NOM_SUBSISTEMA 			sub_sistema ");
		sb.append("	,  f.NOM_ROLE 				roleSufix ");
		sb.append("	,  f.NOM_FUNCIONALIDADE 	nome ");
		sb.append("	,  pa.idc_create 			idc_create ");
		sb.append("	,  pa.idc_update 			idc_update ");
		sb.append("	,  pa.idc_remove 			idc_remove ");
		sb.append("	,  o.COD_OPERADOR 			cod_operador ");
		sb.append("	,  perfil.ID 				id_perfil ");
		sb.append("	FROM spcjava.permissao_acesso pa ");
		sb.append("	INNER JOIN spcjava.PERFIL perfil ON perfil.ID  = pa.ID_PERFIL ");
		sb.append("	INNER JOIN spcjava.funcionalidade f ON f.id = pa.ID_FUNCIONALIDADE ");
		sb.append("	INNER JOIN spcjava.SUBSISTEMA ss ON ss.id = f.ID_SUBSISTEMA ");
		sb.append("	INNER JOIN spcjava.OPERADOR o ON o.ID_PERFIL = perfil.ID ");
		sb.append("	WHERE 1 = 1  ");
		sb.append("	AND f.idc_ativo = 'S'  ");
		sb.append("	AND f.idc_ativo = 'S' ");
		sb.append("	AND ss.idc_rdr = 'S' ");
		sb.append("	SELECT ");
		sb.append("	temp.sub_sistema ");
		sb.append("	,		temp.id_perfil ");
		sb.append("	,		CASE WHEN d.id = 1 THEN CONCAT('ROLE_CREATE_', temp.roleSufix)  ");
		sb.append("	WHEN d.id = 2 THEN CONCAT('ROLE_UPDATE_', temp.roleSufix)  ");
		sb.append("	WHEN d.id = 3 THEN CONCAT('ROLE_REMOVE_', temp.roleSufix)  ");
		sb.append("	END ROLE ");
		sb.append("	,		CASE WHEN d.id = 1 THEN 'CREATE' ");
		sb.append("	WHEN d.id = 2  THEN	'UPDATE' ");
		sb.append("	WHEN d.id = 3  THEN	'REMOVE' ");
		sb.append("	END tipo_permissao ");
		sb.append("	,		CASE WHEN d.id = 1 THEN temp.idc_create ");
		sb.append("	WHEN d.id = 2 THEN temp.idc_update ");
		sb.append("	WHEN d.id = 3 THEN temp.idc_remove ");
		sb.append("	END has_permissao ");
		sb.append("	FROM temp temp ");
		sb.append("	CROSS JOIN (SELECT LEVEL ID FROM   dual  CONNECT BY LEVEL <= 3) d  ");
		sb.append("	WHERE 1 = 1 AND temp.COD_OPERADOR = upper(?) )  X  ");
		sb.append("	WHERE  x.has_permissao = 'S'; ");

		return sb.toString();
	}

}
