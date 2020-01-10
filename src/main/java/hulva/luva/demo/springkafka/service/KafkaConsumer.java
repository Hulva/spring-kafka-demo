package hulva.luva.demo.springkafka.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @author Hulva Luva.H
 * @since 2020-01-10
 *
 */
@Service
public class KafkaConsumer {

	@KafkaListener(topics = "demo", containerFactory = "e4KafkaListenerContainerFactory")
	public void listenE4(String message) {
		System.out.println("e4: " + message);
	}

	@KafkaListener(topics = "demo", containerFactory = "e11KafkaListenerContainerFactory")
	public void listenE11(String message) {
		System.out.println("e11" + message);
	}
}
