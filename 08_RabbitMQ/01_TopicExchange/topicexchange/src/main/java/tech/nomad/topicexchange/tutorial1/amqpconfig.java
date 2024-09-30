package tech.nomad.topicexchange.tutorial1;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile({"amqp","hello-world"})
@Configuration
public class amqpconfig {

    @Bean
    public Queue hello() {
        return new Queue("hello");
    }

    @Profile("receiver")
    @Bean
    public MyReceiver receiver() {
        return new MyReceiver();
    }

    @Profile("sender")
    @Bean
    public MySender sender() {
        return new MySender();
    }
}
