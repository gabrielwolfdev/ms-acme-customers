package br.com.acme.application.dataprovider.impl.web.api.converter;

import br.com.acme.application.dataprovider.impl.web.restclient.dto.response.CreditScoreResponse;
import br.com.acme.core.dataprovider.web.api.dto.CreditScoreDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.JAKARTA)
public interface CreditBureauAPIConverter {

    CreditScoreDTO convert(CreditScoreResponse creditScoreResponse);

}
