package com.sean.weather.vo;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by Administrator on 2019/6/12.
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "province")
public class Province {

    @XmlElement(name = "item")
    private List<Item> itemList;
}
