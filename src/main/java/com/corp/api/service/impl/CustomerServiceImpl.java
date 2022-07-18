package com.corp.api.service.impl;

import com.corp.api.controller.response.CustomerResponse;
import com.corp.api.dto.CustomerDTO;
import com.corp.api.entity.Customer;
import com.corp.api.repository.CustomerRepository;
import com.corp.api.service.CustomerService;
import com.corp.api.utils.IdentityDocumentUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final IdentityDocumentUtils identityDocumentUtils;

    @Override
    public CustomerResponse getCustomerByIdentityDocument(String identityDocument) {
        Optional<Customer> customerOpt = customerRepository.findByIdentityDocument(identityDocument);

        if (customerOpt.isPresent()) {
            Customer customer = customerOpt.get();
            String formattedIdentityDocument = formatIdentityDocument(customer.getIdentityDocument());

            CustomerDTO customerDTO = CustomerDTO.builder()
                    .id(customer.getId().toString())
                    .name(customer.getName())
                    .identityDocument(formattedIdentityDocument)
                    .build();

            return CustomerResponse.builder()
                    .customerDTO(customerDTO)
                    .build();
        }
        return null;
    }

    private String formatIdentityDocument(String identityDocument) {
        return identityDocumentUtils.format(identityDocument);
    }


}
