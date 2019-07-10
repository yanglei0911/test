package com.neuedu.his.common.bean;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class BaseBean {
    private String id;
    private Date updateTime;
    private String delFlag;

    /**
     * 再插入之前的准备工作
     */
    public void preInsert(){
        //1、生成id    2、给updateTime赋值
        this.id = UUID.randomUUID().toString().replaceAll("-","");

        this.updateTime = new Date();
    }

    /**
     * 在更新之前的准备工作
     */
    public  void preUpdate(){
        //1、给updateTime赋值
        this.updateTime = new Date();
    }
}
