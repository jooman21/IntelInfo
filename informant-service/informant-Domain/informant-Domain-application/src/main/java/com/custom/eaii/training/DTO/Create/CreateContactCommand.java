package com.custom.eaii.training.DTO.Create;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateContactCommand {
    private  String StreetAddress;
    private  String  PhoneNumber;
    private  String city;
    private  Boolean isActive;
}
