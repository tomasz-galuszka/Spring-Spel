package spel.part4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import spel.beans.SimpleCoffe;

/**
 * Created by tomasz on 25.10.14.
 */
@Configuration
public class Application {

    @Bean
    @Scope("prototype")
    public SimpleCoffe coffe() {
        return new SimpleCoffe();
    }
}
