package com.custom.eaii.training;

import com.custom.eaii.training.DTO.Create.RegisterIntelInfoCommand;
import com.custom.eaii.training.entity.IntelInfo;
import com.custom.eaii.training.event.IntelInfoRegisteredEvent;
import com.custom.eaii.training.exception.IntelInfoDomainException;
import com.custom.eaii.training.mapper.IntelInfoDataMapper;
import com.custom.eaii.training.ports.output.repository.IntelInfoRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import jakarta.transaction.Transactional;
@Slf4j
@Component
public class IntelInfoRegisteredCommandHelper {

        private final IntelInfoDataMapper intelInfoDataMapper;
        private final IntelInfoDomainService intelInfoDomainService;
        private final IntelInfoRepository intelInfoRepository;

        public IntelInfoRegisteredCommandHelper(IntelInfoDataMapper intelInfoDataMapper, IntelInfoDomainService intelInfoDomainService, IntelInfoRepository intelInfoRepository) {
            this.intelInfoDataMapper = intelInfoDataMapper;
            this.intelInfoDomainService = intelInfoDomainService;
            this.intelInfoRepository = intelInfoRepository;
        }

        @Transactional
        public IntelInfoRegisteredEvent persistIntelInfo(RegisterIntelInfoCommand registerIntelInfoCommand){
            IntelInfo intelInfo = intelInfoDataMapper.createIntelInfoCommandToIntelInfo(registerIntelInfoCommand);
            IntelInfoRegisteredEvent intelInfoRegisteredEvent = intelInfoDomainService.validateAndInitiateIntelligenceInformation(intelInfo);
            saveIntelInfo(intelInfoRegisteredEvent.getIntelInfo());
            log.info("Intel Info is created with id:{}", intelInfoRegisteredEvent.getIntelInfo().getId().getValue());
            return intelInfoRegisteredEvent;
        }

        private void saveIntelInfo(IntelInfo intelInfo) {

            IntelInfo result = intelInfoRepository.save(intelInfo);
            if(result == null){
                log.error("Could not save Intel Info");
                throw new IntelInfoDomainException("Could not save Intel Info");
            }
            log.info("Intel Info is saved with id: {}",
                     result.getId().getValue());

        }
    }


