package com.NDEV.Job.Application.company;

import java.util.List;

public interface CompanyServiceModel {
    List<Company> findAll();
    Company findById(Integer id);
    void createCompany(Company company);
    boolean deleteCompany(Integer id);
    boolean updateCompany(Integer id,Company company);
}
