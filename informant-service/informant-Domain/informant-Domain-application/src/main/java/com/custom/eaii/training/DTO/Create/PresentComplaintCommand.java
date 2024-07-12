package com.custom.eaii.training.DTO.Create;

import com.custom.eaii.training.valueObjcet.ComplainDescription;
import com.custom.eaii.training.valueObjcet.ComplainStatus;
import com.custom.eaii.training.valueObjcet.InformantProfileId;
import com.custom.eaii.training.valueObjcet.IntelInfoId;
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
public class PresentComplaintCommand {
    private UUID id;
    private IntelInfoId intelInfoId;

    private InformantProfileId informantProfileId;

    private String informantCode;

    private ComplainDescription complainDescription;

    private ComplainStatus complainStatus;

    private ZonedDateTime reportedAt;
}
