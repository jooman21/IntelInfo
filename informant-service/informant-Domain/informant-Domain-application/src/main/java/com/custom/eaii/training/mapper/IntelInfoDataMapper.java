package com.custom.eaii.training.mapper;

import com.custom.eaii.training.DTO.Create.*;
import com.custom.eaii.training.entity.*;
import com.custom.eaii.training.valueObjcet.IntelInfoId;
import org.springframework.stereotype.Component;

@Component
public class IntelInfoDataMapper {
    public IntelInfo createIntelInfoCommandToIntelInfo(RegisterIntelInfoCommand command){
        return IntelInfo.builder()
                //.setFinanceOfficerProfile(mapFinanceOfficerProfileDTOInToFinanceOfficerProfile(command.getFinanceOfficerProfile()))
                .setInformantProfile(mapInformantProfileDTOInToInformantProfile(command.getInformantProfile()))
                .setContact(mapContactCommanddToIntelInfo(command.getContact()))
                // .setOperation(mapOperationDTOInToOperation(command.getOperation()))
                .setReferenceNumber(command.getReferenceNumber())
                .setIntelDescription(command.getIntelDescription())
                .setInformedWay(command.getInformedWay())
                .setIntelStatus(command.getIntelStatus())
                .setAddress(mapAddressCommanddToIntelInfo(command.getAddress()))
                .setCreatedAt(command.getCreatedAt())
                .build();
    }



    private Contact mapContactCommanddToIntelInfo(CreateContactCommand command){
        return Contact.builder()
                .setCity(command.getCity())
                .setIsActive(command.getIsActive())
                .setPhoneNumber(command.getPhoneNumber())
                .setStreetAddress(command.getStreetAddress())
                .build();

    }
    private Address mapAddressCommanddToIntelInfo(CreateAddressCommand command){
        return Address.builder()
                .setCity(command.getCity())
                .setSubCity(command.getSubCity())
                .setStreet(command.getStreet())
                .build();
    }

    //map intel-info to be accepted only use the data attributes that needs to be passed when accepting intel info
    public IntelInfo acceptIntelInfoCommandToIntelInfo(MakeDecisionCommand command){
        return IntelInfo.builder()
                .setReferenceNumber(command.getReferenceNumber())
                .setIntelDescription(command.getIntelDescription())
                .setInformedWay(command.getInformedWay())
                .setIntelStatus(command.getIntelStatus())
                .setAddress(command.getAddress())
                .setCreatedAt(command.getCreatedAt())
                .setEmployeeProfile(EmployeeProfile.builder()
                        .setFirstName(command.getFirstName())
                        .setLastName(command.getLastName())
                        .build()
                )
                .setInformantProfile(InformantProfile.builder()
                        .setInformantCode(command.getInformantCode())
                        .build()
                )
                .build();
    }
    //map intel-info to be decline only use the data attributes that needs to be passed when accepting intel info
    public IntelInfo re_InitializedIntelInfoCommandToIntelInfo(MakeDecisionCommand command){
        return IntelInfo.builder()
                .setReferenceNumber(command.getReferenceNumber())
                .setIntelDescription(command.getIntelDescription())
                .setInformedWay(command.getInformedWay())
                .setIntelStatus(command.getIntelStatus())
                .setAddress(command.getAddress())
                .setCreatedAt(command.getCreatedAt())
                .setEmployeeProfile(EmployeeProfile.builder()
                        .setFirstName(command.getFirstName())
                        .setLastName(command.getLastName())
                        .build()
                )
                .setInformantProfile(InformantProfile.builder()
                        .setInformantCode(command.getInformantCode())
                        .build()
                )
                .build();
    }
    public IntelInfo declineIntelInfoCommandToIntelInfo(MakeDecisionCommand command){
        return IntelInfo.builder()
                .setReferenceNumber(command.getReferenceNumber())
                .setIntelDescription(command.getIntelDescription())
                .setInformedWay(command.getInformedWay())
                .setIntelStatus(command.getIntelStatus())
                .setAddress(command.getAddress())
                .setCreatedAt(command.getCreatedAt())
                .setEmployeeProfile(EmployeeProfile.builder()
                        .setFirstName(command.getFirstName())
                        .setLastName(command.getLastName())
                        .setDeclineReason(command.getDeclineReason())
                        .build()
                )
                .setInformantProfile(InformantProfile.builder()
                        .setInformantCode(command.getInformantCode())
                        .build()
                )
                .build();
    }
    public IntelInfo RegisterReasonIntelInfoCommandToIntelInfo(ReasonRegisterCommand command){
        return IntelInfo.builder()
                .intelInfoId(command.getIntelInfoId())
                .setEmployeeProfile(EmployeeProfile.builder()
                        .setFirstName(command.getFirstName())
                        .setLastName(command.getLastName())
                        .setDeclineReason(command.getDeclineReason())
                        .build()
                )
                .setInformantProfile(InformantProfile.builder()
                        .setInformantCode(command.getInformantCode())
                        .build()
                )
                .build();

    }
    public IntelInfo SendMessageCommandToIntelInfo(SendMessageCommand command){
        return IntelInfo.builder()
                .intelInfoId(command.getIntelInfoId())
                .setEmployeeProfile(EmployeeProfile.builder()
                        .setFirstName(command.getFirstName())
                        .setLastName(command.getLastName())
                        .setDeclineReason(command.getDeclineReason())
                        .build()
                )
                .setInformantProfile(InformantProfile.builder()
                        .setInformantCode(command.getInformantCode())
                        .build()
                )
                .build();

    }




