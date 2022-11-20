package com.stackroute.feedbackservice.service;

import com.stackroute.feedbackservice.entity.Feedback;
import com.stackroute.feedbackservice.entity.FeedbackDetails;
import com.stackroute.feedbackservice.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FeedbackServiceImpl implements FeedbackService{

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Override
    public ResponseEntity<Object> saveFeedback(FeedbackDetails feedbackDetails) {

        Feedback feedback = new Feedback();

        if (feedbackDetails.message != null) {
            feedback.setMessage(feedbackDetails.message);
        }

        if (feedbackDetails.title != null) {
            feedback.setTitle(feedbackDetails.title);
        }

        if (feedbackDetails.filters != null) {
            feedback.setFilters(feedbackDetails.filters);
        }

        if (feedbackDetails.ratings != null) {
            feedback.setRatings(feedbackDetails.ratings);
        }

        if (feedbackDetails.stayType != null) {
            feedback.setStayType(feedbackDetails.stayType);
        }

        if (feedbackDetails.userId != null && feedbackDetails.hotelId != null) {
            feedback.setUserId(feedbackDetails.userId);
            feedback.setHotelId(feedbackDetails.hotelId);

            feedback.setCreatedAt(new Date());
            feedback.setUpdatedAt(new Date());

            Optional<Feedback> optionalFeedback = Optional.ofNullable(feedbackRepository.findByUserId(feedbackDetails.userId, feedbackDetails.hotelId));

            if (!optionalFeedback.isEmpty()) {
                return new ResponseEntity<>("Duplicate data found!!", HttpStatus.BAD_REQUEST);
            }

            Feedback savedFeedback = this.feedbackRepository.save(feedback);

            return new ResponseEntity<>(savedFeedback, HttpStatus.OK);
        }
        return new ResponseEntity<>("Some went wrong !!!", HttpStatus.BAD_REQUEST);
    }

    @Override
    public Feedback updateFeedback(String feedbackId, FeedbackDetails feedbackDetails) {
        System.out.println("Happy test");
        Optional<Feedback> optionalFeedback = Optional.ofNullable(feedbackRepository.findByFeedbackId(feedbackId));
        System.out.println(optionalFeedback);
        if (optionalFeedback.isEmpty()) {
            new ResponseEntity<>("No such data found!!!", HttpStatus.BAD_REQUEST);
        }

        Feedback feedbackToUpdate = optionalFeedback.get();

        if (feedbackDetails.message != null) {
            feedbackToUpdate.setMessage(feedbackDetails.message);
        }

        if (feedbackDetails.title != null) {
            feedbackToUpdate.setTitle(feedbackDetails.title);
        }

        if (feedbackDetails.filters != null) {
            feedbackToUpdate.setFilters(feedbackDetails.filters);
        }

        feedbackToUpdate.setUpdatedAt(new Date());

        return this.feedbackRepository.save(feedbackToUpdate);
    }


    @Override
    public ResponseEntity<Object> deleteFeedback(String feedbackId) {
        this.feedbackRepository.deleteByFeedbackId(feedbackId);
        return new ResponseEntity<>("Sucessfully updated!!!", HttpStatus.OK);
    }

    @Override
    public List<Feedback> getFeedbacksByHotelId(Integer hotelId) {
        List<Feedback> allFeedbacks = feedbackRepository.findByHotelId(hotelId);
        return allFeedbacks;
    }

}
