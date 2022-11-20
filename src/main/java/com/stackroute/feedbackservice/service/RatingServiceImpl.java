package com.stackroute.feedbackservice.service;

import com.stackroute.feedbackservice.entity.Feedback;
import com.stackroute.feedbackservice.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RatingServiceImpl implements RatingService{

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public HashMap<String, Integer> getAverageFeedbackRagting(Integer hotelId, String type) {
        List<Feedback> ratings = ratingRepository.findByHotelId(hotelId);
        HashMap<String, Integer> hotelRating = new HashMap<>();

        Integer hospitality = 0;
        Integer hospitalityCount = 0;
        Integer location = 0;
        Integer facilities = 0;
        Integer cleanliness = 0;
        Integer valueformoney = 0;
        Integer locationCount = 0;
        Integer facilitiesCount = 0;
        Integer cleanlinessCount = 0;
        Integer valueformoneyCount = 0;

        Integer totalAverageforHotel = 0;



        Integer feedbackReviewtotal = 0;
        Integer feedbackElementSize = 0;

        for (Feedback data: ratings) {
            HashMap<String,?> Ratings =  data.getRatings();
            if (!Ratings.isEmpty() && type.equals("All") || data.getStayType().equals(type)) {
                for (Map.Entry<String, ?> mapElement : Ratings.entrySet()) {

                    feedbackReviewtotal += (Integer) mapElement.getValue();
                    feedbackElementSize += 1;

                    if (mapElement.getKey().equals("hospitality")) {
                        hospitality += (Integer) mapElement.getValue();
                        hospitalityCount += 1;
                        System.out.println("hospitality Feedback " + hospitality);
                    }
                    if (mapElement.getKey().equals("location")) {
                        location += (Integer) mapElement.getValue();
                        locationCount += 1;
                        System.out.println("location Feedback " + location);
                    }
                    if (mapElement.getKey().equals("facilities")) {
                        facilities += (Integer) mapElement.getValue();
                        facilitiesCount += 1;
                    }
                    if (mapElement.getKey() == "cleanliness") {
                        cleanliness += (Integer) mapElement.getValue();
                        cleanlinessCount += 1;
                    }
                    if (mapElement.getKey().equals("value for money")) {
                        valueformoney += (Integer) mapElement.getValue();
                        valueformoneyCount += 1;
                    }
                }

                Integer average = (feedbackReviewtotal / feedbackElementSize);
                System.out.println("Average Feedback " + average);
                totalAverageforHotel += average;
                hotelRating.put(data.getId(), average);
            }
            feedbackReviewtotal = 0;
            feedbackElementSize = 0;
        }



        if (!hospitalityCount.equals(0)) {
            hotelRating.put("hospitality", (hospitality/hospitalityCount));
        }

        if (!locationCount.equals(0)) {
            hotelRating.put("location",  (location/locationCount));
        }

        if (!facilitiesCount.equals(0)) {
            hotelRating.put("facilities", (facilities/facilitiesCount));
        }

        if (!cleanlinessCount.equals(0)) {
            hotelRating.put("cleanliness",  (cleanliness/cleanlinessCount));
        }

        if (!valueformoneyCount.equals(0)) {
            hotelRating.put("value for money", (valueformoney/valueformoneyCount));
        }

        hotelRating.put("Total Rating for hotel",  (totalAverageforHotel/ratings.size()));

        return hotelRating;
    }
}
