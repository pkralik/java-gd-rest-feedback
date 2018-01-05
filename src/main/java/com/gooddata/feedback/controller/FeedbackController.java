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

/**
 * Create a Feedback, Retrieve Feedbacks by Name, and Retrieve All Feedbacks
 */
@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FeedbackController.class);

    @Autowired
    private FeedbackService feedbackService;

    /**
     * Create new feedback.
     *
     * @param feedback feedback to be created
     * @return created feedback (including very useful id)
     */
    @RequestMapping(method = RequestMethod.POST)
    public Feedback createFeedback(@RequestBody Feedback feedback) {
        LOGGER.info("Creating Feedback : {}", feedback);
        return feedbackService.createFeedback(feedback);
    }

    /**
     * Get list of feedbacks by name.
     *
     * @param name
     * @return list of feedbacks
     */
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public List<Feedback> getFeedback(@PathVariable("name") String name) {
        LOGGER.info("Fetching Feedback with name {}", name);
        return feedbackService.getFeedbackByName(name);
    }

    /**
     * Get all feedbacks
     *
     * @return list of all feedbacks
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<Feedback> getFeedbacks() {
        LOGGER.info("Fetching all Feedbacks");
        return feedbackService.getFeedbacks();
    }
}
