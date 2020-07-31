package co.id.bankmandiri.workflow.controller;

import co.id.bankmandiri.workflow.dto.WorkflowRequest;
import co.id.bankmandiri.workflow.dto.WorkflowResponse;
import co.id.bankmandiri.workflow.service.WorkflowService;
import co.id.bankmandiri.workflow.util.ResponseApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/workflow")
public class WorkflowController {

    @Autowired
    private WorkflowService workflowService;

    @GetMapping
    public ResponseApi hello(@RequestParam("nama")String nama){
        return ResponseApi.success(nama);
    }

    @PostMapping(value = "/save-flow")
    public ResponseApi saveflow(@RequestBody WorkflowRequest workflowRequest){

        WorkflowResponse workflowResponse = new WorkflowResponse();
        workflowResponse = workflowService.saveWorkflow(workflowRequest);
        if (workflowResponse == null){
            return ResponseApi.error("error save work flow !");
        }
        return ResponseApi.success(workflowResponse);
    }
}
