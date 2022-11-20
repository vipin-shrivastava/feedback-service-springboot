package com.stackroute.feedbackservice.service;

import java.util.HashMap;

public interface RatingService {

    HashMap<String, Integer> getAverageFeedbackRagting(Integer hotelId, String type);
}
