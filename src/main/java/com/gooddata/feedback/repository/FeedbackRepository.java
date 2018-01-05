package com.gooddata.feedback.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gooddata.feedback.model.Feedback;

@Repository("feedbackRepository")
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
