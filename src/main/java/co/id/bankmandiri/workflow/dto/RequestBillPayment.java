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
public class RequestBillPayment implements Serializable {

    private Long id;
    private String description;
    private String rekBank;
    private String status;
    
}
