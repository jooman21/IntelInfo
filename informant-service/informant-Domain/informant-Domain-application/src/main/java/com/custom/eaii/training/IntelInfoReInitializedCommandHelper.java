package com.custom.eaii.training;

import com.custom.eaii.training.DTO.Create.MakeDecisionCommand;
import com.custom.eaii.training.entity.IntelInfo;
import com.custom.eaii.training.event.Re_InitializedIntelInfoEvent;
import com.custom.eaii.training.exception.IntelInfoDomainException;
import com.custom.eaii.training.mapper.IntelInfoDataMapper;
import com.custom.eaii.training.ports.output.repository.IntelInfoRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class IntelInfoReInitializedCommandHelper {
    private final IntelInfoDataMapper intelInfoDataMapper;
    private final IntelInfoDomainService intelInfoDomainService;
    private final IntelInfoRepository intelInfoRepository;

    public IntelInfoReInitializedCommandHelper(IntelInfoDataMapper intelInfoDataMapper, IntelInfoDomainService intelInfoDomainService, IntelInfoRepository intelInfoRepository) {
        this.intelInfoDataMapper = intelInfoDataMapper;
        this.intelInfoDomainService = intelInfoDomainService;
        this.intelInfoRepository = intelInfoRepository;
    }
    @Transactional
    public Re_InitializedIntelInfoEvent persistIntelInfo(MakeDecisionCommand re_InitializedIntelInfoCommand) {
        IntelInfo intelInfo = intelInfoDataMapper.re_InitializedIntelInfoCommandToIntelInfo(re_InitializedIntelInfoCommand);
        Re_InitializedIntelInfoEvent re_InitializedIntelInfoEvent = intelInfoDomainService.checkIfIntelInfoIsQualifiedTobeReinitialized(intelInfo);
        saveRe_InitializedIntelInfo(re_InitializedIntelInfoEvent.getIntelInfo());
        log.info("Declined Intel Info is registered with id:{}", re_InitializedIntelInfoEvent.getIntelInfo().getId().getValue());
        return re_InitializedIntelInfoEvent;
    }

    private void saveRe_InitializedIntelInfo(IntelInfo intelInfo) {

        IntelInfo result = intelInfoRepository.save(intelInfo);
        if(result == null){
            log.error("Could not save saveRe_InitializedIntelInfo");
            throw new IntelInfoDomainException("Could not save saveRe_InitializedIntelInfo");
        }
        log.info("saveRe_InitializedIntelInfo is saved with id: {}",
                result.getId().getValue());

    }
}
