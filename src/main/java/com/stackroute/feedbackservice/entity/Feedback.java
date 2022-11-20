package com.stackroute.feedbackservice.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

@Document(collection = "Feedbacks")
public class Feedback {

    @MongoId(FieldType.OBJECT_ID)
    private String id;

    @Field("Feedback_Message")
    private String message;

    @Field("Feedback_Title")
    private String title;

    @Field("Stay_Type")
    private String stayType;

    @Field("Feedback_Filters")
    private Set<String> filters;

    @Field("Created_At")
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date createdAt;

    @Field("Updated_At")
    @DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private Date updatedAt;

    @Field("Feedback_Ratings")
    private HashMap<String, ?> Ratings;

    @Field("User_Id")
    private Integer userId;

    @Field("Hotel_Id")
    private Integer hotelId;

    public Feedback() {
    }

    public Feedback(String message, String title, String stayType, Set<String> filters, Date createdAt, Date updatedAt, HashMap<String, ?> ratings, Integer userId, Integer hotelId) {
        this.message = message;
        this.title = title;
        this.stayType = stayType;
        this.filters = filters;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        Ratings = ratings;
        this.userId = userId;
        this.hotelId = hotelId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStayType() {
        return stayType;
    }

    public void setStayType(String stayType) {
        this.stayType = stayType;
    }

    public Set<String> getFilters() {
        return filters;
    }

    public void setFilters(Set<String> filters) {
        this.filters = filters;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public HashMap<String, ?> getRatings() {
        return Ratings;
    }

    public void setRatings(HashMap<String, ?> ratings) {
        Ratings = ratings;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "id='" + id + '\'' +
                ", message='" + message + '\'' +
                ", title='" + title + '\'' +
                ", stayType='" + stayType + '\'' +
                ", filters=" + filters +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", Ratings=" + Ratings +
                ", userId=" + userId +
                ", hotelId=" + hotelId +
                '}';
    }
}
