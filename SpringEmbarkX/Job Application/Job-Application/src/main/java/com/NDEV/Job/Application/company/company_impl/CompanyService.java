package com.NDEV.Job.Application.company.company_impl;

import com.NDEV.Job.Application.company.Company;
import com.NDEV.Job.Application.company.CompanyController;
import com.NDEV.Job.Application.company.CompanyRepository;
import com.NDEV.Job.Application.company.CompanyServiceModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService implements CompanyServiceModel {

    CompanyRepository repository;

    public CompanyService(CompanyRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Company> findAll()
    {
        return repository.findAll();
    }

    @Override
    public Company findById(Integer id)
    {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void createCompany(Company company)
    {
        repository.save(company);
    }

    @Override
    public boolean deleteCompany(Integer id)
    {
        try
        {
            repository.deleteById(id);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    @Override
    public boolean updateCompany(Integer id,Company company)
    {
        Optional<Company> findCompanyById = repository.findById(id);

        if(findCompanyById.isPresent())
        {
            Company companyToUpdate = findCompanyById.get();

            companyToUpdate.setCompanyName(company.getCompanyName());
            companyToUpdate.setDescription(company.getDescription());
            companyToUpdate.setJobs(company.getJobs());
            repository.save(companyToUpdate);
            return true;
        }
        return false;

    }
}
