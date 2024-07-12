package com.custom.eaii.training;

import com.custom.eaii.training.entity.*;
import com.custom.eaii.training.event.*;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;

@Slf4j

public class IntelInfoDomainServiceImpl implements IntelInfoDomainService {
    public static final String UTC = "UTC";


    @Override
    public IntelInfoRegisteredEvent validateAndInitiateIntelligenceInformation(IntelInfo intelInfo) {
        intelInfo.validateIntelInfo();
        intelInfo.initializeIntelInfo();
        log.info("Intel Info with id: {} is initialized", intelInfo.getId().getValue());
        return new IntelInfoRegisteredEvent(intelInfo, ZonedDateTime.now(ZoneId.of(UTC)));
    }

    @Override
    public AddressCreatedEvent validateAndCreateAddress(IntelInfo intelInfo){
        intelInfo.initializeAddress();
        log.info("Address is created with id: {} is initialized", intelInfo.getId().getValue());
        return new AddressCreatedEvent(intelInfo, ZonedDateTime.now(ZoneId.of(UTC)));
    }

    @Override
    public AddressUpdatedEvent validateAndUpdateAddress(IntelInfo intelInfo, Address newAddress){
        intelInfo.validateUpdateAddress(newAddress);
        log.info("Address is updated with id: {} is initialized", intelInfo.getId().getValue());
        return new AddressUpdatedEvent(intelInfo, ZonedDateTime.now(ZoneId.of(UTC)));
    }

    @Override
    public ContactCreatedEvent validateAndCreateContact(IntelInfo intelInfo){
        intelInfo.initializeContact();
        log.info("Contact is created with id: {} is initialized", intelInfo.getId().getValue());
        return new ContactCreatedEvent(intelInfo, ZonedDateTime.now(ZoneId.of(UTC)));
    }

    @Override
    public ContactUpdatedEvent validateAndUpdateContact(IntelInfo intelInfo, Contact newContact){
        intelInfo.validateUpdateContact(newContact);
        log.info("Contact is updated with id: {} is initialized", intelInfo.getId().getValue());
        return new ContactUpdatedEvent(intelInfo, ZonedDateTime.now(ZoneId.of(UTC)));
    }
    // create employee profile event

    @Override
    public EmployeeCreatedEvent validateAndCreateEmployeeProfile(IntelInfo intelInfo){
        intelInfo.initializeEmployeeProfile();
        log.info("Employee Profile is created with id: {} is initialized", intelInfo.getId().getValue());
        return new EmployeeCreatedEvent(intelInfo, ZonedDateTime.now(ZoneId.of(UTC)));
    }
    //update employee profile
    @Override
    public EmployeeProfileUpdatedEvent validateAndUpdateEmployeeProfile(IntelInfo intelInfo, EmployeeProfile newProfile){
        intelInfo.updateEmployeeProfile(newProfile);
        log.info("Employee Profile is updated with id: {} is initialized", intelInfo.getId().getValue());
        return new EmployeeProfileUpdatedEvent(intelInfo, ZonedDateTime.now(ZoneId.of(UTC)));
    }

    // remove employee profile
    @Override
    public EmployeeProfileRemovedEvent validateAndRemoveEmployeeProfile(IntelInfo intelInfo){
        intelInfo.removeEmployeeProfile();
        log.info("Employee Profile is deleted with id: {} is initialized", intelInfo.getId().getValue());
        return new EmployeeProfileRemovedEvent(intelInfo, ZonedDateTime.now(ZoneId.of(UTC)));
    }
    // create finance officer profile
    @Override
    public FinanceOfficerProfileCreatedEvent validateAndCreateProfile(IntelInfo intelInfo){
        intelInfo.initializeFinanceProfile();
        log.info("Employee Profile is updated with id: {} is initialized", intelInfo.getId().getValue());
        return new FinanceOfficerProfileCreatedEvent(intelInfo, ZonedDateTime.now(ZoneId.of(UTC)));
    }

