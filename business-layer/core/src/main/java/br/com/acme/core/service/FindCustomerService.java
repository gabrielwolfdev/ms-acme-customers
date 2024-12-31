package br.com.acme.core.service;

import br.com.acme.domain.Customer;

public interface FindCustomerService {

    Customer find(String uuid);

}
