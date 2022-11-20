//package com.stackroute.feedbackservice.entity;
//
//import org.springframework.data.annotation.Reference;
//import org.springframework.data.mongodb.core.mapping.DBRef;
//import org.springframework.data.mongodb.core.mapping.Document;
//import org.springframework.data.mongodb.core.mapping.FieldType;
//import org.springframework.data.mongodb.core.mapping.MongoId;
//
//@Document(value = "Rating")
//public class Rating {
//
//    @MongoId(FieldType.OBJECT_ID)
//    private String RatingId;
//
//    @DBRef
//    private Feedback feedbackId;
//
//    private Integer hotelId;
//    private Integer value;
//
//    public Rating() {
//    }
//
//    public Rating(Feedback feedbackId, Integer hotelId, Integer value) {
//        this.feedbackId = feedbackId;
//        this.hotelId = hotelId;
//        this.value = value;
//    }
//
//    public Object getFeedbackId() {
//        return feedbackId;
//    }
//
//    public void setFeedbackId(Feedback feedbackId) {
//        this.feedbackId = feedbackId;
//    }
//
//    public Integer getHotelId() {
//        return hotelId;
//    }
//
//    public void setHotelId(Integer hotelId) {
//        this.hotelId = hotelId;
//    }
//
//    public Integer getValue() {
//        return value;
//    }
//
//    public void setValue(Integer value) {
//        this.value = value;
//    }
//
//    @Override
//    public String toString() {
//        return "StarRating{" +
//                "RatingId=" + RatingId +
//                ", feedbackId=" + feedbackId +
//                ", hotelId=" + hotelId +
//                ", value=" + value +
//                '}';
//    }
//}
