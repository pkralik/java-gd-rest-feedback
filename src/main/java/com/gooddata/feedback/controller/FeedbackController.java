package com.gooddata.feedback.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gooddata.feedback.model.Feedback;
import com.gooddata.feedback.service.FeedbackService;

@RestController
public class FeedbackController {
	
        private static final Logger LOGGER = LoggerFactory.getLogger(FeedbackController.class);
        
        @Autowired
        private FeedbackService feedbackService;

        // -------------------Retrieve All Feedbacks---------------------------------------------
        @RequestMapping(value = "/feedback", method = RequestMethod.GET)
        public List<Feedback> getFeedbacks() {
		return feedbackService.getFeedbacks();
        }

        // -------------------Retrieve Single Feedback-------------------------------------------
        @RequestMapping(value = "/feedback/{id}", method = RequestMethod.GET)
        public Feedback getFeedback(@PathVariable("id") long id) {
                LOGGER.info("Fetching Feedback with id {}", id);
		return feedbackService.getFeedbackById(id);
	}

        // -------------------Retrieve Single Feedback-------------------------------------------
        @RequestMapping(value = "/feedback/{name}", method = RequestMethod.GET)
        public List<Feedback> getFeedback(@PathVariable("name") String name) {
                LOGGER.info("Fetching Feedback with name {}", name);
		return feedbackService.getFeedbackByName(name);
	}
        
        // -------------------Create a Feedback------------------------------------------------------
        @RequestMapping(value = "/feedback", method = RequestMethod.POST)
        public Feedback createFeedback(@PathVariable("name") String name, @PathVariable("summary") String summary) {
                LOGGER.info("Creating Feedback : {} {}", name, summary);
                return new Feedback("Initial1", "Summary1");
        }
}
