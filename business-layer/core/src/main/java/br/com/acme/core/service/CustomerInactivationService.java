package br.com.acme.core.service;

import br.com.acme.domain.Customer;

public interface CustomerInactivationService {

    void inactivate(Customer customer);

}