    //  update finance officer profile
    @Override
    public FinanceOfficerProfileUpdatedEvent validateAndUpdateFinanceProfile(IntelInfo intelInfo, FinanceOfficerProfile newProfile){
        intelInfo.updateFinanceProfile(newProfile);
        log.info("Employee Profile is updated with id: {} is initialized", intelInfo.getId().getValue());
        return new FinanceOfficerProfileUpdatedEvent(intelInfo, ZonedDateTime.now(ZoneId.of(UTC)));
    }
// remove finance officer profile
@Override
public FinanceOfficerProfileRemovedEvent validateAndDeleteFinanceProfile(IntelInfo intelInfo){
    intelInfo.removeFinanceProfile();
    log.info("Employee Profile is deleted with id: {} is initialized", intelInfo.getId().getValue());
    return new FinanceOfficerProfileRemovedEvent(intelInfo, ZonedDateTime.now(ZoneId.of(UTC)));
}
    @Override
    public IntelInfoAcceptedEvent checkIfIntelInfoIsQualifiedTobeAccepted(IntelInfo intelInfo) {
        intelInfo.initializeIntelInfo();
        intelInfo.acceptIntelInfo();
        log.info("Intel Info with id: {} is Accepted", intelInfo.getId().getValue());
        return new IntelInfoAcceptedEvent(intelInfo, ZonedDateTime.now(ZoneId.of(UTC)));
    }

    @Override
    public IntelInfoDeclinedEvent checkIfIntelInfoIsQualifiedTobeDeclined(IntelInfo intelInfo) {
        intelInfo.initializeIntelInfo();
        intelInfo.declineIntelInfo();
        log.info("Intel Info with id: {} is Declined" , intelInfo.getId().getValue());
        return new IntelInfoDeclinedEvent(intelInfo,   ZonedDateTime.now(ZoneId.of(UTC)));
    }




    @Override
    public ReasonRegisteredEvent checkDeclineReasonIsQualifiedToBeRegistered(IntelInfo intelInfo) {
        intelInfo.initializeEmployeeProfile();
        intelInfo.registerReason();
        String declineReason = intelInfo.getEmployeeProfile().getDeclineReason();
        log.info("Intel Info with this Declined id: {} is registered", intelInfo.getId().getValue());
        return new ReasonRegisteredEvent(intelInfo,declineReason, ZonedDateTime.now(ZoneId.of(UTC)));
    }



    @Override
    public MessageSentEvent sendMessageToInformantAndHigherOfficials(IntelInfo intelInfo) {
        intelInfo.declineIntelInfo();
        intelInfo.sendMessage();
        String declineReason = intelInfo.getEmployeeProfile().getDeclineReason();
        log.info("Declined Intel Info with id: {} is sent",intelInfo.getId().getValue());
        return new MessageSentEvent(intelInfo, declineReason,  ZonedDateTime.now(ZoneId.of(UTC)));
    }



    @Override
    public Re_InitializedIntelInfoEvent checkIfIntelInfoIsQualifiedTobeReinitialized( IntelInfo intelInfo) {
        intelInfo.declineIntelInfo();
        intelInfo.reInitializedIntelInfo();
        log.info("Declined Intel Info with id: {} is re-initialized", intelInfo.getId().getValue());
        return new Re_InitializedIntelInfoEvent(intelInfo, ZonedDateTime.now(ZoneId.of(UTC)));
    }
    @Override
    public ComplainAcceptedEvent checkIfCompliantIsQualifiedTobeAccepted(IntelInfo intelInfo){
        intelInfo.validateComplaint();
        intelInfo.acceptCompliant();
        ZonedDateTime reportedAt = ZonedDateTime.now(ZoneId.of(UTC));
        log.info("Declined Intel Info with id: {} is re-initialized with accepted complain", intelInfo.getId().getValue());
        return  new ComplainAcceptedEvent(intelInfo,reportedAt);
    }

    @Override
    public OperationResultRegisteredEvent checkOperationIsSuccessful(IntelInfo intelInfo){
        intelInfo.successfulOperation();
        ZonedDateTime takePlaceAt = ZonedDateTime.now(ZoneId.of(UTC));
        log.info("Successful Operation result is registered with id: {}", intelInfo.getId().getValue());
        return  new OperationResultRegisteredEvent(intelInfo,takePlaceAt);
    }



    @Override
    public UnsuccessfulOperationResultMessageSentEvent sendOperationResultToInformantAndHigherOfficials(IntelInfo intelInfo) {
        intelInfo.sendUnsuccessfulOperationResultMessage();
        //String sendMessage =  intelInfo.getEmployeeProfile().getSendMessage();
        ZonedDateTime takePlaceAt = ZonedDateTime.now(ZoneId.of(UTC));
        log.info("Successful Operation result is registered with id: {}", intelInfo.getId().getValue());
        return  new UnsuccessfulOperationResultMessageSentEvent(intelInfo, takePlaceAt);
    }




