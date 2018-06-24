# notes ###################

created using `mvn archetype:generate` and selecting `com.gwidgets.maven:spring-boot-gwt (A maven archetype that integrates GWT into a Spring Boot Application)`

# to run this PoC ###############

```bash
mvn spring-boot:run
mvn gwt:devmode -Pgwt-dev

cd angular-app
yarn install
yarn start

# and goto http://localhost:4200/
```

# dev ###################
 
 ## gwt
 
```bash
# start server
mvn spring-boot:run

# start gwt dev mode
mvn gwt:devmode -Pgwt-dev

# package for prod
mvn package -Pgwt:prod
```

## angular dev 

```bash
cd angular-app
yarn install

# start ng dev mode
yarn start

```
