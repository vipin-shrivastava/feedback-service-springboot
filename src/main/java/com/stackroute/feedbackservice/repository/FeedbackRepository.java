package com.stackroute.feedbackservice.repository;

import com.stackroute.feedbackservice.entity.Feedback;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FeedbackRepository extends MongoRepository<Feedback, Integer> {

    @Query("{hotelId :?0}")
    List<Feedback> getFeedbackByHotelId(String hotelId);

    @Query("{id :?0}")
    Feedback findByFeedbackId(String id);

    @Query("{hotelId :?0}")
    List<Feedback>  findByHotelId(Integer hotelId);

    @Query("{userId :?0, hotelId: ?1}")
    Feedback findByUserId(Integer userId, Integer hotelId);

    @Query(value="{'_id' : ?0}", delete = true)
    void deleteByFeedbackId(String id);

    @Query("{createdAt :?0, userId: ?1, hotelId :?2}")
    List<Feedback> findByCreatedAt(Date createdAt, String userId, String hotelId);

}