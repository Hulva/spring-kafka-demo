package hulva.luva.demo.springkafka.config;

import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Hulva Luva.H
 * @since 2020-01-10
 *
 */
@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "kafka")
public class KafkaProducerConfig {
	Map<String, Object> e4kafkaprops;
	Map<String, Object> e11kafkaprops;

	@Bean
	public ProducerFactory<String, String> e4producerFactory() {
		e4kafkaprops.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		e4kafkaprops.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		return new DefaultKafkaProducerFactory<>(e4kafkaprops);
	}

	@Bean
	public KafkaTemplate<String, String> e4kafkaTemplate() {
		return new KafkaTemplate<>(e4producerFactory());
	}

	@Bean
	public ProducerFactory<String, String> e11producerFactory() {
		e11kafkaprops.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		e11kafkaprops.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		return new DefaultKafkaProducerFactory<>(e11kafkaprops);
	}

	@Bean
	public KafkaTemplate<String, String> e11kafkaTemplate() {
		return new KafkaTemplate<>(e11producerFactory());
	}
}
