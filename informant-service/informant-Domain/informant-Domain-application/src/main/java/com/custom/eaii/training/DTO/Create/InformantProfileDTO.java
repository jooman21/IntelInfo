package com.custom.eaii.training.DTO.Create;

import com.custom.eaii.training.entity.Contact;
import com.custom.eaii.training.valueObjcet.IntelInfoId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InformantProfileDTO {
    private IntelInfoId intelInfoId;
    private UUID uuid;
    private String informantCode;
    private String firstName;
    private String lastName;
    private  String bankName;
    private  String accountNumber;
    private  String StreetAddress;
    private  String  PhoneNumber;
    private  String city;
    private  Boolean isActive;
}
