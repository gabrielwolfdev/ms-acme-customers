package br.com.acme.core.service.impl;

import br.com.acme.core.dataprovider.event.CustomerDomainEventProducer;
import br.com.acme.core.dataprovider.persistence.dao.CustomerDAO;
import br.com.acme.core.service.CreateCustomerService;
import br.com.acme.domain.Customer;
import br.com.acme.domain.vo.BusinessReason;
import br.com.acme.domain.vo.DomainEvent;
import jakarta.inject.Named;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Named
@RequiredArgsConstructor
public class CreateCustomerServiceImpl implements CreateCustomerService {

    private final CustomerDAO customerDAO;

    private final CustomerDomainEventProducer customerDomainEventProducer;

    @Override
    public Customer create(Customer.CustomerBuilder customerBuilder) {
        Customer customer = customerDAO.insert(customerBuilder.build());

        DomainEvent<Customer> domainEvent = DomainEvent.<Customer>builder()
                .content(customer)
                .eventReason(BusinessReason.CUSTOMER_REGISTER.getValue())
                .build();

        customerDomainEventProducer.produce(domainEvent);

        return customer;
    }

}
