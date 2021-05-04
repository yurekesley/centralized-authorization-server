/**
 * Permissoes para conectar no schema
 */
	/*
		CRIAR USUARIO:
		CREATE USER AUTH IDENTIFIED BY flyway;
	*/
	GRANT CREATE SESSION TO AUTH WITH ADMIN OPTION;
	GRANT ALL PRIVILEGES TO AUTH;
	GRANT DBA TO AUTH;
	
	/**
	 * Habilita semantica de tamanho para caracteres UTF-8
	 * Resumindo: 1 char = 4 bytes
	 */
	ALTER session SET nls_length_semantics=CHAR;
	
	/**
	 * Habilita EBR (Edition-Based Redefinition) para usuario
	*/
	ALTER USER AUTH ENABLE EDITIONS;  

