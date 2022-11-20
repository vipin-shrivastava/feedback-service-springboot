package com.stackroute.feedbackservice.controller;

import com.stackroute.feedbackservice.entity.Feedback;
import com.stackroute.feedbackservice.entity.FeedbackDetails;
import com.stackroute.feedbackservice.service.FeedbackService;
import com.stackroute.feedbackservice.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;
    @Autowired
    private RatingService ratingService;

    /**
     * @param feedbackDetails
     * createFeedBack controller is for creating new feedback & will return success or bad request response
     **/
    @PostMapping(value = "/create")
    public ResponseEntity<Object> createFeedBack(@RequestBody FeedbackDetails feedbackDetails) {
        return feedbackService.saveFeedback(feedbackDetails);
    }

    /**
     * @param feedbackDetails
     * @param feedbackId      updateFeedBack controller is for creating update feedback & will return success or bad request response
     **/
    @PutMapping("/update/{feedbackId}")
    public Feedback updateFeedBack(@PathVariable String feedbackId, @RequestBody FeedbackDetails feedbackDetails) {
        return feedbackService.updateFeedback(feedbackId, feedbackDetails);
    }

    /**
     * @param feedbackId
     * deleteFeedback controller is for deleting the feedback
     **/
    @DeleteMapping("/delete/{feedbackId}")
    public ResponseEntity<Object> deleteFeedback(@PathVariable String feedbackId) {
        return feedbackService.deleteFeedback(feedbackId);
    }

    /**
     * @param hotelId
     * fetchFeedbacksByHotelId controller return the list of all feedbacks based on hotel
     **/
    @GetMapping("/fetchAll/{hotelId}")
    public ResponseEntity<List<Feedback>> fetchFeedbacksByHotelId(@PathVariable Integer hotelId) {
        List<Feedback> feedbackList = feedbackService.getFeedbacksByHotelId(hotelId);

        return new ResponseEntity<>(feedbackList, HttpStatus.CREATED);
    }





}
