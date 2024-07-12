package com.custom.eaii.training.entity;

import com.custom.eaii.training.domain.entity.AggregateRoot;
import com.custom.eaii.training.exception.IntelInfoDomainException;
import com.custom.eaii.training.valueObjcet.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Random;
import java.util.UUID;


public class IntelInfo extends AggregateRoot<IntelInfoId> {
  private String referenceNumber;
  private InformantProfile informantProfile;

  private EmployeeProfile employeeProfile;

  private FinanceOfficerProfile financeOfficerProfile;
  private InformedWay informedWay;

  private Operation operation;

  private Payment payment;

  private Complaint complaint;
  private IntelStatus intelStatus;
  private IntelDescription intelDescription;

  private Address address;

  private Contact contact;
  private ZonedDateTime createdAt;


  public IntelInfo(Builder builder) {
    super.setId(builder.intelInfoId);
    this.referenceNumber = builder.referenceNumber;
    this.employeeProfile = builder.employeeProfile;
    this.informantProfile = builder.informantProfile;
    this.financeOfficerProfile = builder.financeOfficerProfile;
    this.informedWay = builder.informedWay;
    this.operation = builder.operation;
    this.payment = builder.payment;
    this.complaint = builder.complaint;
    this.intelStatus = builder.intelStatus;
    this.intelDescription = builder.intelDescription;
    this.address = builder.address;
    this.contact = builder.contact;
    this.createdAt = builder.createdAt;
  }
// create constructor

  public IntelInfo(InformantProfile informantProfile, EmployeeProfile employeeProfile, FinanceOfficerProfile financeOfficerProfile, Contact contact, Address address) {
    this.informantProfile = informantProfile;
    this.employeeProfile = employeeProfile;
    this.financeOfficerProfile = financeOfficerProfile;
    this.contact = contact;
    this.address = address;
  }

  public void validateIntelInfo(){
    validateInitialIntelInfo();
  }

  private void validateInitialIntelInfo() {
    if (intelStatus != null || (getId() != null && getId().getValue() != null)) {
      throw new IntelInfoDomainException(
              "Intel Info is not in correct state for initialization");
    }
  }



  public void initializeInformantProfile() {
    validateInitialInformant(); // Check if informant is in correct state for initialization
    UUID newId = UUID.randomUUID();
    if (informantProfile != null) {
      informantProfile.setId(new InformantProfileId(newId));
    }
  }

  private void validateInitialInformant() {
    if ( informantProfile != null && informantProfile.getId() != null) {
      throw new IntelInfoDomainException("Informant is not in correct state for initialization!");
    }
  }


  // initialize and validate informantProfile, intel-info method
  public void initializeIntelInfo(){
    setId(new IntelInfoId(UUID.randomUUID()));
    intelStatus = IntelStatus.INITIALIZED;
    initializeInformantProfile();
    validateInitialContact();
    informantProfile.generateInformantCode();
    createdAt = ZonedDateTime.now(ZoneId.of("UTC"));
    referenceNumber = generateReferenceNumber();
  }

  // accept  intel-info method
  private static final Duration ACCEPTANCE_WINDOW = Duration.ofDays(7);
  private void checkIfIntelInfoIsQualifiedTobeAccepted() {
    ZonedDateTime currentDateTime = ZonedDateTime.now();
    Duration elapsedTime = Duration.between(createdAt, currentDateTime);

    // Check if intelStatus is INITIALIZED or RE_INITIALIZED and if the elapsed time is within the acceptance window

    if((intelStatus!= IntelStatus.INITIALIZED && intelStatus != IntelStatus.RE_INITIALIZED) ||
      elapsedTime.compareTo(ACCEPTANCE_WINDOW) > 0) {
      throw new IntelInfoDomainException(
              "Intelligence Information is not in correct state for Acceptance or the acceptance window has passed."
      );
    }
  }

  public void acceptIntelInfo(){
    checkIfIntelInfoIsQualifiedTobeAccepted();
    intelStatus = IntelStatus.ACCEPTED;
  }

  // decline  intel-info method
  private void checkIfIntelInfoIsQualifiedTobeDeclined() {
    if (intelStatus != IntelStatus.INITIALIZED) {
      throw new IntelInfoDomainException("Intelligence Information is Rejected");
    }
  }

