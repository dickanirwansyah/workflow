package co.id.bankmandiri.workflow.service;

import co.id.bankmandiri.workflow.dto.WorkflowRequest;
import co.id.bankmandiri.workflow.dto.WorkflowResponse;

public interface WorkflowService {

    WorkflowResponse saveWorkflow(WorkflowRequest workflowRequest);

}
