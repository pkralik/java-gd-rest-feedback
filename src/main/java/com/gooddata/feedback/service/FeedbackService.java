package com.gooddata.feedback.service;

import java.util.List;

import com.gooddata.feedback.model.Feedback;

public interface FeedbackService {
	Feedback getFeedbackById(Long id);
        List<Feedback> getFeedbackByName(String name);
	List<Feedback> getFeedbacks();
}
