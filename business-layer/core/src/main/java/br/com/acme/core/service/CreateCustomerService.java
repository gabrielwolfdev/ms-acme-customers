package br.com.acme.core.service;

import br.com.acme.domain.Customer;

public interface CreateCustomerService {

    Customer create(Customer.CustomerBuilder builder);

}
