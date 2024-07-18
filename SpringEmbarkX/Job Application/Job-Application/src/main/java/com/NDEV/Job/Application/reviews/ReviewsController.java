package com.NDEV.Job.Application.reviews;

import com.NDEV.Job.Application.reviews.reviews_impl.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("companies/{company-id}/reviews")
public class ReviewsController {
    private final ReviewService reviewService;

    public ReviewsController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews(
            @PathVariable("company-id") Integer id
    )
    {
        return new ResponseEntity<>(reviewService.getAllReviews(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<String> addReviews(
            @PathVariable("company-id") Integer id,@RequestBody Review review
    )
    {
        boolean companyIdExists = reviewService.createCompanyReviews(id,review);
        if (companyIdExists)
        {
            return new ResponseEntity<>("Reviews Added Successfully",HttpStatus.OK);

        }
        return new ResponseEntity<>("Company ID was not found",HttpStatus.NOT_FOUND);

    }

    @GetMapping("{review-id}")
    public ResponseEntity<Review> getReview(
            @PathVariable("company-id") Integer id,
            @PathVariable("review-id") Integer reviewId
    )
    {
        return new ResponseEntity<>(reviewService.getReview(id,reviewId),HttpStatus.OK);
    }

    @PutMapping("{reviewId}")
    public ResponseEntity<String> updateReviewById(
            @PathVariable("company-id") Integer companyId,
            @PathVariable("reviewId") Integer id,
            @RequestBody Review review
    )
    {
        boolean isUpdated = reviewService.updateReview(companyId,id,review);
        if(isUpdated)
        {
            return new ResponseEntity<>("Review updated successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>("Review was not updated",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("{review-id}")
    public ResponseEntity<String> deleteReview(
            @PathVariable("company-id") Integer id,
            @PathVariable("review-id") Integer reviewId
    )
    {
        boolean isDeleted = reviewService.deleteReview(id,reviewId);
        if(isDeleted)
        {
            return new ResponseEntity<>("Company was successfully deleted",HttpStatus.OK);
        }
        return new ResponseEntity<>("Company was not deleted",HttpStatus.NOT_FOUND);

    }




}
