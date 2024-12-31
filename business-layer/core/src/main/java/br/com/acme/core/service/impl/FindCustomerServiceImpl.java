package br.com.acme.core.service.impl;

import br.com.acme.core.dataprovider.persistence.dao.CustomerDAO;
import br.com.acme.core.service.FindCustomerService;
import br.com.acme.domain.Customer;
import jakarta.inject.Named;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Named
@RequiredArgsConstructor
public class FindCustomerServiceImpl implements FindCustomerService {

    private final CustomerDAO customerDAO;

    @Override
    public Customer find(String uuid) {
        return customerDAO.find(uuid);
    }

}
