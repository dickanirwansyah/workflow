package co.id.bankmandiri.workflow.controller;

import co.id.bankmandiri.workflow.dto.WorkflowRequest;
import co.id.bankmandiri.workflow.dto.WorkflowResponse;
import co.id.bankmandiri.workflow.service.WorkflowService;
import co.id.bankmandiri.workflow.util.ResponseApi;
import co.id.bankmandiri.workflow.util.SecureController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/workflow")
public class WorkflowController extends SecureController {

    @Autowired
    private WorkflowService workflowService;

    @GetMapping("/all-cookies")
    public String readAllCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            return Arrays.stream(cookies)
                    .map(c -> c.getName() + "=" + c.getValue()).collect(Collectors.joining(", "));
        }
        return "No cookies";
    }

    @GetMapping(value = "/secure")
    public ResponseApi getSecure(HttpServletRequest httpServletRequest){
        String hallo = "hallo";
        boolean checkCookies = checkCookie(httpServletRequest);
        if (checkCookies == true){
            return ResponseApi.success(hallo);
        }
        return ResponseApi.authError();
    }

    @GetMapping
    public ResponseApi hello(@RequestParam("nama")String nama,
                             HttpServletResponse servletResponse){

        //create token and replace it cookie
        Cookie cookie = new Cookie("token", UUID.randomUUID().toString());
        cookie.setMaxAge(7 * 24 * 60 * 60); // 7 days expired
        cookie.setPath("/"); //global cookies

        servletResponse.addCookie(cookie);
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
