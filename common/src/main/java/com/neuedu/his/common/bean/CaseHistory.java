package com.neuedu.his.common.bean;

import java.util.Date;

/**
 * 病例实体类
 */
public class CaseHistory extends BaseBean {
    private String patientName;
    private String gender;
    private Integer age;
    private Date birthday;
    private String identityCard;
    private String homeAddress;
    private Date attendTime;

    private Department department;  //看诊科室
    private Employee doctor;    //就诊医生
}
