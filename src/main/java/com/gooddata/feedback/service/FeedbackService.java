package com.gooddata.feedback.service;

import java.util.List;

import com.gooddata.feedback.model.Feedback;

public interface FeedbackService {

    Feedback createFeedback(String name, String summary);

    List<Feedback> getFeedbackByName(String name);

    List<Feedback> getFeedbacks();
}
