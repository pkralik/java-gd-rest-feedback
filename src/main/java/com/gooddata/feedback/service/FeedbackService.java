package com.gooddata.feedback.service;

import java.util.List;

import com.gooddata.feedback.model.Feedback;

/**
 * Feedback Service
 */
public interface FeedbackService {

    Feedback createFeedback(Feedback feedback);

    List<Feedback> getFeedbackByName(String name);

    List<Feedback> getFeedbacks();
}
