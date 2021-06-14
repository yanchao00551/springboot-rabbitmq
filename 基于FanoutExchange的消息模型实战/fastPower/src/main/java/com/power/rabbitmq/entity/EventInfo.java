package com.power.rabbitmq.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class EventInfo implements Serializable {
    private Integer id;              //id标识
    private String module;          //模块
    private String name;            //名称
    private String desc;            //描述

    //空的默认构造方法
    public EventInfo(){

    }
    //包含全部字段的构造方法
    public EventInfo(Integer id,String module,String name,String desc){
        this.id = id;
        this.module = module;
        this.name = name;
        this.desc = desc;
    }
}
