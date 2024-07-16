package com.NDEV.Job.Application.reviews;

import com.NDEV.Job.Application.reviews.reviews_impl.ReviewService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("companies/{company-id}/reviews")
public class ReviewsController {
    private ReviewService reviewService;

    public ReviewsController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public List<Review> getAllReviews()
    {

    }

}