    @Override
    public TaxCalculatedEvent calculateTax(IntelInfo intelInfo){
        intelInfo.initializePayment();
        BigDecimal taxedAmount = intelInfo.calculateTax();  // Ensure calculateTax returns the taxed amount
        log.info("Tax calculated with id: {}, taxed amount: {}", intelInfo.getId().getValue(), taxedAmount);
        return new TaxCalculatedEvent(intelInfo, taxedAmount.toString(), ZonedDateTime.now(ZoneId.of(UTC)) );

    }
    @Override
    public AllowancePaymentApprovedEvent makeAllowedPayment(IntelInfo intelInfo) {
        intelInfo.initializePayment();
        BigDecimal taxedAmount = intelInfo.calculateTax();  // Ensuring calculateTax is called to get the taxed amount
        intelInfo.validateAllowedPayment();
        BigDecimal allowedPayment = intelInfo.getPayment().getAllowedPayment();  // Ensuring  allowed payment is fetched correctly
        log.info("Allowed Payment calculated with id: {}, allowed payment: {}", intelInfo.getId().getValue(), allowedPayment);
        return new AllowancePaymentApprovedEvent(intelInfo, allowedPayment.toString(), ZonedDateTime.now(ZoneId.of(UTC)));
    }
    @Override
    public AllowedPaymentDecisionMadeEvent makeAllowedPaymentDecision(IntelInfo intelInfo) {
        intelInfo.initializePayment();
        intelInfo.validatePaymentDecision();
        log.info("Payment Approved with id: {}", intelInfo.getId().getValue());
        return new AllowedPaymentDecisionMadeEvent(intelInfo, ZonedDateTime.now(ZoneId.of(UTC)));
    }
    @Override
    public PaymentDeclinedEvent registerDeclinedPaymentReason(IntelInfo intelInfo){
        intelInfo.initializePayment();
        intelInfo.calculateTax();
        intelInfo.validateDeclinedAllowedPayment();
        String declinedPaymentReason = intelInfo.getFinanceOfficerProfile().getPaymentDeclineReason();
        log.info("Declined Payment reason registered   with id: {}", intelInfo.getId().getValue());
        return  new PaymentDeclinedEvent(intelInfo, declinedPaymentReason);
    }
    @Override
    public DeadLineCheckedEvent checkDeadlineForInformantToReceivePayment(IntelInfo intelInfo){
        intelInfo.initializePayment();
        intelInfo.validateReceivedPayment();
        String paymentStatus = intelInfo.getPayment().getPaymentStatus().toString();
        log.info("Deadline passed with this id: {}", intelInfo.getId().getValue());
        return  new DeadLineCheckedEvent(intelInfo, paymentStatus);
    }

    @Override
    public ReceiptAttachedEvent attachReceiptIfPaymentIsReceived(IntelInfo intelInfo) {
        intelInfo.initializePayment();
        intelInfo.validateAttachReceipt();
        String attachReceipt = Arrays.toString(intelInfo.getPayment().getPaymentReceipt());
        log.info("Receipt Attached with this id: {}", intelInfo.getId().getValue());
        return  new ReceiptAttachedEvent(intelInfo, attachReceipt);
    }

    @Override
    public ReasonPresentedEvent presentInformantReason(IntelInfo intelInfo) {
        intelInfo.initializePayment();
        intelInfo.validateReasonPresented();
        String Declined = intelInfo.getPayment().getPaymentDecision().toString();
        log.info("Declined Payment with this id: {}", intelInfo.getId().getValue());
        return  new ReasonPresentedEvent(intelInfo, Declined);
    }

    @Override
    public  SecondDeadLineCheckedEvent checkSecondDeadlineForInformantToReceivePayment(IntelInfo intelInfo){
        intelInfo.initializePayment();
        intelInfo.validateSecondDeadlineReceivedPayment();
        String paymentStatus = intelInfo.getPayment().getPaymentStatus().toString();
        log.info(" Second Deadline passed with this id: {}", intelInfo.getId().getValue());
        return  new SecondDeadLineCheckedEvent(intelInfo, paymentStatus);
    }

    @Override
    public PaymentCanceledEvent cancelReceivingPaymentIfItIsExpired(IntelInfo intelInfo) {
        intelInfo.initializePayment();
        intelInfo.validateReceivingPaymentExpiration();
        String paymentStatus = intelInfo.getPayment().getPaymentStatus().toString();
        log.info("Declined Payment with this id: {}", intelInfo.getId().getValue());
        return  new PaymentCanceledEvent(intelInfo, paymentStatus);
    }
}