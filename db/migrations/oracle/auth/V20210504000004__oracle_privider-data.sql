 INSERT INTO operador (
		ID
	, 	COD_OPERADOR
	, 	NOM_OPERADOR
	, 	ID_PESSOA_FISICA
	, 	TIP_OPERADOR
	, 	ID_PROCESSADOR
	,	ID_ENTIDADE
	, 	ID_ASSOCIADO
	,	ID_PARCEIRO
	, 	IDC_STATUS
	, 	ID_PERFIL
	, 	IDC_ACESSO_BOE
	,	IDC_ADMINISTRATIVO
	,	IDC_CALLCENTER
	, 	IDC_EXIBIR_CONSULTA
	,	IDC_CONOTACAO_SRF
	,	IDC_ACESSO_VPN_CONNECT
	, 	DAT_VALIDADE
	,	DAT_ULTIMA_AUTENTICACAO
	,	ID_OPERADOR_INC
	,	DAT_INCLUSAO
	, 	ID_DISPOSITIVO_INCLUSAO
	, 	ID_OPERADOR_ALT
	, 	DAT_ALTERACAO
	,	ID_DISPOSITIVO_ALTERACAO
	, 	ID_FRASE_SECRETA
	,	IDC_NOTIFICACAO
	, 	ID_MOTIVO_BLOQUEIO_OPERADOR
	, 	IDC_CONTRATA_PRODUTO
	,	IDC_DOMINIO_SPCBRASIL
	,	EMAIL_CORPORATIVO
	,	NUM_DDD_CORPORATIVO
	,	NUM_TELEFONE_CORPORATIVO
	,	RAMAL
	, 	IDC_ADM_LOJA_ONLINE
	,	IDC_SAC_CAD_POSITIVO
	,	IDC_BACKOFFICE_CAD_POSITIVO
	,	IDC_OUVIDORIA_CAD_POSITIVO
	--,	IDC_CALLCENTER_TERMO
	,	ID_ORIGEM_OPERADOR 
	,	ID_SET_SAR
	,	NUM_MTC
	, 	IDC_OPE_PPC
	,	NUM_DDD_CLL_TKN
	,	NUM_CLL_TKN
	,	IDC_PMT_HIS_PGT_CAD_POS
	, 	EDC_IP_INC
	,	IDC_ACS_SLF
	, 	IDC_USO_TKN
	,	IDC_CAD_CPT_ACS_TKN
) VALUES (
		1
	,	'SPCJAVA'
	, 	'MICKEY MOUSE'
	, 	96926192
	, 	'P'
	,	1
	, 	NULL
	, 	NULL	
	, 	NULL
	,	'I'
	, 	2897
	, 	'N'
	, 	'N'
	,	'N'
	,	'N'
	,	'S'
	,	'N'
	,	SYSDATE
	,	SYSDATE
	,	4
	,	SYSDATE
	,	1 
	,	10
	,	SYSDATE
	,	1
	, 	1
	,	'N'
	, 	NULL
	, 	NULL
	, 	NULL
	, 	NULL
	, 	NULL
	, 	NULL
	, 	NULL
	,	'N'
	,	'N'
	,	'N'
	,	'N'
	,	1
	--, 	NULL
	, 	NULL
	, 	NULL
	, 	'N'
	, 	NULL
	, 	NULL
	, 	'N'
	, 	NULL
	, 	'N'
	, 	'N'
	, 	'N'
);

INSERT INTO ASSOCIADO (
		ID
	, 	COD_ASSOCIADO
	, 	ID_ENTIDADE
	, 	ID_CATEGORIA
	, 	IDC_AGRUPA_NOTA
	, 	ANO_FATURAMENTO
	, 	IDC_DEBITO
	, 	IDC_AVALISTA_COMPRADOR
	, 	DAT_INCLUSAO, DAT_ALTERACAO
	, 	DAT_CANCELAMENTO
	, 	DAT_INICIO_SUSPENSAO
	, 	DAT_FIM_SUSPENSAO
	, 	IDC_EFETUA_REGISTRO
	, 	IDC_EXCLUI_REGISTRO_FILIAL
	, 	IDC_LANCA_ISS
	, 	DES_MOTIVO_SUSPENSAO
	, 	NOM_VENDEDOR
	, 	IDC_PORTE_EMPRESA
	, 	QTD_FILIAL
	, 	QTD_FUNCIONARIO
	, 	VLR_FATURAMENTO_ANUAL
	, 	VLR_CAPITAL_SOCIAL
	, 	IDC_TEXTO_FIXO_NOTIFICACAO
	, 	TIP_PESSOA
	, 	ID_PESSOA_JURIDICA
	, 	ID_PESSOA_FISICA
	, 	SIT_ASSOCIADO
	, 	IDC_TIP_END_DET_REG
	, 	IDC_TIP_END_REMETENTE
	, 	DAT_FUNDACAO
	, 	RAZ_SOCIAL
	, 	NOM_COMERCIAL
	, 	NOM_PESSOA_FISICA
	, 	DAT_NASCIMENTO
	, 	IDC_EMITE_CARTA
	, 	COD_RAMO_ATIVIDADE
	, 	ID_MOTIVO_CANCELAMENTO
	, 	ID_OPERADOR_INCLUSAO
	, 	ID_OPERADOR_ALTERACAO
	, 	ID_ASSOCIADO_MATRIZ
	, 	NUM_INSCR_ESTADUAL
	, 	NUM_INSCR_MUNICIPAL
	,   NUM_CNPJ
	, 	NUM_COMPLEMENTO_CNPJ
	, 	NUM_CPF
	, 	IDC_ACESSO_VPN_CONNECT
	, 	NUM_DDD_NOTIF
	, 	NUM_TELEFONE_NOTIF
	,	TEXTO_FIXO_NOTIFICACAO
	, 	COD_VISAO
	,	QTD_LIM_CONS_MES
	, 	IDC_RECALC_LIM_AUTO
	, 	IDC_BLOC_CONS_POR_LIM
	,	COD_DOCUMENTO_INTERNACIONAL
	, 	ID_REPRESENTANTE
	, 	ID_FATURAMENTO_MINIMO
	, 	DAT_INCLUSAO_DB
	, 	DAT_ULT_ALTERACAO_DB
	, 	ID_ORIGEM_ASSOCIADO
	, 	IDC_CBR
	,	IDC_CIENTE_BLOC_CONS_POR_LIM
	,	ID_OCP_CBO
	,	DAT_ULT_VRF_RF
	,	TIP_PRC_INB_DUP_DOC
	, 	IDC_CNC_STA_RF
	, 	DAT_INI_STA_RF_ICT
	, 	ID_SGT_ASS
	, 	IDC_EDC_ITN_RF
	, 	ID_TIP_ASS
	, 	ID_MTV_SPO
	, 	ID_VDR_ENT_ATD
	, 	ID_VDR_ENT_FIL
	, 	ID_TIP_ASO
	, 	COD_BCO
	, 	NUM_AGC
	, 	DTO_AGC
	, 	NUM_CNA_CRE
	, 	DTO_CNA_CRE
	--,	DC_ITT_ATZ_BCO
	,   IDC_CON_SPC_AVS)
