package com.suncorp.repaycalculator.service;

import com.suncorp.repaycalculator.dao.RepayCalcDao;
import com.suncorp.repaycalculator.dto.CommonCodeMapBean;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class RepayCalServiceImplTest {

    @Mock
    private RepayCalcDao repayCalcDao;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private RepayCalServiceImpl repayCalServiceImpl;

    List<CommonCodeMapBean> mapBeanList = null;

    @Before
    public void init() throws IOException {
        String jsonCodeMap = "{\n" +
                "        \"code\": \"01\",\n" +
                "        \"codeDesc\": \"5 years\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"code\": \"02\",\n" +
                "        \"codeDesc\": \"6 years\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"code\": \"03\",\n" +
                "        \"codeDesc\": \"10 years\"\n" +
                "    }\n";
        CommonCodeMapBean codeBean = new ObjectMapper().readValue(jsonCodeMap, CommonCodeMapBean.class);
        mapBeanList = new ArrayList();
        mapBeanList.add(codeBean);
    }

    @Test
    public void test_getLoanPeriodDropDown(){
        doReturn(new ArrayList()).when(repayCalcDao).getCommonCodes(anyString());
        mapBeanList = repayCalServiceImpl.getLoanPeriodDropDown("LOAN_PERIOD");
        assertTrue(mapBeanList != null);
    }

    @Test
    public void test_getLoanTypeDropDown(){
        doReturn(new ArrayList()).when(repayCalcDao).getCommonCodes(anyString());
        mapBeanList = repayCalServiceImpl.getLoanPeriodDropDown("LOAN_TYPE");
        assertTrue(mapBeanList != null);
    }

    @Test
    public void test_getLoanPurposeDropDown(){
        doReturn(new ArrayList()).when(repayCalcDao).getCommonCodes(anyString());
        mapBeanList = repayCalServiceImpl.getLoanPeriodDropDown("LOAN_PURPOSE");
        assertTrue(mapBeanList != null);
    }
}
