package co.id.bankmandiri.workflow.service;

import co.id.bankmandiri.workflow.dto.RequestBillPayment;
import co.id.bankmandiri.workflow.dto.RequestDeposito;
import co.id.bankmandiri.workflow.dto.WorkflowRequest;
import co.id.bankmandiri.workflow.dto.WorkflowResponse;
import co.id.bankmandiri.workflow.entity.BillPaymentWhislist;
import co.id.bankmandiri.workflow.entity.DepositoWhislist;
import co.id.bankmandiri.workflow.repository.BillPaymentRepository;
import co.id.bankmandiri.workflow.repository.BillPaymentWhislistRepository;
import co.id.bankmandiri.workflow.repository.DepositoRepository;
import co.id.bankmandiri.workflow.repository.DepositoWhislistRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class WorkflowServiceImpl implements WorkflowService {

    private static final Logger log = LoggerFactory.getLogger(WorkflowServiceImpl.class);
    private static final String BILLPAYMENT = "billpayment";
    private static final String DEPOSITO = "deposito";

    @Autowired
    private DepositoRepository depositoRepository;

    @Autowired
    private DepositoWhislistRepository depositoWhislistRepository;

    @Autowired
    private BillPaymentRepository billPaymentRepository;

    @Autowired
    private BillPaymentWhislistRepository billPaymentWhislistRepository;

    @Override
    @Transactional
    public WorkflowResponse saveWorkflow(WorkflowRequest workflowRequest) {

        WorkflowResponse workflowResponse = new WorkflowResponse();

        //if bill payment
        if (workflowRequest.getReqBill().equals(BILLPAYMENT)){

            Optional<BillPaymentWhislist> currentBillPayment = billPaymentWhislistRepository.findById(workflowRequest.getBillPayment().getId());
            //if bill payment
            if (!currentBillPayment.isPresent()){
                //save
                BillPaymentWhislist newBillPaymentWhislist = new BillPaymentWhislist();
                BeanUtils.copyProperties(workflowRequest.getBillPayment(), newBillPaymentWhislist);
                newBillPaymentWhislist.setDeleted(false);
                BillPaymentWhislist responseSaveBillPayment = billPaymentWhislistRepository.save(newBillPaymentWhislist);
                if (responseSaveBillPayment == null){
                    if (log.isInfoEnabled()){
                        log.debug("{\"error\" : \"save bill payment failed !\"}");
                    }
                    return null;
                }
                RequestBillPayment requestBillPayment = new RequestBillPayment();
                BeanUtils.copyProperties(responseSaveBillPayment, requestBillPayment);
                workflowResponse.setBillPayment(requestBillPayment);
            }else{
                //update
                BeanUtils.copyProperties(workflowRequest.getBillPayment(), currentBillPayment.get());
                BillPaymentWhislist responseUpdateBillPayment = billPaymentWhislistRepository.save(currentBillPayment.get());
                if (responseUpdateBillPayment == null){
                    if (log.isInfoEnabled()){
                        log.debug("{\"error\" : \"update bill payment failed !\"}");
                    }
                    return null;
                }
                RequestBillPayment requestBillPayment = new RequestBillPayment();
                BeanUtils.copyProperties(responseUpdateBillPayment, requestBillPayment);
                workflowResponse.setBillPayment(requestBillPayment);
            }
        }

        //if deposito
        if (workflowRequest.getReqDeposito().equals(DEPOSITO)){

            Optional<DepositoWhislist> currentWhislist = depositoWhislistRepository.findById(workflowRequest.getDeposito().getId());

            if (!currentWhislist.isPresent()){
                //save
                DepositoWhislist newDeposito = new DepositoWhislist();
                BeanUtils.copyProperties(workflowRequest.getDeposito(), newDeposito);
                newDeposito.setDeleted(false);
                DepositoWhislist responseSaveDeposito = depositoWhislistRepository.save(newDeposito);
                if (responseSaveDeposito == null){
                    if (log.isInfoEnabled()){
                        log.debug("{\"error\" : \"failed save deposito !\"}");
                    }
                    return null;
                }
                RequestDeposito requestDeposito = new RequestDeposito();
                BeanUtils.copyProperties(responseSaveDeposito, requestDeposito);
                workflowResponse.setDeposito(requestDeposito);
            }else{
                //update
                BeanUtils.copyProperties(workflowRequest.getDeposito(), currentWhislist.get());
                DepositoWhislist responseUpdateDeposito = depositoWhislistRepository.save(currentWhislist.get());
                if (responseUpdateDeposito == null){
                    if (log.isInfoEnabled()){
                        log.debug("{\"error\" : \"failed update deposito !\"}");
                    }
                }
                RequestDeposito requestDeposito = new RequestDeposito();
                BeanUtils.copyProperties(responseUpdateDeposito, requestDeposito);
                workflowResponse.setDeposito(requestDeposito);
            }
        }

        if (workflowResponse.getBillPayment() != null){
            workflowResponse.setReqBill(BILLPAYMENT);
        }
        if (workflowResponse.getDeposito() != null){
            workflowResponse.setReqDeposito(DEPOSITO);
        }
        return workflowResponse;
    }
}
