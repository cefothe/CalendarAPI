package eu.stefanangelov.event.configuration;

import eu.stefanangelov.common.kafka.configuration.KafkaConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import(KafkaConfiguration.class)
@Configuration
public class ApplicationConfiguration {

}