    public IntelInfo AcceptComplaintCommandToIntelInfo(PresentComplaintCommand command) {
        return IntelInfo.builder()
                .intelInfoId(command.getIntelInfoId())
                .setComplaint(Complaint.builder()
                        .setComplainDescription(command.getComplainDescription())
                        .setComplainStatus(command.getComplainStatus())
                        .build()
                )
                .setInformantProfile(InformantProfile.builder()
                        .setInformantProfileId(command.getInformantProfileId())
                        .setInformantCode(command.getInformantCode())
                        .build()
                )
                .build();


    }


    private InformantProfile mapInformantProfileDTOInToInformantProfile(InformantProfileDTO informantProfileDTO)
    {
        return InformantProfile.builder()
                .setInformantCode(informantProfileDTO.getInformantCode())
                .setFirstName(informantProfileDTO.getFirstName())
                .setLastName(informantProfileDTO.getLastName())
                .setBankName(informantProfileDTO.getBankName())
                .setAccountNumber(informantProfileDTO.getAccountNumber())
                .build();


    }

    public IntelInfo mapContactCommandToIntelInfo(CreateContactCommand command){
        return IntelInfo.builder()
                .setContact(Contact.builder()
                        .setPhoneNumber(command.getPhoneNumber())
                        .setStreetAddress(command.getStreetAddress())
                        .setCity(command.getCity())
                        .setIsActive(command.getIsActive())
                        .build())

                .build();

    }
    public IntelInfo mapAddressCommandToIntelInfo(CreateAddressCommand command){
        return  IntelInfo.builder()
                .setAddress(Address.builder()
                        .setCity(command.getCity())
                        .setStreet(command.getStreet())
                        .setSubCity(command.getSubCity())
                        .build()
                )
                .build();
    }

    public IntelInfo mapEmployeeCommandToIntelInfo(CreateEmployeeCommand command){
        return  IntelInfo.builder()
                // .intelInfoId(command.getIntelInfoId())
                .setEmployeeProfile(EmployeeProfile.builder()
                        .setFirstName(command.getFirstName())
                        .setLastName(command.getLastName())
                        .setCompanyId(command.getCompanyId())
                        .build()
                )
                .build();
    }
    public IntelInfo mapFinanceCommandToIntelInfo(CreateFinanceOfficerCommand command){
        return  IntelInfo.builder()
                .intelInfoId(command.getIntelInfoId())

                .setFinanceOfficerProfile(FinanceOfficerProfile.builder()
                        .setEmployeeId(command.getEmployeeId())
                        .setFirstName(command.getFirstName())
                        .setLastName(command.getLastName())
                        .build()
                )
                .build();
    }


