package com.gooddata.feedback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.gooddata.feedback.model.Feedback;
import com.gooddata.feedback.repository.FeedbackRepository;

@SpringBootApplication
public class FeedbackApplication {
    
        private static final Logger LOGGER = LoggerFactory.getLogger(FeedbackApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FeedbackApplication.class, args);
	}
        
        @Bean
	public CommandLineRunner setup(FeedbackRepository feedbackRepository) {
		return (args) -> {
			feedbackRepository.save(new Feedback("Initial1", "Summary1"));
			feedbackRepository.save(new Feedback("Initial2", "Summary2"));
			LOGGER.info("The sample data has been generated");
		};
	}
}
