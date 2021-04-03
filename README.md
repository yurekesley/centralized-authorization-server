# Read Me First
GERAR KEY 
keytool -genkey -alias spcbrasil.org.br -storepass spcbrasil -keypass spcbrasil -keyalg RSA -keysize 2048 -keystore keystore.jks -validity 3650

## RECUPERAR CHAVE PÚBLICA
keytool -list -rfc --keystore keystore.jks