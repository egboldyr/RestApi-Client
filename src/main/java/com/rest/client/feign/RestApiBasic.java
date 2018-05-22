package com.rest.client.feign;

import com.rest.api.dto.SandboxDTO;
import com.rest.api.endpoint.SandboxEndpoint;
import com.rest.api.request.GeneralRequest;
import com.rest.api.request.sandbox.CreateSandboxParameters;
import com.rest.api.response.GeneralResponse;
import com.rest.client.config.FeignClientsConfig;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by EGBoldyr on 22.05.18.
 */

@FeignClient(
        value = "Basic-RestApi",
        url   = "http://localhost:15000",
        configuration = FeignClientsConfig.class
)
public interface RestApiBasic extends SandboxEndpoint {

    @RequestMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
    GeneralResponse<List<SandboxDTO>> testGetAllMethod();

    @RequestMapping(value = "/get", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
    GeneralResponse<SandboxDTO> testGetMethod(Long aLong);

    @RequestMapping(value = "/create", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
    GeneralResponse<Long> testPostMethod(GeneralRequest<CreateSandboxParameters> generalRequest);

}
