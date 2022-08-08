package com.corp.api.controller;


import com.corp.api.controller.response.CustomerResponse;
import com.corp.api.service.impl.CustomerServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customer")
public class CustomerController {

    private final CustomerServiceImpl customerService;

    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = "/{identity_document}")
    public CustomerResponse getCustomer(@PathVariable(name = "identity_document") String identityDocument) {
        return customerService.getCustomerByIdentityDocument(identityDocument);
    }
}
