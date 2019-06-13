package com.sean.weather.vo;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by Administrator on 2019/6/12.
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "cities")
public class Cities {

    @XmlAttribute(name = "name")
    private String name;

    @XmlElement(name = "province")
    private List<Province> provinceList;

}
