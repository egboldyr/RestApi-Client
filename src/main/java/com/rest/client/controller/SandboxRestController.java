package com.rest.client.controller;

import com.rest.api.dto.SandboxDTO;
import com.rest.api.request.GeneralRequest;
import com.rest.api.request.sandbox.CreateSandboxParameters;
import com.rest.client.feign.RestApiBasic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by EGBoldyr on 22.05.18.
 */

@RestController
public class SandboxRestController {

    @Autowired
    private RestApiBasic apiBasic;

    @RequestMapping(value = "/get", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
    public SandboxDTO getOneById(@RequestParam("id") Long id) {
        return apiBasic.testGetMethod(id).getPayload();
    }

    @RequestMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
    public List<SandboxDTO> getAll() {
        return apiBasic.testGetAllMethod().getPayload();
    }

    @RequestMapping(value = "/create", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
    public Long create(@RequestParam("title") String title, @RequestParam("count") Integer count) {
        GeneralRequest<CreateSandboxParameters> request = new GeneralRequest<CreateSandboxParameters>();
        CreateSandboxParameters parameters = new CreateSandboxParameters();
        parameters.setTitle(title);
        parameters.setCount(count);
        request.setParameters(parameters);
        return apiBasic.testPostMethod(request).getPayload();
    }
}
