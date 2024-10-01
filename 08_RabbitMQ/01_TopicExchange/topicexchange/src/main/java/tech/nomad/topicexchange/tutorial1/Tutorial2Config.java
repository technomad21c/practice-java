package tech.nomad.topicexchange.tutorial1;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile({"tutorial2", "work-queues"})
@Configuration
public class Tutorial2Config {

    @Bean
    public Queue queue() {
        return new Queue("hello");
    }

    @Profile("receiver")
    private static class ReceiverConfig {

        @Bean
        public MyReceiver2 receiver1() {
            return new MyReceiver2(1);
        }

        @Bean
        public MyReceiver2 receiver2() {
            return new MyReceiver2(2);
        }
    }

    @Profile("sender")
    @Bean
    public MySender2 sender() {
        return new MySender2();
    }
}
