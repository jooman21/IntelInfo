package com.custom.eaii.training;

import com.custom.eaii.training.DTO.Create.CalculateTaxCommand;
import com.custom.eaii.training.entity.IntelInfo;
import com.custom.eaii.training.event.TaxCalculatedEvent;
import com.custom.eaii.training.exception.IntelInfoDomainException;
import com.custom.eaii.training.mapper.IntelInfoDataMapper;
import com.custom.eaii.training.ports.output.repository.IntelInfoRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TaxCalculatedCommandHelper {
    private final IntelInfoDataMapper intelInfoDataMapper;
    private final IntelInfoDomainService intelInfoDomainService;
    private final IntelInfoRepository intelInfoRepository;

    public TaxCalculatedCommandHelper(IntelInfoDataMapper intelInfoDataMapper, IntelInfoDomainService intelInfoDomainService, IntelInfoRepository intelInfoRepository) {
        this.intelInfoDataMapper = intelInfoDataMapper;
        this.intelInfoDomainService = intelInfoDomainService;
        this.intelInfoRepository = intelInfoRepository;
    }

    @Transactional
    public TaxCalculatedEvent persistIntelInfo(CalculateTaxCommand command) {
         IntelInfo intelInfo = intelInfoDataMapper.CalculateTaxCommandToIntelInfo(command);
        TaxCalculatedEvent taxCalculatedEvent = intelInfoDomainService.calculateTax(intelInfo);
        SaveCalculatedTax(taxCalculatedEvent.getIntelInfo());
        log.info(" Tax is Calculated with id:{}", taxCalculatedEvent.getIntelInfo().getId().getValue());
        return taxCalculatedEvent;
    }

    private void SaveCalculatedTax(IntelInfo intelInfo) {

        IntelInfo result = intelInfoRepository.save(intelInfo);
        if(result == null){
            log.error("Could not Calculated Tax");
            throw new IntelInfoDomainException("Could not Calculated Tax");
        }
        log.info("Calculated Tax is saved  saved with id: {}",
                result.getId().getValue());

    }
}
