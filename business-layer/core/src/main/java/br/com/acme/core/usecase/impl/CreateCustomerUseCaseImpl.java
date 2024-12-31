package br.com.acme.core.usecase.impl;

import br.com.acme.core.service.CreateCustomerService;
import br.com.acme.core.service.FindCreditBureauService;
import br.com.acme.core.usecase.CreateCustomerUseCase;
import br.com.acme.core.usecase.dto.CustomerDTO;
import br.com.acme.core.usecase.dto.converter.CustomerUseCaseConverter;
import br.com.acme.domain.Customer;
import br.com.acme.domain.CustomerStatus;
import br.com.acme.domain.vo.CreditScore;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
@Named
@Transactional
@RequiredArgsConstructor
public class CreateCustomerUseCaseImpl implements CreateCustomerUseCase {

    private final CreateCustomerService createCustomerService;

    private final FindCreditBureauService creditBureauService;

    private final CustomerUseCaseConverter customerUseCaseConverter;

    @Override
    public CustomerDTO create(CustomerDTO customerDTO) {
        CreditScore creditScore = creditBureauService.findCreditScore(customerDTO.getDocument());

        var customerBuilder = Customer.builder()
                .uuid(UUID.randomUUID().toString())
                .status(CustomerStatus.ACTIVE)
                .firstName(customerDTO.getFirstName())
                .lastName(customerDTO.getLastName())
                .document(customerDTO.getDocument())
                .creditScore(creditScore);

        Customer customer = createCustomerService.create(customerBuilder);

        return customerUseCaseConverter.convert(customer);
    }

}
