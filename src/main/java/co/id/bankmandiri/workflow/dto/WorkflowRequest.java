package co.id.bankmandiri.workflow.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WorkflowRequest implements Serializable {

    private String reqBill;
    private RequestBillPayment billPayment;
    private String reqDeposito;
    private RequestDeposito deposito;

}
