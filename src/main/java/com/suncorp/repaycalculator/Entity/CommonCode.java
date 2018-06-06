package com.suncorp.repaycalculator.Entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Divya
 * @description Entity class for the common codes table
 */
@Entity
@Table(name = "CODEMAP")
public class CommonCode implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Long id;
    @Column(name="CODE_TYPE")
    private String codeType;
    @Column(name="CODE")
    private String code;
    @Column(name="CODE_DESC")
    private String codeDesc;

    public CommonCode(){

    }

    public CommonCode(Long id, String codeType, String code, String codeDesc){
        super();
        this.id=id;
        this.codeType=codeType;
        this.code=code;
        this.codeDesc=codeDesc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }

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
