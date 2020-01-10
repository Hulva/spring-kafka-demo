package hulva.luva.demo.springkafka.config;

import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

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
public class KafkaConsumerConfig {
	Map<String, Object> e4kafkaprops;
	Map<String, Object> e11kafkaprops;

	@Bean
	public ConsumerFactory<String, String> e4ConsumerFactory() {
		if (!e4kafkaprops.containsKey(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG)) {
			e4kafkaprops.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		}
		if (!e4kafkaprops.containsKey(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG)) {
			e4kafkaprops.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		}

		return new DefaultKafkaConsumerFactory<>(e4kafkaprops);
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> e4KafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(e4ConsumerFactory());
		return factory;
	}

	@Bean
	public ConsumerFactory<String, String> e11ConsumerFactory() {
		if (!e11kafkaprops.containsKey(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG)) {
			e11kafkaprops.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		}
		if (!e11kafkaprops.containsKey(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG)) {
			e11kafkaprops.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		}

		return new DefaultKafkaConsumerFactory<>(e11kafkaprops);
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> e11KafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(e11ConsumerFactory());
		return factory;
	}

}
