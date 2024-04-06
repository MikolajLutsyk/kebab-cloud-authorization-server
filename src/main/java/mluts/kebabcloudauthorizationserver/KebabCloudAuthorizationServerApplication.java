package mluts.kebabcloudauthorizationserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class KebabCloudAuthorizationServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(KebabCloudAuthorizationServerApplication.class, args);
    }

}
