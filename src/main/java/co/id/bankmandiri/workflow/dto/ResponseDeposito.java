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
public class ResponseDeposito implements Serializable {

    private Long id;
    private String description;
    private String rsId;
    private String rekNo;
    private String status;
}
