package com.custom.eaii.training;

import com.custom.eaii.training.entity.*;
import com.custom.eaii.training.event.*;

public interface IntelInfoDomainService {



    IntelInfoRegisteredEvent validateAndInitiateIntelligenceInformation(IntelInfo intelInfo);

    AddressCreatedEvent validateAndCreateAddress(IntelInfo intelInfo);

    AddressUpdatedEvent validateAndUpdateAddress(IntelInfo intelInfo, Address newAddress);

    ContactCreatedEvent validateAndCreateContact(IntelInfo intelInfo);


    ContactUpdatedEvent validateAndUpdateContact(IntelInfo intelInfo, Contact newContact);

    EmployeeCreatedEvent validateAndCreateEmployeeProfile(IntelInfo intelInfo);

    //update employee profile
    EmployeeProfileUpdatedEvent validateAndUpdateEmployeeProfile(IntelInfo intelInfo, EmployeeProfile newProfile);

    // create finance officer profile


    EmployeeProfileRemovedEvent validateAndRemoveEmployeeProfile(IntelInfo intelInfo);

    // create finance officer profile
    FinanceOfficerProfileCreatedEvent validateAndCreateProfile(IntelInfo intelInfo);

    // create Finance officer profile
    FinanceOfficerProfileUpdatedEvent validateAndUpdateFinanceProfile(IntelInfo intelInfo, FinanceOfficerProfile newProfile);

    // remove finance officer profile
    FinanceOfficerProfileRemovedEvent validateAndDeleteFinanceProfile(IntelInfo intelInfo);

    IntelInfoAcceptedEvent  checkIfIntelInfoIsQualifiedTobeAccepted(IntelInfo intelInfo);

    IntelInfoDeclinedEvent checkIfIntelInfoIsQualifiedTobeDeclined(IntelInfo intelInfo);

    ReasonRegisteredEvent checkDeclineReasonIsQualifiedToBeRegistered(IntelInfo intelInfo);

    MessageSentEvent sendMessageToInformantAndHigherOfficials(IntelInfo intelInfo);

    Re_InitializedIntelInfoEvent checkIfIntelInfoIsQualifiedTobeReinitialized(IntelInfo intelInfo);

    ComplainAcceptedEvent checkIfCompliantIsQualifiedTobeAccepted(IntelInfo intelInfo);
    OperationResultRegisteredEvent checkOperationIsSuccessful(IntelInfo intelInfo);



    UnsuccessfulOperationResultMessageSentEvent sendOperationResultToInformantAndHigherOfficials(IntelInfo intelInfo) ;


    
    TaxCalculatedEvent calculateTax(IntelInfo intelInfo);

  AllowancePaymentApprovedEvent makeAllowedPayment(IntelInfo intelInfo);

    AllowedPaymentDecisionMadeEvent makeAllowedPaymentDecision(IntelInfo intelInfo);

    PaymentDeclinedEvent registerDeclinedPaymentReason(IntelInfo intelInfo);
    
    DeadLineCheckedEvent checkDeadlineForInformantToReceivePayment(IntelInfo intelInfo);

    ReceiptAttachedEvent attachReceiptIfPaymentIsReceived(IntelInfo intelInfo);
    ReasonPresentedEvent presentInformantReason(IntelInfo intelInfo);

    SecondDeadLineCheckedEvent checkSecondDeadlineForInformantToReceivePayment(IntelInfo intelInfo);

    PaymentCanceledEvent cancelReceivingPaymentIfItIsExpired(IntelInfo intelInfo);
}
