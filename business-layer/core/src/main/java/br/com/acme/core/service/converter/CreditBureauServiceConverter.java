package br.com.acme.core.service.converter;

import br.com.acme.core.dataprovider.web.api.dto.CreditScoreDTO;
import br.com.acme.domain.vo.CreditScore;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.JAKARTA)
public interface CreditBureauServiceConverter {

    CreditScore convert(CreditScoreDTO creditScoreDTO);

}
