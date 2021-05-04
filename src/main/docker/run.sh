echo "********************************************************"
echo "STARTING CENTRALIZED AUTH SERVER WEB API WITH DOCKER "
echo "********************************************************"

java -jar /usr/local/dockerize/@project.build.finalName@.jar Dspring.profiles.active=${SPRING_PROFILES_ACTIVE} -Dprogram.name=${PROGRAM_NAME} -Dapp.store=${APP_STORE} \
    ${JAVA_OPTS} \
    ${MAIN_CLASS}
	
	