    private FinanceOfficerProfile mapFinanceOfficerProfileDTOInToFinanceOfficerProfile(FinanceOfficerProfileDTO financeOfficerProfileDTO)
    {
        return FinanceOfficerProfile.builder()
                .setFirstName(financeOfficerProfileDTO.getFirstName())
                .setLastName(financeOfficerProfileDTO.getLastName())
                .setPaymentDeclineReason(financeOfficerProfileDTO.getPaymentDeclineReason())
                .setDeclinedAt(financeOfficerProfileDTO.getDeclinedAt())
                .build();


    }

    public IntelInfo RegisterOperationResultToIntelInfo(RegisterOperationResultCommand command){
        return IntelInfo.builder()
                .intelInfoId(command.getIntelInfoId())
                .setOperation(Operation.builder()
                        .setOperationStatus(command.getOperationStatus())
                        .setOperationResult(command.getOperationResult())
                        .setTakePlaceAt(command.getTakePlaceAt())
                        .build()
                )
                .build();

    }


    public IntelInfo SendOperationResultMessageCommandToIntelInfo(SendMessageCommand command){
        return IntelInfo.builder()
                .intelInfoId(command.getIntelInfoId())
                .setEmployeeProfile(EmployeeProfile.builder()
                        .setFirstName(command.getFirstName())
                        .setLastName(command.getLastName())
                        .setDeclineReason(command.getDeclineReason())
                        .build()
                )
                .setInformantProfile(InformantProfile.builder()
                        .setInformantCode(command.getInformantCode())
                        .build()
                )
                .setOperation(Operation.builder()
                        .setOperationStatus(command.getOperationStatus())
                        .setOperationResult(command.getOperationResult())
                        .setTakePlaceAt(command.getTakePlaceAt())
                        .build()
                )
                .build();

    }

    public IntelInfo CalculateTaxCommandToIntelInfo(CalculateTaxCommand command){
        return IntelInfo.builder()
                .intelInfoId(command.getIntelInfoId())
                .setPayment(Payment.builder()
                        .setPaymentStatus(command.getPaymentStatus())
                        .setItemPrice(command.getItemPrice())
                        .setCreatedAt(command.getCreatedAt())
                        .build()
                )
                .setInformantProfile(InformantProfile.builder()
                        .setInformantCode(command.getInformantCode())
                        .build()
                )
                .build();

    }
    public IntelInfo CalculateAllowanceCommandToIntelInfo(CalculateAllowanceCommand command){
        return IntelInfo.builder()
                .intelInfoId(command.getIntelInfoId())
                .setPayment(Payment.builder()
                        .setPaymentStatus(command.getPaymentStatus())
                        .setAllowedPayment(command.getAllowedPayment())
                        .setCreatedAt(command.getCreatedAt())
                        .build()
                )
                .setInformantProfile(InformantProfile.builder()
                        .setInformantCode(command.getInformantCode())
                        .build()
                )
                .build();

    }
    public IntelInfo MakeAllowedPaymentDecisionToIntelInfo(MakeAllowedPaymentDecisionCommand command){
        return IntelInfo.builder()
                .intelInfoId(command.getIntelInfoId())
                .setPayment(Payment.builder()
                        .setPaymentStatus(command.getPaymentStatus())
                        .setPaymentDecision(command.getPaymentDecision())
                        .setAllowedPayment(command.getAllowedPayment())
                        .setApprovedAt(command.getApprovedAt())
                        .build()
                )
                .setInformantProfile(InformantProfile.builder()
                        .setInformantCode(command.getInformantCode())
                        .build()
                )
                .build();

    }

