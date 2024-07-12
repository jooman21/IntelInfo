package com.custom.eaii.training.ports.input.service;

import com.custom.eaii.training.DTO.Create.*;
import com.custom.eaii.training.DTO.search.SearchComplaintResponse;
import com.custom.eaii.training.DTO.search.SearchIntelInfoResponse;
import com.custom.eaii.training.DTO.search.SearchOperationResponse;
import com.custom.eaii.training.DTO.search.SearchPaymentResponse;
import com.custom.eaii.training.valueObjcet.*;

import javax.validation.Valid;
import java.util.UUID;

public interface IntelInfoApplicationService {
    CreateIntelInfoResponse  CreateIntelInfo(@Valid RegisterIntelInfoCommand registerIntelInfoCommand);

    MakeDecisionResponse acceptIntelInfo(@Valid MakeDecisionCommand makeDecisionCommand);


    ReInitializeIntelInfoResponse re_InitializedIntelInfo(@Valid MakeDecisionCommand re_InitializedIntelInfoCommand);

    DeclineIntelInfoResponse declineIntelInfo(@Valid  MakeDecisionCommand declineIntelInfoCommand);

    ReasonRegisterResponse RegisterReason(@Valid  ReasonRegisterCommand reasonRegisterCommand);


    SendMessageResponse checkMessageSent(@Valid  SendMessageCommand sendMessageCommand);

    CreateComplainResponse saveAcceptedComplaint(@Valid PresentComplaintCommand presentComplaintCommand);

    RegisterOperationResultResponse SaveOperationResult(@Valid  RegisterOperationResultCommand command);

    SendUnsuccessfulOperationResultMessageResponse SendUnsuccessfulOperationResultMessage(@Valid SendMessageCommand command);

    CalculateTaxResponse TaxIsCalculated(@Valid  CalculateTaxCommand command);

    CalculateAllowanceResponse AllowancePaymentIsCalculated(@Valid  CalculateAllowanceCommand command);

    MakeAllowedPaymentDecisionResponse savePaymentDecision(@Valid  MakeAllowedPaymentDecisionCommand command);

    RegisterCauseResponse saveDeclinedPayment(@Valid  RegisterCauseCommand command);

    AskPaymentDeadlineResponse checkPaymentDeadline(@Valid  AskPaymentDeadlineCommand command);

    PresentReasonResponse savePresentedReason(@Valid  PresentReasonCommand command);

    AskPaymentDeadlineResponse checkSecondPaymentDeadline(@Valid  AskPaymentDeadlineCommand command);

    CreateEmployeeResponse createEmployee(CreateEmployeeCommand command);

    CreateAddressResponse createAddress(CreateAddressCommand command);

    CancelPaymentResponse saveCanceledPayment(@Valid  CancelPaymentCommand command);

    CreateEmployeeResponse updateEmployeeProfile(CreateEmployeeCommand command);

    CreateFinanceOfficerResponse updateFinanceProfile(CreateFinanceOfficerCommand command);

    CreateFinanceOfficerResponse createFinanceProfile(CreateFinanceOfficerCommand command);

    CreateContactResponse updateContact(CreateContactCommand command);

    CreateAddressResponse updateAddress(CreateAddressCommand command);

    CreateContactResponse createContact(CreateContactCommand command);

    SearchIntelInfoResponse searchIntelInfos();


    SearchPaymentResponse searchPayment();


    SearchIntelInfoResponse searchByIntelId(UUID intelInfoId);

    SearchIntelInfoResponse searchByStatus(@Valid IntelStatus status);


    SearchComplaintResponse searchByStatus(@Valid ComplainStatus status);

    SearchComplaintResponse searchComplaint();


    SearchComplaintResponse searchByComplaintId(@Valid UUID complainId);

    SearchOperationResponse searchOperations();


    SearchOperationResponse searchByOperationId(@Valid UUID operationId);

    SearchOperationResponse searchByStatus(@Valid OperationStatus status);

    SearchPaymentResponse searchByPaymentId(@Valid UUID paymentId);

    SearchPaymentResponse searchByStatus(@Valid PaymentStatus status);

    SearchPaymentResponse searchByDecision(@Valid PaymentDecision decision);
}
