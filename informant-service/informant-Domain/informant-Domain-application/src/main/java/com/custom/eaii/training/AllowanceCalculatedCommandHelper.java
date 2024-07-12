package com.custom.eaii.training;

import com.custom.eaii.training.DTO.Create.CalculateAllowanceCommand;
import com.custom.eaii.training.entity.IntelInfo;
import com.custom.eaii.training.event.AllowancePaymentApprovedEvent;
import com.custom.eaii.training.exception.IntelInfoDomainException;
import com.custom.eaii.training.mapper.IntelInfoDataMapper;
import com.custom.eaii.training.ports.output.repository.IntelInfoRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AllowanceCalculatedCommandHelper {
    private final IntelInfoDataMapper intelInfoDataMapper;
    private final IntelInfoDomainService intelInfoDomainService;
    private final IntelInfoRepository intelInfoRepository;

    public AllowanceCalculatedCommandHelper(IntelInfoDataMapper intelInfoDataMapper, IntelInfoDomainService intelInfoDomainService, IntelInfoRepository intelInfoRepository) {
        this.intelInfoDataMapper = intelInfoDataMapper;
        this.intelInfoDomainService = intelInfoDomainService;
        this.intelInfoRepository = intelInfoRepository;
    }

    @Transactional
    public AllowancePaymentApprovedEvent persistIntelInfo(CalculateAllowanceCommand command){


        IntelInfo intelInfo = intelInfoDataMapper.CalculateAllowanceCommandToIntelInfo(command);
        AllowancePaymentApprovedEvent allowancePaymentApprovedEvent = intelInfoDomainService.makeAllowedPayment(intelInfo);
        saveAllowedPayment(allowancePaymentApprovedEvent.getIntelInfo());
        log.info("Allowance Payment is made  with id:{}", allowancePaymentApprovedEvent.getIntelInfo().getId().getValue());
        return allowancePaymentApprovedEvent;
    }

    private void saveAllowedPayment(IntelInfo intelInfo) {

        IntelInfo result = intelInfoRepository.save(intelInfo);
        if(result == null){
            log.error("Could not save Allowed Payment");
            throw new IntelInfoDomainException("Could not save  Allowed Payment");
        }
        log.info("Allowed Payment is saved with id: {}",
                result.getId().getValue());

    }
}