  public void declineIntelInfo(){
    checkIfIntelInfoIsQualifiedTobeDeclined();
    intelStatus = IntelStatus.DECLINED;

  }



  // send operation result message method
  public void sendMessageToInformantAndHigherOfficials() {
    if (intelStatus != IntelStatus.DECLINED || employeeProfile.getDeclineReason() == null) {
      throw new IntelInfoDomainException("IntelInfo must be declined and have a registered reason.");
    }
  }
 public void sendMessage(){
   sendMessageToInformantAndHigherOfficials();


 }

// create contact
  public void initializeContact(){
    validateInitialContact();
    UUID newId = UUID.randomUUID();
    if(contact != null){
      contact.setId(new ContactId(newId));
    }
  }
  public void validateInitialContact(){
    if (contact.getId() != null){
      throw new IntelInfoDomainException(
              "Contact is not in correct state for initialization"
      );
    }
  }
  //update contact
  public void updateContact(Contact newContact) {
    if (newContact == null) {
      throw new IntelInfoDomainException("Contact does not exist");
    }
    this.contact = newContact;
  }

  public void validateUpdateContact(Contact newContact){
    updateContact(newContact);
  }

  // create address
  public void initializeAddress() {
    validateInitialAddress();
    UUID newId = UUID.randomUUID();
    if (address != null) {
      address.setId(new AddressId(newId));
    }
  }
  public void validateInitialAddress(){
    if (address.getId() != null){
      throw new IntelInfoDomainException(
              "Address is not in correct state for initialization"
      );
    }
    if(address.getCity() == null || address.getSubCity() == null || address.getStreet() == null){
      throw new IntelInfoDomainException("All address filed must not be empty ");
    }
  }
//update Address
public void updateAddress(Address newAddress) {
  if (newAddress == null) {
    throw new IntelInfoDomainException("Address does not exist");
  }
  this.address = newAddress;
}

  public void validateUpdateAddress(Address newAddress){
    updateAddress(newAddress);
  }
// logic related to employee Profile
  public void initializeEmployeeProfile(){
    validateInitialEmployeeProfile();
    UUID newId = UUID.randomUUID();
    if(employeeProfile != null){
      employeeProfile.setId(new EmployeeProfileId(newId));
    }
  }

  public void validateInitialEmployeeProfile(){
    if (employeeProfile.getId() != null){
      throw new IntelInfoDomainException(
              "Employee profile is not in correct state for initialization"
      );
    }
  }
// update employee profile

  public void updateEmployeeProfile(EmployeeProfile newProfile) {
    if (newProfile == null) {
      throw new IntelInfoDomainException("EmployeeProfile does not exist");
    }
    this.employeeProfile = newProfile;
  }
  //delete employee profile
  public void removeEmployeeProfile() {
    if (this.employeeProfile == null) {
      throw new IllegalStateException("Employee profile does not exist");
    }
    this.employeeProfile = null;
  }


  // initialize FinanceProfile
  public void initializeFinanceProfile(){
    validateInitialFinanceProfile();
    UUID newId = UUID.randomUUID();
    if(financeOfficerProfile != null){
      financeOfficerProfile.setId(new FinanceOfficerId(newId));
    }
  }

  public void validateInitialFinanceProfile(){
    if (financeOfficerProfile.getId() != null){
      throw new IntelInfoDomainException(
              "Finance officer profile is not in correct state for initialization"
      );
    }
  }
// update Finance profile

  public void updateFinanceProfile(FinanceOfficerProfile newProfile) {
    if (newProfile == null) {
      throw new IntelInfoDomainException("Finance Profile does not exist");
    }
    this.financeOfficerProfile = newProfile;
  }
  //delete employee profile
  public void removeFinanceProfile() {
    if (this.financeOfficerProfile == null) {
      throw new IntelInfoDomainException("Finance Profile does not exist");
    }
    this.financeOfficerProfile = null;
  }

  // reason register method
  private void checkDeclineReasonIsQualifiedToBeRegistered() {
    if (intelStatus != IntelStatus.DECLINED ) {
      throw new IntelInfoDomainException("IntelInfo is not in the correct state to register a decline reason");
    }
  }





