package com.custom.eaii.training.DTO.Create;


import com.custom.eaii.training.entity.Address;
import com.custom.eaii.training.valueObjcet.InformedWay;
import com.custom.eaii.training.valueObjcet.IntelDescription;
import com.custom.eaii.training.valueObjcet.IntelInfoId;
import com.custom.eaii.training.valueObjcet.IntelStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterIntelInfoCommand {

    private String referenceNumber;
    private InformantProfileDTO informantProfile;
    private CreateAddressCommand address;
    private CreateContactCommand contact;
    private InformedWay informedWay;
    private IntelStatus intelStatus;
    private IntelDescription intelDescription;
    private ZonedDateTime createdAt;


}
