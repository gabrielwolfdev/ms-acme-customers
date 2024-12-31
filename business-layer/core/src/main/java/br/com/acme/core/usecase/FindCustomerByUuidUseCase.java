package br.com.acme.core.usecase;

import br.com.acme.core.usecase.dto.CustomerDTO;

public interface FindCustomerByUuidUseCase {

    CustomerDTO find(String uuid);

}