    public IntelInfo RegisterCauseToIntelInfo(RegisterCauseCommand command){
        return IntelInfo.builder()
                .intelInfoId(command.getIntelInfoId())
                .setPayment(Payment.builder()
                        .setPaymentStatus(command.getPaymentStatus())
                        .setPaymentDecision(command.getPaymentDecision())
                        .build()
                )
                .setInformantProfile(InformantProfile.builder()
                        .setInformantCode(command.getInformantCode())
                        .build()
                )
                .setFinanceOfficerProfile(FinanceOfficerProfile.builder()
                        .setFirstName(command.getFirstName())
                        .setLastName(command.getLastName())
                        .setPaymentDeclineReason(command.getPaymentDeclineReason())
                        .setDeclinedAt(command.getDeclinedAt())
                        .build()
                )
                .build();

    }
    public IntelInfo AskPaymentDeadlineToIntelInfo(AskPaymentDeadlineCommand command){
        return IntelInfo.builder()
                .intelInfoId(command.getIntelInfoId())
                .setPayment(Payment.builder()
                        .setPaymentStatus(command.getPaymentStatus())
                        .setPaymentDecision(command.getPaymentDecision())
                        .setAllowedPayment(command.getAllowedPayment())
                        .setApprovedAt(command.getApprovedAt())
                        .build()
                )
                .setInformantProfile(InformantProfile.builder()
                        .setInformantCode(command.getInformantCode())
                        .build()
                )
                .build();
    }
    public IntelInfo PresentReasonToIntelInfo(PresentReasonCommand command){
        return IntelInfo.builder()
                .intelInfoId(command.getIntelInfoId())
                .setPayment(Payment.builder()
                        .setPaymentStatus(command.getPaymentStatus())
                        .setPaymentDecision(command.getPaymentDecision())
                        .build()
                )
                .setInformantProfile(InformantProfile.builder()
                        .setInformantCode(command.getInformantCode())
                        .build()
                )
                .build();
    }

    public IntelInfo AskSecondPaymentDeadlineToIntelInfo(AskPaymentDeadlineCommand command){
        return IntelInfo.builder()
                .intelInfoId(command.getIntelInfoId())
                .setPayment(Payment.builder()
                        .setPaymentStatus(command.getPaymentStatus())
                        .setPaymentDecision(command.getPaymentDecision())
                        .setAllowedPayment(command.getAllowedPayment())
                        .setApprovedAt(command.getApprovedAt())
                        .build()
                )
                .setInformantProfile(InformantProfile.builder()
                        .setInformantCode(command.getInformantCode())
                        .build()
                )
                .build();
    }
    public IntelInfo CancelPaymentToIntelInfo(CancelPaymentCommand command){
        return IntelInfo.builder()
                .intelInfoId(command.getIntelInfoId())
                .setPayment(Payment.builder()
                        .setPaymentStatus(command.getPaymentStatus())
                        .setPaymentDecision(command.getPaymentDecision())
                        .setCreatedAt(command.getCreatedAt())
                        .build()
                )
                .setInformantProfile(InformantProfile.builder()
                        .setInformantCode(command.getInformantCode())
                        .build()
                )
                .build();
    }
    private Complaint mapComplaintDTOInToComplaint(PresentComplaintCommand command) {
        return Complaint.builder()
                .setComplainDescription(command.getComplainDescription())
                .setComplainStatus(command.getComplainStatus())
                .setReportedAt(command.getReportedAt())
                .build();

    }
    private  EmployeeProfile mapEmployeeProfileToIntelInfo(EmployeeProfileDTO employeeProfileDTO){
        return EmployeeProfile.builder()
                .setFirstName(employeeProfileDTO.getFirstName())
                .setLastName(employeeProfileDTO.getLastName())
                .setDeclineReason(employeeProfileDTO.getDeclineReason())
                .build();
    }
    private Payment mapPaymentDTOInToPayment(CreatePaymentCommand command) {
        return  Payment.builder()
                .setPaymentStatus(command.getPaymentStatus())
                .setPaymentDecision(command.getPaymentDecision())
                .setItemPrice(command.getItemPrice())
                .setCreatedAt(command.getCreatedAt())
                .setAllowedPayment(command.getAllowedPayment())
                .setApprovedAt(command.getApprovedAt())
                .build();
    }

    private Operation mapOperationDTOInToOperation(CreateOperationCommand command) {
        return Operation.builder()
                .setOperationStatus(command.getOperationStatus())
                .setOperationResult(command.getOperationResult())
                .setTakePlaceAt(command.getTakePlaceAt())
                .build();
    }

