package com.stackroute.feedbackservice.entity;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * FeedbackDetails
 */
@Component
public class FeedbackDetails {

    public String message = null;

    public String title = null;

    public String stayType = null;

    public Set<String> filters = null;

    public Integer hotelId = null;

    public Integer userId = null;

    public Integer userRating = null;

    public HashMap<String, ?> ratings = null;
}