  // reason register method
  public void registerReason(){
    initializeEmployeeProfile();
    checkDeclineReasonIsQualifiedToBeRegistered();

    employeeProfile = new EmployeeProfile(
            employeeProfile.getDeclineReason()
    );

  }

// check complain is qualified to be accepted
public void initializeComplaint() {
  initializeInformantProfile();
  UUID newId = UUID.randomUUID();
  if(complaint != null){
    complaint.setId(new ComplainId(newId));
  }
  if (intelStatus != IntelStatus.DECLINED) {
    throw new IntelInfoDomainException(
            "Complaint cannot be initialized because the associated IntelInfo is not in the Declined state"
    );
  }
}

  public void validateComplaint() {
    validateInitialComplaint();
  }

  private void validateInitialComplaint() {
    if (complaint.getId() != null) {
      throw new IntelInfoDomainException(
              "Complaint is not in correct state for initialization!"
      );
    }
  }
  private static final Duration ACCEPTANCE_TIME = Duration.ofDays(7);
  private void checkIfCompliantIsQualifiedTobeAccepted() {
    ZonedDateTime currentDateTime = ZonedDateTime.now();
    Duration elapsedTime = Duration.between(complaint.getReportedAt(), currentDateTime);

    // Check if complaint status is ACCEPTED and if the elapsed time is within the acceptance window
    if (complaint.getComplainStatus() != ComplainStatus.ACCEPTED && elapsedTime.compareTo(ACCEPTANCE_TIME) > 0) {
      throw new IntelInfoDomainException(
              "Complaint is not in correct state for Acceptance or the acceptance window has passed."
      );

 }
    // initialize to accepted complain
    complaint = new Complaint
            (complaint.getId(),
                    ComplainStatus.ACCEPTED);


    // Reinitialize the IntelInfo if the Complaint is accepted
    if (complaint.getComplainStatus() == ComplainStatus.ACCEPTED) {
      if (intelStatus != IntelStatus.RE_INITIALIZED) {
        reInitializedIntelInfo();
      } else {
        throw new IntelInfoDomainException("IntelInfo has already been re-initialized.");
      }
    }

  }
// re-initialize intel-info method
  private void checkIfIntelInfoIsQualifiedTobeReinitialized(){
    if(intelStatus!= IntelStatus.DECLINED || employeeProfile.getDeclineReason() == null){
      throw new IntelInfoDomainException(
              "Intel Info is not in correct state for Re-Initialization"
      );
    }
  }
  public void reInitializedIntelInfo(){
    checkIfIntelInfoIsQualifiedTobeReinitialized();
    intelStatus = IntelStatus.RE_INITIALIZED;
  }



  public void acceptCompliant(){
    initializeComplaint();
    validateComplaint();
    checkIfCompliantIsQualifiedTobeAccepted();
    reInitializedIntelInfo();
  }



// check operation is qualified to be successfully completed

  public void initializeOperation(){
    initializeInformantProfile();
    initializeIntelInfo();
    reInitializedIntelInfo();
    setId(new IntelInfoId(UUID.randomUUID()));
    if(operation != null){
      operation.setId(new OperationId(UUID.randomUUID()));
    }
    if (intelStatus != IntelStatus.INITIALIZED && intelStatus != IntelStatus.RE_INITIALIZED) {
      throw new IntelInfoDomainException(
                "Operation cannot be initialized because the associated IntelInfo is not in the INITIALIZED state or RE-INITIALIZED state"
      );
    }
    validateOperation();
  }

  private void validateOperation(){
    if (operation.getId() != null){
      throw new IntelInfoDomainException(
              "Operation  is not in correct state for initialization"
      );
    }
  }
  private void checkOperationIsSuccessful(){
    if(operation.getOperationStatus() != OperationStatus.COMPLETED || operation.getOperationResult() != OperationResult.SUCCESSFUL)
      throw new IntelInfoDomainException("operation is not in correct state to be completed");

  }
  // check operation is successful
  public void successfulOperation(){
    validateOperation();
    initializeOperation();
    checkOperationIsSuccessful();
    // Here we create a new Operation object with the successful state and replace the existing one
    operation = new Operation(
            operation.getId(),
            OperationStatus.COMPLETED,
            OperationResult.SUCCESSFUL
    );
  }




