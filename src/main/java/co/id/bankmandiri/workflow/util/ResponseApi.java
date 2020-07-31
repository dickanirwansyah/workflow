package co.id.bankmandiri.workflow.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseApi {

    private int code;
    private String message;
    private Object data;

    public static ResponseApi success(Object data){
        return new ResponseApi(200, "success", data);
    }

    public static ResponseApi error(String message){
        return new ResponseApi(200, message, null);
    }
}