VALUES(
		1
	, 	1
	, 	0
	, 	0
	,	'S'
	, 	0
	, 	'N'
	,	'N'
	, 	SYSDATE
	, 	''
	, 	''
	, 	''
	, 	''
	, 	'S'
	, 	''
	, 	'N'
	, 	''
	, 	''
	, 	''
	, 	0
	, 	0
	, 	0
	, 	0
	, 	'N'
	, 	''
	, 	0
	, 	0
	, 	'A'
	, 	''
	, 	0
	, 	''
	, 	''
	, 	''
	, 	''
	, 	''
	, 	'N'
	, 	0
	, 	0
	, 	0
	, 	0
	, 	0
	,   0
	, 	0
	, 	0
	, 	0
	, 	0
	, 	'N'
	, 	0
	, 	0
	, 	''
	, 	0
	, 	0
	, 	''
	, 	''
	, 	0
	, 	0
	, 	0
	, 	''
	, 	''
	, 	0
	, 	''
	, 	''
	, 	0
	, 	''
	, 	''
	, 	''
	, 	''
	, 	0
	, 	''
	, 	0
	, 	0
	, 	0
	, 	0
	, 	0
	, 	0
	, 	0
	, 	0
	, 	''
	, 	0
	--, 	'N'
	, 	'E'	);


INSERT INTO ENTIDADE
(ID, COD_ENTIDADE, NOM_ENTIDADE, NUM_CNPJ, NUM_COMPLEMENTO_CNPJ, ID_MOTIVO_CANCELAMENTO, ID_OPERADOR_ALTERACAO, IDC_CONTROLE_IP, DAT_IMPLANTACAO, DAT_INCLUSAO, DAT_ALTERACAO, IDC_FATURA_ENTIDADE, NUM_INSCRICAO_ESTADUAL, NUM_INSCRICAO_MUNICIPAL, IDC_NIVEL_CONTROLE_IP, NOM_ULTIMO_OPERADOR, DES_OBSERVACAO, PCT_ISS, STA_SITUACAO, DAT_SITUACAO, ID_PROCESSADOR, ID_TIP_ENTIDADE, IDC_MIGRADA, COD_BANCO, NUM_AGENCIA, NUM_CONTA_CORRENTE, DGV_CONTA_CORRENTE, ID_ENTIDADE_PAI, ID_PESSOA_JURIDICA, IDC_BOE, DGV_AGENCIA, ID_OPERADOR_INCLUSAO, DTYPE, NUM_HABITANTES_MUNICIPIO, IDC_ACESSO_VPN_CONNECT, TIP_LOGO_DEFAULT, COD_VISAO, IDC_CDL_INTERNACIONAL, DAT_INCLUSAO_DB, DAT_ULT_ALTERACAO_DB, ID_CIDADE, ID_CATEGORIA_ENTIDADE, DES_SITE, DAT_FUNDACAO, DAT_ALT_CTT_END, NUM_CNPJ_OLD, NUM_COMPLEMENTO_CNPJ_OLD)
VALUES(0, 0, 'UMA ENTIDADE', 0, 0, 0, 0, 'N', SYSDATE, '', '', 'S', 0, 0, 0, '', '', 0 , 'A', '', 0, 0, 'S' , 0, 0, '', '', 0, 0, 'N' , 0, 0, '', 0, 'N' , 1, 0, 'N', '', '', 0, 1 , '', '', '', 0, 0);


INSERT INTO SENHA_OPERADOR
(ID, ID_OPERADOR, ID_MEIO_ACESSO, DES_SENHA, NUM_TENTATIVA, DAT_ULTIMA_ALTERACAO, DES_SENHA_HOST_HOST_4, DES_SENHA_HOST_HOST_5, DES_SENHA_HOST_HOST_6, DES_SENHA_HOST_HOST_7)
VALUES(1, 1, 1, '{SHA-256}764dfc412c4053c7373fa98599141bf07488b2a312107c54baf905c5295f0c1d', 0 , SYSDATE + 1, '', '', '', '');