  // send operation result message method
  public void sendOperationResultToInformantAndHigherOfficials() {
    if (intelStatus != IntelStatus.INITIALIZED ||operation.getOperationStatus() != OperationStatus.COMPLETED || operation.getOperationResult() != OperationResult.UNSUCCESSFUL) {
      throw new IntelInfoDomainException("Operation must be completed and the result must be Unsuccessful.");
    }
  }
  public void sendUnsuccessfulOperationResultMessage(){
    sendOperationResultToInformantAndHigherOfficials();
    //
    operation = new Operation(
            operation.getId(),
            OperationStatus.COMPLETED,
            OperationResult.UNSUCCESSFUL
    );


  }

  private static final Duration CANCELLATION_WINDOW = Duration.ofDays(30);


  // check operation is passed the given time to be completed if its passed cancel the operation
  private void checkOperationTimeForCancellation() {
    ZonedDateTime currentDateTime = ZonedDateTime.now();
    Duration elapsedTime = Duration.between(operation.getTakePlaceAt(), currentDateTime);
    if (operation.getOperationStatus()!= OperationStatus.COMPLETED && elapsedTime.compareTo(CANCELLATION_WINDOW) > 0) {
      throw new IntelInfoDomainException("Operation must be completed within one month");
    }
  }

  public void cancelOperationDueToTime() {
    checkOperationTimeForCancellation();

  }
// initialize payment
public void initializePayment(){
  initializeInformantProfile();
  initializeIntelInfo();
  reInitializedIntelInfo();
  successfulOperation();
  // initialize payment
  payment = new Payment(
         payment.getId(),
          PaymentStatus.INITIALIZED
  );

  setId(new IntelInfoId(UUID.randomUUID()));
  if(payment != null){
    payment.setId(new PaymentId(UUID.randomUUID()));
  }
  if (intelStatus != IntelStatus.INITIALIZED && intelStatus != IntelStatus.RE_INITIALIZED) {
    throw new IntelInfoDomainException(
            "Payment cannot be initialized because the associated IntelInfo is not in the INITIALIZED state or RE-INITIALIZED state"
    );
  }
  validatePayment();
}

  private void validatePayment(){
    if (payment.getId() != null){
      throw new IntelInfoDomainException(
              "Payment  is not in correct state for initialization"
      );
    }

  }
// calculate tax for the payment
// VAT rate
private static final BigDecimal VAT_RATE = new BigDecimal("0.15");
  // Calculate tax amount based on item price
  public BigDecimal calculateTax() {
    validatePayment();
    if (payment.getItemPrice() == null) {
      throw new IntelInfoDomainException("Item price must be provided to calculate tax.");
    }
    // Calculate tax amount
    BigDecimal taxedAmount = payment.getItemPrice().multiply(VAT_RATE);

    // Round to 2 decimal places
    taxedAmount =  taxedAmount.setScale(2, RoundingMode.HALF_UP);

    return taxedAmount;
}


// make the allowed payment method
public BigDecimal makeAllowedPayment(){


    if (payment.getAllowedPayment() == null) {
        throw new IntelInfoDomainException("Allowed Payment must be provided to proceed with the payment.");
    }
  if (informantProfile.getBankName() == null) {
    throw new IntelInfoDomainException("Informant bank information must be provided.");
  }
  if (informantProfile.getAccountNumber() == null) {
    throw new IntelInfoDomainException("Informant bank information must be provided.");
  }

  BigDecimal taxedAmount = calculateTax(); // Get the taxed amount
  // Calculate the allowed payment as 20% of the taxed amount
  BigDecimal allowedPayment = taxedAmount.multiply(new BigDecimal("0.20"));
  Payment newAllowedPayment = new Payment(payment.getId(), allowedPayment);

  return allowedPayment;

}


  public void validateAllowedPayment(){
    makeAllowedPayment();
  }


  //Approve Payment
public void makeAllowanceDecision(){
  if (payment.getPaymentDecision() != PaymentDecision.APPROVED) {
    throw new IntelInfoDomainException("Payment must be approved before making an allowed payment.");
  }
  payment = new Payment(
          payment.getId(),
          PaymentDecision.APPROVED
  );
}

