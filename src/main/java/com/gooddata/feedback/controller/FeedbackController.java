package com.gooddata.feedback.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gooddata.feedback.model.Feedback;
import com.gooddata.feedback.service.FeedbackService;

@RestController
public class FeedbackController {
	
        @Autowired
        private FeedbackService feedbackService;
	
        @RequestMapping(value = "/feedback", method = RequestMethod.GET)
        public List<Feedback> getFeedbacks() {
		return feedbackService.getAllFeedbacks();
        }

        @RequestMapping(value = "/feedback/{id}", method = RequestMethod.GET)
        public Feedback getEmployee(@PathVariable("id") long id) {
		return feedbackService.getFeedbackById(id);
	}
}


