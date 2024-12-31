package br.com.acme.core.dataprovider.persistence.dao;

import br.com.acme.domain.Customer;

public interface CustomerDAO {

    Customer insert(Customer customer);

    Customer update(Customer customer);

    Customer find(String uuid);

}