  public void validatePaymentDecision(){
    makeAllowanceDecision();
  }
//  register declined allowed payment reason
public void registerDeclinedPaymentReason(){
  BigDecimal allowedPayment = makeAllowedPayment();
  if (payment.getAllowedPayment() == null || allowedPayment == null) {
    throw new IntelInfoDomainException("Allowed Payment must be provided to Decline the Payment.");
  }
  if (informantProfile.getBankName() == null) {
    throw new IntelInfoDomainException("Informant bank information must be provided.");
  }
  if (informantProfile.getAccountNumber() == null) {
    throw new IntelInfoDomainException("Informant bank Account number must be provided.");
  }
  if (payment.getPaymentDecision() != PaymentDecision.DECLINED || financeOfficerProfile.getPaymentDeclineReason() == null) {
    throw new IntelInfoDomainException("Payment must be declined first and must have a decline reason.");
  }
  payment = new Payment(
          payment.getId(),
          PaymentDecision.DECLINED
  );
}

  public void validateDeclinedAllowedPayment(){
    registerDeclinedPaymentReason();

  }

// check deadline  for the informant to receive the payment
private static final Duration DEADLINE_WINDOW = Duration.ofDays(180);
public void checkDeadlineForInformantToReceivePayment() {
  BigDecimal allowedPayment = makeAllowedPayment();
  if (payment.getAllowedPayment() == null || allowedPayment == null || payment.getPaymentDecision() != PaymentDecision.APPROVED) {
    throw new IntelInfoDomainException("Allowed Payment must be provided to check the receiving payment.");
  }
  ZonedDateTime currentDateTime = ZonedDateTime.now();
  Duration elapsedTime = Duration.between(payment.getApprovedAt(), currentDateTime);

  if (elapsedTime.compareTo(DEADLINE_WINDOW) > 0) {
    // if the deadline window is passed Update payment status to expired
    payment = new Payment(
            payment.getId(),
            PaymentStatus.EXPIRED
    );
    throw new IntelInfoDomainException("Allowed Payment must be received within 6 months.");
  }
  else {
    //if the deadline window is not passed  Update payment status to paid
    payment = new Payment(
            payment.getId(),
            PaymentStatus.PAID
    );
  }

}
 public void validateReceivedPayment(){
   validateAllowedPayment();
   checkDeadlineForInformantToReceivePayment();
 }

 // attach receipt if the payment is done

  public void attachReceiptIfPaymentIsReceived() {
    if (payment.getPaymentDecision() != PaymentDecision.APPROVED || payment.getPaymentStatus() != PaymentStatus.PAID) {
      throw new IntelInfoDomainException("Payment Must be approved and Paid to attach Payment receipt");
    }
    if (payment.getPaymentReceipt() != null){
      throw new IntelInfoDomainException("payment with this receipt is already attached");
    }
    Payment  receipt= new Payment(
            payment.getId(),
            payment.getPaymentReceipt()
    );
  }

public void validateAttachReceipt(){
  validateReceivedPayment();
  attachReceiptIfPaymentIsReceived();
}

// ????? have a question
// check the reason is presented

  public void presentInformantReason(){
    if (payment.getPaymentDecision() == PaymentDecision.DECLINED && payment.getPaymentStatus() == PaymentStatus.EXPIRED){
      throw new IntelInfoDomainException("Payment Decision must be declined and the payment status must be expired");
    }
  }

  public void validateReasonPresented(){
    presentInformantReason();
  }


  // check is second deadline is passed or not
  private static final Duration SECOND_DEADLINE_WINDOW = Duration.ofDays(180);
  public void checkSecondDeadlineForInformantToReceivePayment() {
    BigDecimal allowedPayment = makeAllowedPayment();
    if (payment.getAllowedPayment() == null || allowedPayment == null || payment.getPaymentDecision() != PaymentDecision.APPROVED) {
      throw new IntelInfoDomainException("Allowed Payment must be provided to check the receiving payment.");
    }
    ZonedDateTime currentDateTime = ZonedDateTime.now();
    Duration elapsedTime = Duration.between(payment.getApprovedAt(), currentDateTime);

    if (elapsedTime.compareTo(SECOND_DEADLINE_WINDOW) > 0) {
      // if the deadline window is passed Update payment status to expired
      payment = new Payment(
              payment.getId(),
              PaymentStatus.EXPIRED
      );
      throw new IntelInfoDomainException("Allowed Payment must be received within 6 months.");
    } else {
      //if the deadline window is not passed  Update payment status to paid
      payment = new Payment(
              payment.getId(),
              PaymentStatus.PAID
      );
    }

  }

  public void validateSecondDeadlineReceivedPayment(){
    validateAllowedPayment();
    checkSecondDeadlineForInformantToReceivePayment();
  }

