package com.NDEV.Job.Application.reviews.reviews_impl;

import com.NDEV.Job.Application.company.Company;
import com.NDEV.Job.Application.company.company_impl.CompanyService;
import com.NDEV.Job.Application.reviews.Review;
import com.NDEV.Job.Application.reviews.ReviewRepository;
import com.NDEV.Job.Application.reviews.ReviewServiceModel;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService implements ReviewServiceModel {

    private final ReviewRepository reviewRepository;
    private final CompanyService companyService;



    public ReviewService(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Review> getAllReviews(Integer id) {
        List<Review> reviews = reviewRepository.findByCompanyId(id);
        return reviews;
    }

    @Override
    public boolean createCompanyReviews( Integer id, Review review) {
        Company companyId = companyService.findById(id);
        if (companyId != null)
        {
            review.setCompany(companyId);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public Review getReview(Integer companyId, Integer reviewId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews.stream().filter(review -> review.getId().equals(reviewId)).findFirst().orElse(null);
    }

    @Override
    public boolean updateReview(Integer companyId, Integer reviewId, Review updatedReview) {

        if (reviewRepository.findByCompanyId(companyId) != null)
        {

                updatedReview.setCompany(companyService.findById(companyId));
                Optional<Review> findReviewById = reviewRepository.findById(reviewId);
                Review foundId = findReviewById.get();
                foundId.setTitle(updatedReview.getTitle());
                foundId.setDescription(updatedReview.getDescription());
                foundId.setRating(updatedReview.getRating());
                reviewRepository.save(foundId);
                return  true;

        }
        return false;
    }

    @Override
    public boolean deleteReview(Integer companyId, Integer reviewId) {
        if(companyService.findById(companyId) != null)
        {
            reviewRepository.deleteById(reviewId);
            return true;
        }

        return false;
    }


}
