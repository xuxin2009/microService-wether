package com.sean.weather.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/6/9.
 */
@Data
public class WeatherId implements Serializable{
    private int fa;/*天气标识：霾 如果fa不等于fb，说明是组合天气*/
    private int fb;
}
