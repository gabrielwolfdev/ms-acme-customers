package br.com.acme.core.dataprovider.event;

import br.com.acme.domain.Customer;
import br.com.acme.domain.vo.DomainEvent;

public interface CustomerDomainEventProducer {

    void produce(DomainEvent<Customer> customerDomainEvent);

}
