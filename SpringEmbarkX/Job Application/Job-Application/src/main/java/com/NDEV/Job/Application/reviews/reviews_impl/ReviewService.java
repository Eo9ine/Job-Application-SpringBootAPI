package com.NDEV.Job.Application.reviews.reviews_impl;

import com.NDEV.Job.Application.reviews.Review;
import com.NDEV.Job.Application.reviews.ReviewRepository;
import com.NDEV.Job.Application.reviews.ReviewServiceModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService implements ReviewServiceModel {

    private ReviewRepository reviewRepository;

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }
}
