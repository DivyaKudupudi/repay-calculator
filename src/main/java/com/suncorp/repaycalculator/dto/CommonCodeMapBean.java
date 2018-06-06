package com.suncorp.repaycalculator.dto;

import org.springframework.stereotype.Component;

/**
 * @author Divya
 */
@Component
public class CommonCodeMapBean {

    private String code;
    private String codeDesc;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeDesc() {
        return codeDesc;
    }

    public void setCodeDesc(String codeDesc) {
        this.codeDesc = codeDesc;
    }
}
