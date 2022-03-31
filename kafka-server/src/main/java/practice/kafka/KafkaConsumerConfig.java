package practice.kafka;

import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.SeekToCurrentErrorHandler;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.util.backoff.FixedBackOff;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConsumerConfig {

    public static final String CONTAINER_FACTORY = "container-factory";

    private final KafkaProperties kafkaProperties;

    public KafkaConsumerConfig(KafkaProperties kafkaProperties) {
        this.kafkaProperties = kafkaProperties;
    }

    @Bean(CONTAINER_FACTORY)
    public KafkaListenerContainerFactory<?> kafkaListenerContainerFactory() {
        DefaultKafkaConsumerFactory<String, String> consumerFactory = new DefaultKafkaConsumerFactory<>(kafkaProperties.buildConsumerProperties());
        consumerFactory.setKeyDeserializer(new StringDeserializer());
        consumerFactory.setValueDeserializer(new StringDeserializer());

        ConcurrentKafkaListenerContainerFactory<String, String> listenerContainerFactory = new ConcurrentKafkaListenerContainerFactory<>();
        listenerContainerFactory.setConsumerFactory(consumerFactory);
        listenerContainerFactory.setRetryTemplate(retryTemplate());
        listenerContainerFactory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL_IMMEDIATE);
        listenerContainerFactory.setErrorHandler((
                new SeekToCurrentErrorHandler((record, exception) -> {
                    System.out.println("에러 발생 에러 발생\n" + record.toString() + "\n" + exception.toString());
                }, new FixedBackOff(0, 1))
        ));

        return listenerContainerFactory;
    }

    private RetryTemplate retryTemplate() {
        Map<Class<? extends Throwable>, Boolean> exceptionMap = new HashMap<>();
        exceptionMap.put(NullPointerException.class, true);
        exceptionMap.put(IllegalArgumentException.class, false);

        SimpleRetryPolicy policy = new SimpleRetryPolicy(3, exceptionMap, true);

        RetryTemplate retryTemplate = new RetryTemplate();
        retryTemplate.setRetryPolicy(policy);

        return retryTemplate;
    }
}
