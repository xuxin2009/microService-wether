package com.sean.weather.vo;

import lombok.Data;

import javax.xml.bind.annotation.*;

/**
 * Created by Administrator on 2019/6/12.
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Item {
    @XmlValue
    private String item;
}
