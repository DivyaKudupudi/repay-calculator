package com.suncorp.repaycalculator.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.suncorp.repaycalculator.dto.CommonCodeMapBean;
import com.suncorp.repaycalculator.request.RepayCalcRequest;
import com.suncorp.repaycalculator.response.RepayCalcResponse;
import com.suncorp.repaycalculator.service.RepayCalService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RepayCalControllerTest {

    private MockMvc mvc;

    @InjectMocks
    private RepayCalController repayCalController;

    @Mock
    private RepayCalService repayCalService;

    String jsonCodeMapBeanOutput;

    @Before
    public void init() throws JsonProcessingException {
        mvc = MockMvcBuilders.standaloneSetup(repayCalController)
                .setMessageConverters(new MappingJackson2HttpMessageConverter()).build();
    }

    @Test
    public void test_calculateRepayment() throws  Exception{
        RepayCalcRequest repayCalcRequest = new RepayCalcRequest();
        ObjectWriter repayCalcRequestObj = new ObjectMapper().writer().withDefaultPrettyPrinter();
        doReturn(new RepayCalcResponse()).when(repayCalService).calculateRepayment(any());
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/api/repay/calculate")
                .content(repayCalcRequestObj.writeValueAsString(repayCalcRequest));
        RepayCalcResponse repayCalcResponse = new RepayCalcResponse();
        ObjectWriter repayCalcResponseObj = new ObjectMapper().writer().withDefaultPrettyPrinter();

        mvc.perform(builder).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().json(repayCalcResponseObj.writeValueAsString(repayCalcResponse)));
    }

    @Test
    public void test_getLoanPeriodDropDown() throws  Exception{
        doReturn(new ArrayList<CommonCodeMapBean>()).when(repayCalService).getLoanPeriodDropDown(anyString());
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/api/repay/loanPeriod");
        mvc.perform(builder).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }

    @Test
    public void test_getLoanTypeDropDown() throws Exception{

        doReturn(new ArrayList<CommonCodeMapBean>()).when(repayCalService).getLoanTypeDropDown(anyString());
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/api/repay/loanTypes");
        mvc.perform(builder).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }

    @Test
    public void test_getLoanPurposeDropDown() throws Exception{

        doReturn(new ArrayList<CommonCodeMapBean>()).when(repayCalService).getLoanPurposeDropDown(anyString());
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/api/repay/loanPurpose");
        mvc.perform(builder).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }
}
