package com.gooddata.feedback.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gooddata.feedback.model.Feedback;
import com.gooddata.feedback.service.FeedbackService;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FeedbackController.class);

    @Autowired
    private FeedbackService feedbackService;

    // -------------------Create a Feedback------------------------------------------------------
    @RequestMapping(method = RequestMethod.POST)
    public Feedback createFeedback(@RequestBody Feedback feedback) {
        LOGGER.info("Creating Feedback : {}", feedback);
        return feedbackService.createFeedback(feedback);
    }

    // -------------------Retrieve Single Feedback-------------------------------------------
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public List<Feedback> getFeedback(@PathVariable("name") String name) {
        LOGGER.info("Fetching Feedback with name {}", name);
        return feedbackService.getFeedbackByName(name);
    }

    // -------------------Retrieve All Feedbacks---------------------------------------------
    @RequestMapping(method = RequestMethod.GET)
    public List<Feedback> getFeedbacks() {
        LOGGER.info("Fetching all Feedbacks");
        return feedbackService.getFeedbacks();
    }
}
