package com.stackroute.feedbackservice.service;

import com.stackroute.feedbackservice.entity.Feedback;
import com.stackroute.feedbackservice.entity.FeedbackDetails;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FeedbackService {

    ResponseEntity<Object> saveFeedback(FeedbackDetails feedbackDetails);
    Feedback updateFeedback(String feedbackId, FeedbackDetails feedbackDetails);
    ResponseEntity<Object> deleteFeedback(String feedbackId);
    List<Feedback> getFeedbacksByHotelId(Integer hotelId);
}
