package br.com.acme.core.service;

import br.com.acme.domain.vo.CreditScore;

public interface FindCreditBureauService {

    CreditScore findCreditScore(String document);

}
