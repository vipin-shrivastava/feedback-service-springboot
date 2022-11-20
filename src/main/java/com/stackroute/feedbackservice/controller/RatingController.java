package com.stackroute.feedbackservice.controller;

import com.stackroute.feedbackservice.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    /**
     * @param hotelId fetchRatingByHotelId controller return the list of all feedbacks based on hotel
     **/
    @GetMapping("/fetchAll/{hotelId}")
    public HashMap<String, Integer> fetchRatingByHotelId(@PathVariable Integer hotelId, @RequestParam("stayType") String stayType) {
        System.out.println(hotelId+" = "+stayType);

        return ratingService.getAverageFeedbackRagting(hotelId, stayType);
    }





}