  // cancel the receiving payment if it is expired

  public void cancelReceivingPaymentIsExpired() {

    ZonedDateTime currentDateTime = ZonedDateTime.now();
    Duration elapsedTime = Duration.between(payment.getApprovedAt(), currentDateTime);

    if (elapsedTime.compareTo(SECOND_DEADLINE_WINDOW) > 0) {
      // if the deadline window is passed Update payment status to expired
      payment = new Payment(
              payment.getId(),
              PaymentStatus.EXPIRED
      );
      throw new IntelInfoDomainException("Allowed Payment must be received within 6 months.");
    }
  }

  public void validateReceivingPaymentExpiration(){
    cancelReceivingPaymentIsExpired();
  }






  private String generateReferenceNumber(){
    String number = "0123456789";
    Random rand = new Random();
    StringBuilder res = new StringBuilder();
    for (int i = 0; i < 8; i++) {
      int randIndex  = rand.nextInt(number.length());
      res.append(number.charAt(randIndex));
    }
    return res.toString();
  }

  // employee profile method























  public String getReferenceNumber() {
    return referenceNumber;
  }

  public EmployeeProfile getEmployeeProfile() {
    return employeeProfile;
  }

  public InformantProfile getInformantProfile() {
    return informantProfile;
  }

  public FinanceOfficerProfile getFinanceOfficerProfile() {
    return financeOfficerProfile;
  }

  public InformedWay getInformedWay() {
    return informedWay;
  }

  public Operation getOperation() {
    return operation;
  }

  public Payment getPayment() {
    return payment;
  }

  public Complaint getComplaint() {
    return complaint;
  }

  public IntelStatus getIntelStatus() {
    return intelStatus;
  }

  public IntelDescription getIntelDescription() {
    return intelDescription;
  }

  public Address getAddress() {
    return address;
  }

  public Contact getContact() {
    return contact;
  }

  public ZonedDateTime getCreatedAt() {
    return createdAt;
  }

  public  static Builder builder(){
    return new Builder();
  }
  public  static final class Builder{
    private IntelInfoId intelInfoId;
    private String referenceNumber;
    private EmployeeProfile employeeProfile;
    private InformantProfile informantProfile;

    private FinanceOfficerProfile financeOfficerProfile;
    private InformedWay informedWay;

    private Operation operation;

    private Payment payment;

    private Complaint complaint;
    private IntelStatus intelStatus;
    private IntelDescription intelDescription;
    private ZonedDateTime createdAt;
    private Address address;

    private Contact contact;

    private Builder() {
    }
    public Builder intelInfoId(IntelInfoId intelInfoId) {
      this.intelInfoId = intelInfoId;
        return this;
    }

    public Builder setReferenceNumber(String referenceNumber){
      this.referenceNumber = referenceNumber;
      return  this;
    }

    public Builder setFinanceOfficerProfile(FinanceOfficerProfile financeOfficerProfile) {
      this.financeOfficerProfile = financeOfficerProfile;
      return this;
    }
    public Builder setEmployeeProfile(EmployeeProfile employeeProfile) {
      this.employeeProfile = employeeProfile;
      return this;
    }

    public Builder setInformantProfile(InformantProfile informantProfile){
      this.informantProfile = informantProfile;
      return  this;
    }
    public Builder setInformedWay(InformedWay informedWay){
      this.informedWay = informedWay;
      return  this;
    }
    public Builder setOperation(Operation operation){
      this.operation = operation;
      return  this;
    }

    public Builder setPayment(Payment payment) {
      this.payment = payment;
      return this;
    }

    public Builder setComplaint(Complaint complaint) {
      this.complaint = complaint;
      return this;
    }

    public Builder setIntelStatus(IntelStatus intelStatus){
      this.intelStatus = intelStatus;
      return  this;
    }
    public Builder setIntelDescription(IntelDescription intelDescription){
      this.intelDescription = intelDescription;
      return  this;
    }

      public Builder setAddress(Address address) {
          this.address = address;
          return this;
      }

    public Builder setContact(Contact contact) {
      this.contact = contact;
      return this;
    }

      public Builder setCreatedAt(ZonedDateTime createdAt){
      this.createdAt = createdAt;
      return  this;
    }
    public IntelInfo build(){
      return new IntelInfo(this);
    }

  }

}
