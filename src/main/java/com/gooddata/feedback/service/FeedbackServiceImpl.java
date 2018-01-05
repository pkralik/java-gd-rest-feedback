package com.gooddata.feedback.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooddata.feedback.model.Feedback;
import com.gooddata.feedback.repository.FeedbackRepository;

@Service("feedbackService")
public class FeedbackServiceImpl implements FeedbackService {
	
	@Autowired
	FeedbackRepository feedbackRepository; 

	@Override
	public Feedback createFeedback(String name, String summary) {
		return feedbackRepository.save(new Feedback(name, summary));
	}

        @Override
	public List<Feedback> getFeedbackByName(String name) {
		return feedbackRepository.findByName(name);
	}
        
	@Override
	public List<Feedback> getFeedbacks() {
		return feedbackRepository.findAll();
	}

}