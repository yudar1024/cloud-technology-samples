set SPRING_SECURITY_OAUTH2_CLIENT_PROVIDER_OIDC_ISSUER_URI=http://localhost:9080/auth/realms/jhipster
set SPRING_SECURITY_OAUTH2_CLIENT_REGISTRATION_OIDC_CLIENT_ID=jhipster-registry
:: set SPRING_SECURITY_OAUTH2_CLIENT_REGISTRATION_OIDC_CLIENT_SECRET=""
:: --jhipster.security.authentication.jwt.secret=""
java -jar jhipster-registry-5.0.2.jar --spring.profiles.active=dev,oauth2 --spring.security.user.password=admin --spring.cloud.config.server.composite.0.type=git --spring.cloud.config.server.composite.0.uri=https://github.com/jhipster/jhipster-registry --spring.cloud.config.server.composite.0.search-paths=central-config
