package br.com.acme.core.dataprovider.web.api;

import br.com.acme.core.dataprovider.web.api.dto.CreditScoreDTO;

public interface CreditBureauAPI {

    CreditScoreDTO findCreditScore(String document);

}
