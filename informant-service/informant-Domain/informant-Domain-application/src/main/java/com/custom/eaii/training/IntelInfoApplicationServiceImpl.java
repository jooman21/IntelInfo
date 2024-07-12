package com.custom.eaii.training;

import com.custom.eaii.training.DTO.Create.*;
import com.custom.eaii.training.DTO.search.SearchComplaintResponse;
import com.custom.eaii.training.DTO.search.SearchIntelInfoResponse;
import com.custom.eaii.training.DTO.search.SearchOperationResponse;
import com.custom.eaii.training.DTO.search.SearchPaymentResponse;
import com.custom.eaii.training.ports.input.service.IntelInfoApplicationService;
import com.custom.eaii.training.valueObjcet.*;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class IntelInfoApplicationServiceImpl implements IntelInfoApplicationService {

private final RegisterIntelInfoCommandHandler registerIntelInfoCommandHandler;

private final AcceptIntelInfoCommandHandler acceptIntelInfoCommandHandler;

private final DeclineIntelInfoCommandHandler declineIntelInfoCommandHandler;

private final RegisterReasonCommandHandler registerReasonCommandHandler;
private final SendMessageCommandHandler sendMessageCommandHandler;

private final ReInitializeIntelInfoCommandHandler reInitializeIntelInfoCommandHandler;

private final AcceptComplainCommandHandler acceptComplainCommandHandler;

private final RegisterOperationResultCommandHandler registerOperationResultCommandHandler;
 private final SendUnsuccessfulOperationResultMessageCommandHandler sendUnsuccessfulOperationResultMessageCommandHandler;
 private final CalculateTaxCommandHandler calculateTaxCommandHandler;
 private final CalculateAllowanceCommandHandler calculateAllowanceCommandHandler;
 private final MakeAllowedPaymentDecisionCommandHandler makeAllowedPaymentDecisionCommandHandler;

 private final DeclinePaymentCommandHandler declinePaymentCommandHandler;

 private final CheckDeadlineCommandHandler checkDeadlineCommandHandler;
 private final CheckSecondDeadlineCommandHandler checkSecondDeadlineCommandHandler;

 private final CancelPaymentCommandHandler cancelPaymentCommandHandler;

 private final CreateAddressCommandHandler createAddressCommandHandler;

 private final CreateContactCommandHandler createContactCommandHandler;

    private final CreateFinanceOfficerCommandHandler createFinanceOfficerCommandHandler;
    private final   CreateEmployeeCommandHandler createEmployeeCommandHandler;
    private final UpdateEmployeeCommandHandler updateEmployeeCommandHandler;
    private final UpdateFinanceOfficerProfileCommandHandler updateFinanceOfficerProfileCommandHandler;
    private final UpdateContactCommandHandler updateContactCommandHandler;
      private final UpdateAddressCommandHandler updateAddressCommandHandler;

 private final PresentReasonCommandHandler presentReasonCommandHandler;

 private final SearchOperationCommandHandler searchOperationCommandHandler;

 private final SearchComplaintCommandHandler searchComplaintCommandHandler;

 private final SearchPaymentCommandHandler searchPaymentCommandHandler;





 private final SearchIntelInfoCommandHandler searchIntelInfoCommandHandler;


    public IntelInfoApplicationServiceImpl(RegisterIntelInfoCommandHandler registerIntelInfoCommandHandler , AcceptIntelInfoCommandHandler acceptIntelInfoCommandHandler, DeclineIntelInfoCommandHandler declineIntelInfoCommandHandler, RegisterReasonCommandHandler registerReasonCommandHandler, SendMessageCommandHandler sendMessageCommandHandler, ReInitializeIntelInfoCommandHandler reInitializeIntelInfoCommandHandler, AcceptComplainCommandHandler acceptComplainCommandHandler, RegisterOperationResultCommandHandler registerOperationResultCommandHandler, SendUnsuccessfulOperationResultMessageCommandHandler sendUnsuccessfulOperationResultMessageCommandHandler, CalculateTaxCommandHandler calculateTaxCommandHandler, CalculateAllowanceCommandHandler calculateAllowanceCommandHandler, MakeAllowedPaymentDecisionCommandHandler makeAllowedPaymentDecisionCommandHandler, DeclinePaymentCommandHandler declinePaymentCommandHandler, CheckDeadlineCommandHandler checkDeadlineCommandHandler, CheckSecondDeadlineCommandHandler checkSecondDeadlineCommandHandler, CancelPaymentCommandHandler cancelPaymentCommandHandler, CreateAddressCommandHandler createAddressCommandHandler, CreateContactCommandHandler createContactCommandHandler, CreateFinanceOfficerCommandHandler createFinanceOfficerCommandHandler, CreateEmployeeCommandHandler createEmployeeCommandHandler, UpdateEmployeeCommandHandler updateEmployeeCommandHandler, UpdateFinanceOfficerProfileCommandHandler updateFinanceOfficerProfileCommandHandler, UpdateContactCommandHandler updateContactCommandHandler, UpdateAddressCommandHandler updateAddressCommandHandler, PresentReasonCommandHandler presentReasonCommandHandler, SearchOperationCommandHandler searchOperationCommandHandler, SearchComplaintCommandHandler searchComplaintCommandHandler, SearchPaymentCommandHandler searchPaymentCommandHandler, SearchIntelInfoCommandHandler searchIntelInfoCommandHandler) {
        this.registerIntelInfoCommandHandler = registerIntelInfoCommandHandler;
        this.acceptIntelInfoCommandHandler = acceptIntelInfoCommandHandler;
        this.declineIntelInfoCommandHandler = declineIntelInfoCommandHandler;
        this.registerReasonCommandHandler = registerReasonCommandHandler;
        this.sendMessageCommandHandler = sendMessageCommandHandler;
        this.reInitializeIntelInfoCommandHandler = reInitializeIntelInfoCommandHandler;
        this.acceptComplainCommandHandler = acceptComplainCommandHandler;
        this.registerOperationResultCommandHandler = registerOperationResultCommandHandler;
        this.sendUnsuccessfulOperationResultMessageCommandHandler = sendUnsuccessfulOperationResultMessageCommandHandler;
        this.calculateTaxCommandHandler = calculateTaxCommandHandler;
        this.calculateAllowanceCommandHandler = calculateAllowanceCommandHandler;
        this.makeAllowedPaymentDecisionCommandHandler = makeAllowedPaymentDecisionCommandHandler;
        this.declinePaymentCommandHandler = declinePaymentCommandHandler;
        this.checkDeadlineCommandHandler = checkDeadlineCommandHandler;
        this.checkSecondDeadlineCommandHandler = checkSecondDeadlineCommandHandler;
        this.cancelPaymentCommandHandler = cancelPaymentCommandHandler;
        this.createAddressCommandHandler = createAddressCommandHandler;
        this.createContactCommandHandler = createContactCommandHandler;
        this.createFinanceOfficerCommandHandler = createFinanceOfficerCommandHandler;
        this.createEmployeeCommandHandler = createEmployeeCommandHandler;
        this.updateEmployeeCommandHandler = updateEmployeeCommandHandler;
        this.updateFinanceOfficerProfileCommandHandler = updateFinanceOfficerProfileCommandHandler;
        this.updateContactCommandHandler = updateContactCommandHandler;
        this.updateAddressCommandHandler = updateAddressCommandHandler;
        this.presentReasonCommandHandler = presentReasonCommandHandler;
        this.searchOperationCommandHandler = searchOperationCommandHandler;
        this.searchComplaintCommandHandler = searchComplaintCommandHandler;
        this.searchPaymentCommandHandler = searchPaymentCommandHandler;
        this.searchIntelInfoCommandHandler = searchIntelInfoCommandHandler;

    }

    @Override
    public CreateIntelInfoResponse CreateIntelInfo(RegisterIntelInfoCommand registerIntelInfoCommand) {
        return registerIntelInfoCommandHandler.handleCreateIntelInfo(registerIntelInfoCommand);
    }





    @Override
    public MakeDecisionResponse acceptIntelInfo(MakeDecisionCommand makeDecisionCommand) {
        return acceptIntelInfoCommandHandler.acceptIntelInfo(makeDecisionCommand);
    }

    @Override
    public ReInitializeIntelInfoResponse re_InitializedIntelInfo(MakeDecisionCommand re_InitializedIntelInfoCommand) {
        return reInitializeIntelInfoCommandHandler.re_InitializedIntelInfo(re_InitializedIntelInfoCommand);
    }



    @Override
    public DeclineIntelInfoResponse declineIntelInfo(MakeDecisionCommand declineIntelInfoCommand) {
        return declineIntelInfoCommandHandler.declineIntelInfo(declineIntelInfoCommand);
    }

    @Override
    public ReasonRegisterResponse RegisterReason(ReasonRegisterCommand reasonRegisterCommand) {
        return registerReasonCommandHandler.registerReason(reasonRegisterCommand);
    }
    @Override
    public SendMessageResponse checkMessageSent(SendMessageCommand sendMessageCommand) {
        return sendMessageCommandHandler.checkMessageSent(sendMessageCommand);
    }

    @Override
    public CreateComplainResponse saveAcceptedComplaint(PresentComplaintCommand presentComplaintCommand) {
        return acceptComplainCommandHandler.saveAcceptedComplaint(presentComplaintCommand);
    }


    @Override
    public RegisterOperationResultResponse SaveOperationResult(RegisterOperationResultCommand command) {
        return registerOperationResultCommandHandler.SaveOperationResult(command);
    }
    @Override
    public SendUnsuccessfulOperationResultMessageResponse SendUnsuccessfulOperationResultMessage(SendMessageCommand command) {
        return sendUnsuccessfulOperationResultMessageCommandHandler.SendUnsuccessfulOperationResultMessage(command);
    }
    @Override
    public CalculateTaxResponse TaxIsCalculated(CalculateTaxCommand command) {
        return calculateTaxCommandHandler.TaxIsCalculated(command);
    }

    @Override
    public CalculateAllowanceResponse AllowancePaymentIsCalculated(CalculateAllowanceCommand command) {
        return calculateAllowanceCommandHandler.AllowancePaymentIsCalculated(command);
    }

    @Override
    public MakeAllowedPaymentDecisionResponse savePaymentDecision(MakeAllowedPaymentDecisionCommand command) {
        return makeAllowedPaymentDecisionCommandHandler.savePaymentDecision(command);
    }

    @Override
    public RegisterCauseResponse saveDeclinedPayment(RegisterCauseCommand command) {
        return declinePaymentCommandHandler.saveDeclinedPayment(command);
    }
    @Override
    public AskPaymentDeadlineResponse checkPaymentDeadline(AskPaymentDeadlineCommand command) {
        return checkDeadlineCommandHandler.checkPaymentDeadline(command);
    }

    @Override
    public PresentReasonResponse savePresentedReason(PresentReasonCommand command) {
        return presentReasonCommandHandler.savePresentedReason(command);
    }

    @Override
    public AskPaymentDeadlineResponse checkSecondPaymentDeadline(AskPaymentDeadlineCommand command) {
        return checkSecondDeadlineCommandHandler.checkSecondPaymentDeadline(command);
    }


    @Override
    public CancelPaymentResponse saveCanceledPayment(CancelPaymentCommand command) {
        return cancelPaymentCommandHandler.saveCanceledPayment(command);
    }
    @Override
    public CreateAddressResponse createAddress(CreateAddressCommand command) {
        return createAddressCommandHandler.createAddress(command);
    }

    @Override
    public CreateEmployeeResponse createEmployee(CreateEmployeeCommand command) {
        return createEmployeeCommandHandler.createEmployee(command);
    }

    @Override
    public CreateEmployeeResponse updateEmployeeProfile(CreateEmployeeCommand command) {
        return updateEmployeeCommandHandler.updateEmployeeProfile(command);
    }
    @Override
    public CreateFinanceOfficerResponse updateFinanceProfile(CreateFinanceOfficerCommand command) {
        return updateFinanceOfficerProfileCommandHandler.updateFinanceProfile(command);
    }

    @Override
    public CreateFinanceOfficerResponse createFinanceProfile(CreateFinanceOfficerCommand command) {
        return createFinanceOfficerCommandHandler.createFinanceProfile(command);
    }
    @Override
    public CreateContactResponse updateContact(CreateContactCommand command) {
        return updateContactCommandHandler.updateContact(command);
    }

    @Override
    public CreateAddressResponse updateAddress(CreateAddressCommand command) {
        return updateAddressCommandHandler.updateAddress(command);
    }

    @Override
    public CreateContactResponse createContact(CreateContactCommand command) {
        return createContactCommandHandler.createContact(command);
    }
    @Override
    public SearchIntelInfoResponse searchIntelInfos() {
        return searchIntelInfoCommandHandler.searchIntelInfo();
    }

    @Override
    public SearchIntelInfoResponse searchByIntelId(UUID intelInfoId) {
        return searchIntelInfoCommandHandler.searchByIntelId(intelInfoId);
    }
    @Override
    public SearchIntelInfoResponse searchByStatus(IntelStatus status) {
        return searchIntelInfoCommandHandler.searchByStatus(status);
    }



    @Override
    public SearchComplaintResponse searchComplaint() {
        return searchComplaintCommandHandler.searchComplaint();
    }
    @Override
    public SearchComplaintResponse searchByStatus(ComplainStatus status) {
        return searchComplaintCommandHandler.searchByStatus(status);
    }

    @Override
    public SearchComplaintResponse searchByComplaintId(UUID complainId) {
        return searchComplaintCommandHandler.searchByComplaintId(complainId);
    }
    @Override
    public SearchOperationResponse searchOperations() {
        return searchOperationCommandHandler.searchOperation();
    }
    @Override
    public SearchOperationResponse searchByOperationId(UUID operationId) {
        return searchOperationCommandHandler.searchByOperationId(operationId);
    }
    @Override
    public SearchOperationResponse searchByStatus(OperationStatus status) {
        return searchOperationCommandHandler.searchByStatus(status);
    }


    @Override
    public SearchPaymentResponse searchPayment() {
        return searchPaymentCommandHandler.searchPayment();
    }

    @Override
    public SearchPaymentResponse searchByPaymentId(UUID paymentId) {
        return searchPaymentCommandHandler.searchByPaymentId(paymentId);
    }
    @Override
    public SearchPaymentResponse searchByStatus(PaymentStatus status) {
        return searchPaymentCommandHandler.searchByStatus(status);
    }
    @Override
    public SearchPaymentResponse searchByDecision(PaymentDecision decision) {
        return searchPaymentCommandHandler.searchByDecision(decision);
    }

}
