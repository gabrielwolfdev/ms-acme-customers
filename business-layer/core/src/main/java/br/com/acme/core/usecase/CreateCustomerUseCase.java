package br.com.acme.core.usecase;

import br.com.acme.core.usecase.dto.CustomerDTO;

public interface CreateCustomerUseCase {

    CustomerDTO create(CustomerDTO customer);

}
