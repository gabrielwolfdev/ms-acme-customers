package br.com.acme.core.usecase.impl;

import br.com.acme.core.service.FindCustomerService;
import br.com.acme.core.usecase.FindCustomerByUuidUseCase;
import br.com.acme.core.usecase.dto.CustomerDTO;
import br.com.acme.core.usecase.dto.converter.CustomerUseCaseConverter;
import br.com.acme.core.usecase.exception.CustomerNotFoundException;
import br.com.acme.domain.Customer;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Named
@Transactional
@RequiredArgsConstructor
public class FindCustomerByUuidUseCaseImpl implements FindCustomerByUuidUseCase {

    private final FindCustomerService findCustomerService;

    private final CustomerUseCaseConverter customerUseCaseConverter;

    @Override
    public CustomerDTO find(String uuid) {
        Customer customer = findCustomerService.find(uuid);

        if (customer == null) {
            throw new CustomerNotFoundException(String.format("Customer %s not found.", uuid));
        }

        return customerUseCaseConverter.convert(customer);
    }

}
