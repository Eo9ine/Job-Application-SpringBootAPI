package com.NDEV.Job.Application.company;

import com.NDEV.Job.Application.company.company_impl.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    //Inject CompanyService class which renders services to client.
    private CompanyService service;

    public CompanyController(CompanyService companyService)
    {
        this.service = companyService;
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies()
    {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<Company> getCompanyById(
            @PathVariable("companyId") Integer id
    )
    {
        return new ResponseEntity<>(service.findById(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createCompany( @RequestBody  Company company)
    {
        service.createCompany(company);
        return new ResponseEntity<>("Company %s created successfully".formatted(company.getCompanyName()),HttpStatus.OK);
    }

    @PutMapping("/{companyId}")
    public ResponseEntity<String> updateCompany(
            @PathVariable("companyId") Integer id,@RequestBody Company company
    )
    {
        service.updateCompany(id,company);
        return new ResponseEntity<>("Company %s updated successfully".formatted(company.getCompanyName()),HttpStatus.OK);
    }

    @DeleteMapping("{companyId}")
    public ResponseEntity<String> deleteCompanyById(
            @PathVariable("companyId") Integer id
    )
    {
        service.deleteCompany(id);
        return new ResponseEntity<>("Company was successfully deleted",HttpStatus.OK);
    }
}
