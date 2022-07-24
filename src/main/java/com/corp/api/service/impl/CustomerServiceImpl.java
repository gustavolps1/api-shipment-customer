package com.corp.api.service.impl;

import com.corp.api.controller.response.CustomerResponse;
import com.corp.api.dto.CustomerDTO;
import com.corp.api.entity.Customer;
import com.corp.api.repository.CustomerRepository;
import com.corp.api.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Optional;


@Slf4j
@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final IdentityDocumentFormatterService identityDocumentFormatterService;

    @Override
    public CustomerResponse getCustomerByIdentityDocument(String identityDocument) {
        Customer customer = getCustomer(identityDocument);
        CustomerDTO customerDTO = toDTO(customer);
        return CustomerResponse.builder()
                .customerDTO(customerDTO)
                .build();
    }

    private CustomerDTO toDTO(Customer customer) {
        String formattedIdentityDocument = getIdentityDocumentFormatted(customer.getIdentityDocument());
        return CustomerDTO.builder()
                .id(customer.getId().toString())
                .name(customer.getName())
                .identityDocument(formattedIdentityDocument)
                .build();
    }

    private Customer getCustomer(String identityDocument) {
        Optional<Customer> customerOpt = customerRepository.findByIdentityDocument(identityDocument);
        return customerOpt.orElse(null);
    }

    private String getIdentityDocumentFormatted(String identityDocument) {
        return identityDocumentFormatterService.format(identityDocument);
    }
}
