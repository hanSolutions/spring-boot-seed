# Spring Boot Seed Project

## 1. Add Web Support

* add the following dependency
```xml
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
```

* there is no web.xml involved

* json-jackson will be enabled automatically

* you can create a `static` folder under `resources` folder, and put your html, css and javascript in that folder.

* a default error page is configured too

##1.2 Add thymeleaf support

* add the following dependency

```xml
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
        </dependency>
```

* then you can add view files into `resources/templates` folder

##1.3 Add JSP support

* add the following dependency

```xml
        <dependency>
            <groupId>org.apache.tomcat.embed</groupId>
            <artifactId>tomcat-embed-jasper</artifactId>
        </dependency>
```

* add following properties into `application.properties` file

```properties
spring.mvc.view.prefix= /WEB-INF/views/
spring.mvc.view.suffix= .jsp
```

* then you can add view files into `resources/META-INF/resources/WEB-INF/views` folder

##1.4 Servlet Container

by default, `spring-boot-starter-web` include an embed tomcat.

in case you want to switch to another container like jetty, you can exclude tomcat from starter-web and add the following dependency
```xml
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-jetty</artifactId>
        </dependency>
```

you can also edit the container behavior by adding properties in `application.properties`
```properties
server.address=nate
server.port=9080
server.context-path=/application
```

##1.5 enable compress
add following properties into `application.properties`
```properties
server.compression.enabled=true
server.compression.min-response-size=2048
```

##1.6 add a filter

create a Filter Java bean

```Java
@Component
public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("This is from filter");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
```

##1.7 add a listener

create a Listener bean 
```Java
@Component
public class ServerListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        System.out.println("server context in building up");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

        System.out.println("server context is destroying down");

    }
}
```

#2. Add Security Support
add the following dependency
```xml
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>
```

the default username is `user` you can get password from your console when you start the application.

##2.1 change username and password
add following properties into your `application.properties`
```properties
security.user.name=nate
security.user.password=password
```

##2.2 application security event
Spring Security will post some security related event which could be caught by an ApplicationListener typed with an event type.
Here we shows how to add a listener to capture authentication failure event
```Java
@Component
public class SecurityEventListener implements ApplicationListener<AbstractAuthenticationFailureEvent> {

    @Override
    public void onApplicationEvent(AbstractAuthenticationFailureEvent authenticationFailureEvent) {

        System.out.println(authenticationFailureEvent.getException().getMessage());

    }
}
```

##2.3 customize login method
We can add a security config class to change the default security config.
Here is an example showing how to use login from instead of basic login
```Java
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //customize security to use login form
        http.authorizeRequests().anyRequest().authenticated().and().formLogin();

    }
}
```

##2.4 add oAuth support
to enable oAuth authentication, you need to add a set of properties
```yaml
security:
  oauth2:
    client:
      clientId: bd1c0a783ccdd1c9b9e4
      clientSecret: 1a9030fbca47a5b2c28e92f19050bb77824b5ad1
      accessTokenUri: https://github.com/login/oauth/access_token
      userAuthorizationUri: https://github.com/login/oauth/authorize
      clientAuthenticationScheme: form
    resource:
      userInfoUri: https://api.github.com/user
```

and change your security config
```java
@Configuration
@EnableOAuth2Sso
public class OauthSecurityConfig extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //customize security to use login form
        http.authorizeRequests().anyRequest().authenticated();

    }
}
```

#3. Add Mongo Support
add the following dependency
```xml
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-mongodb</artifactId>
		</dependency>
```

add following properties to config which mongo db are you going to use

```properties
spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=seed
```

create a POJO with spring and mongo annotation, for example
```Java
@Document
public class User {

    @Id
    String id;
    String username;
    String password;
    DateTime createdTime;
}
```
create a repository typed with the model created 

```Java
@Repository
public interface UserRepository extends MongoRepository<User, String> {
    
}
```
then you can inject the repository to your service
 
## 4. Add Scheduled Task

 you don't need to add new pom dependency for scheduled tasks. To create a scheduled task, you need to add 
  `@EnableScheduling` annotation on Application, and create a bean like:
 
 ```java
@Service
public class ScheduleService {

    private static final Logger logger = LoggerFactory.getLogger(ScheduleService.class);

    @Scheduled(fixedRate = 5000)
    public void printLog(){

        logger.info("Current time is {}", new DateTime());
    }
}
```

## 5. Add Actuator Support

add the following dependency in your pom file
```xml
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>

```

then you can visit some predefine page

| ID | Description	| Sensitive Default |
|---|---|---|
| actuator | Provides a hypermedia-based “discovery page” for the other endpoints. Requires Spring HATEOAS to be on the classpath. | true |
| auditevents | Exposes audit events information for the current application. | true |
| autoconfig | Displays an auto-configuration report showing all auto-configuration candidates and the reason why they ‘were’ or ‘were not’ applied. | true |
| beans | Displays a complete list of all the Spring beans in your application. | true |
| configprops | Displays a collated list of all @ConfigurationProperties. | true |
| dump | Performs a thread dump. | true |
| env | Exposes properties from Spring’s ConfigurableEnvironment. | true |
| flyway | Shows any Flyway database migrations that have been applied. | true |
| health | Shows application health information (when the application is secure, a simple ‘status’ when accessed over an unauthenticated connection or full message details when authenticated).| false |
| info | Displays arbitrary application info. | false |
| loggers | Shows and modifies the configuration of loggers in the application. | true |
| liquibase | Shows any Liquibase database migrations that have been applied. | true |
| metrics | Shows ‘metrics’ information for the current application. | true |
| mappings | Displays a collated list of all @RequestMapping paths. | true |
| shutdown | Allows the application to be gracefully shutdown (not enabled by default). | true |
| trace | Displays trace information (by default the last 100 HTTP requests).| true |
| docs | Displays documentation, including example requests and responses, for the Actuator’s endpoints. Requires spring-boot-actuator-docs to be on the classpath. | false |
| heapdump | Returns a GZip compressed hprof heap dump file. | true |
| jolokia | Exposes JMX beans over HTTP (when Jolokia is on the classpath). | true |
| logfile |Returns the contents of the logfile (if logging.file or logging.path properties have been set). Supports the use of the HTTP Range header to retrieve part of the log file’s content. | true |

## 5. add devTools support

you need to add following dependency to your pom 
```xml
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
        </dependency>
```