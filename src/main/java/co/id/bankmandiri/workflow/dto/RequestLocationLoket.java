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
public class RequestLocationLoket implements Serializable {

    private String rsId;
    private String loketCode;
    private String loketName;

}