    public CreateIntelInfoResponse intelInfoToRegisterIntelInfoResponse(IntelInfo intelInfo, String message) {
        return  CreateIntelInfoResponse.builder()
                .message(message)
                .build();

    }

    public MakeDecisionResponse intelInfoToAcceptIntelInfoResponse(IntelInfo intelInfo, String message){
        return  MakeDecisionResponse.builder()
                .message(message)
                .build();
    }

    public DeclineIntelInfoResponse intelInfoToDeclineIntelInfoResponse(IntelInfo intelInfo, String message){
        return  DeclineIntelInfoResponse.builder()
                .message(message)
                .build();
    }
    public ReasonRegisterResponse intelInfoToRegisterReasonResponse(IntelInfo intelInfo, String message){
        return  ReasonRegisterResponse.builder()
                .message(message)
                .build();
    }
    public SendMessageResponse intelInfoToSendMessageResponse(IntelInfo intelInfo, String message){
        return  SendMessageResponse.builder()
                .message(message)
                .build();
    }

    public ReInitializeIntelInfoResponse intelInfoToRe_InitializedIntelInfoResponse(IntelInfo intelInfo, String message){
        return  ReInitializeIntelInfoResponse.builder()
                .message(message)
                .build();
    }

    public CreateComplainResponse intelInfoToAcceptComplainResponse(IntelInfo intelInfo, String message){
        return  CreateComplainResponse.builder()
                .message(message)
                .build();
    }

    public RegisterOperationResultResponse intelInfoToRegisterOperationResultResponse(IntelInfo intelInfo, String message){
        return  RegisterOperationResultResponse.builder()
                .message(message)
                .build();
    }
    public SendUnsuccessfulOperationResultMessageResponse intelInfoToSendMessageOfOperationResultResponse(IntelInfo intelInfo, String message){
        return  SendUnsuccessfulOperationResultMessageResponse.builder()
                .message(message)
                .build();
    }


    public CalculateTaxResponse intelInfoToCalculatedTaxResponse(IntelInfo intelInfo, String message){
        return  CalculateTaxResponse.builder()
                .message(message)
                .build();
    }


    public CalculateAllowanceResponse intelInfoToCalculatedAllowanceResponse(IntelInfo intelInfo, String message){
        return  CalculateAllowanceResponse.builder()
                .message(message)
                .build();
    }

    public MakeAllowedPaymentDecisionResponse intelInfoToMakeAllowedPaymentDecision(IntelInfo intelInfo, String message){
        return  MakeAllowedPaymentDecisionResponse.builder()
                .message(message)
                .build();
    }



    public RegisterCauseResponse intelInfoToRegisterDeclinedCause(IntelInfo intelInfo, String message){
        return  RegisterCauseResponse.builder()
                .message(message)
                .build();
    }

    public AskPaymentDeadlineResponse intelInfoToAskPaymentDeadline(IntelInfo intelInfo, String message){
        return  AskPaymentDeadlineResponse.builder()
                .message(message)
                .build();
    }
    public PresentReasonResponse intelInfoToPresentReason(IntelInfo intelInfo, String message){
        return  PresentReasonResponse.builder()
                .message(message)
                .build();
    }

    public CancelPaymentResponse intelInfoToCancelPayment(IntelInfo intelInfo, String message){
        return  CancelPaymentResponse.builder()
                .message(message)
                .build();
    }

    public CreateAddressResponse intelInfoToCreateAddress(IntelInfo intelInfo, String message){
        return  CreateAddressResponse.builder()
                .message(message)
                .build();
    }

    public CreateContactResponse intelInfoToCreateContact(IntelInfo intelInfo, String message){
        return  CreateContactResponse.builder()
                .message(message)
                .build();
    }
    public CreateEmployeeResponse intelInfoToCreateEmployee(IntelInfo intelInfo, String message){
        return  CreateEmployeeResponse.builder()
                .message(message)
                .build();
    }
    public CreateFinanceOfficerResponse intelInfoToCreateFinanceOfficer(IntelInfo intelInfo, String message){
        return  CreateFinanceOfficerResponse.builder()
                .message(message)
                .build();
    }

}

