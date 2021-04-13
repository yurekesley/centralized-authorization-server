## <i>GERAR KEY</i>
`keytool -genkey -alias spcbrasil.org.br -storepass spcbrasil -keypass spcbrasil -keyalg RSA -keysize 2048 -keystore keystore.jks -validity 3650`

## <i>RECUPERAR CHAVE PÚBLICA </i>
`keytool -list -rfc --keystore keystore.jks`

#### Build Imagem Docker
`
mvn clean package docker:build
`

#### Push Imagem Docker

`
mvn clean package docker:build -DpushImage
`

#### Tag Imagem Docker

`
mmvn clean package docker:build -DpushImageTag latest
`
