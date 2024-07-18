package com.NDEV.Job.Application.reviews;

import com.NDEV.Job.Application.company.Company;

import java.util.List;

public interface ReviewServiceModel {

    List<Review> getAllReviews(Integer CompanyId);
    boolean createCompanyReviews(Integer CompanyId,Review review);
    Review getReview(Integer companyId, Integer reviewId);
    boolean updateReview(Integer companyId,Integer reviewId, Review review);
    boolean deleteReview(Integer companyId, Integer reviewId);
}
