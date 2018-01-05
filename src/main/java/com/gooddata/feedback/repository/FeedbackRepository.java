package com.gooddata.feedback.repository;

import com.gooddata.feedback.model.Feedback;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("feedbackRepository")
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

    List<Feedback> findByName(@Param("name") String name);
}
