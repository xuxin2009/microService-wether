package com.sean.weather.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/6/9.
 */
@Data
public class Result implements Serializable {

    private Sk sk;/*当前实况天气*/
    private  Today today;
    private List<Future> future;
}
