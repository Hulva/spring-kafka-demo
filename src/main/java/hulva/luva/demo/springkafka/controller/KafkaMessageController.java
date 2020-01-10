package hulva.luva.demo.springkafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Hulva Luva.H
 * @since 2020-01-10
 *
 */
@RestController
@RequestMapping("kafka")
public class KafkaMessageController {
	@Autowired
	@Qualifier("e4kafkaTemplate")
	private KafkaTemplate<String, String> e4kafkaTemplate;
	@Autowired
	@Qualifier("e11kafkaTemplate")
	private KafkaTemplate<String, String> e11kafkaTemplate;

	@RequestMapping("/send")
	public String send(@RequestParam String message) {
		e4kafkaTemplate.send("demo", message);
		e11kafkaTemplate.send("demo", message);
		return "OK";
	}
}
