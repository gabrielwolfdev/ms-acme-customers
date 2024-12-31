package br.com.acme.application.dataprovider.impl.persistence.dao;

import br.com.acme.application.dataprovider.impl.persistence.common.TransactionScopeUtil;
import br.com.acme.application.dataprovider.impl.persistence.entity.CustomerEntity;
import br.com.acme.application.dataprovider.impl.persistence.entity.converter.CustomerEntityConverter;
import br.com.acme.core.dataprovider.persistence.dao.CustomerDAO;
import br.com.acme.domain.Customer;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class CustomerDAOImpl implements CustomerDAO {

    private final EntityManager entityManager;

    private final CustomerEntityConverter customerConverter;

    private final TransactionScopeUtil transactionScopeUtil;

    @Override
    public Customer insert(Customer customer) {
        CustomerEntity customerEntity = customerConverter.convert(customer);
        entityManager.persist(customerEntity);
        return customerConverter.convert(customerEntity);
    }

    @Override
    public Customer update(Customer customer) {
        CustomerEntity customerEntity = customerConverter.convert(customer, getCurrentVersion(customer));
        return customerConverter.convert(entityManager.merge(customerEntity));
    }

    @Override
    public Customer find(String uuid) {
        CustomerEntity customerEntity = entityManager.find(CustomerEntity.class, uuid);
        return customerConverter.convert(customerEntity);
    }

    private Long getCurrentVersion(Customer customer) {
        return transactionScopeUtil.getCurrentVersion(CustomerEntity.class, customer.getUuid());
    }

}
