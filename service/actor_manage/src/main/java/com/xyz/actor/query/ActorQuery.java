package com.xyz.actor.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author Xyz
 * @Date 2021/6/27
 */

@ApiModel(value = "actor 查询对象", description = "演员查询对象封装")
@Data
public class ActorQuery implements Serializable {
    private static long serialVersionUID = 1L;

    @ApiModelProperty(value = "演员姓名")
    private String name;

    @ApiModelProperty(value = "演员等级")
    private Integer level;

    @ApiModelProperty(value = "查询开始时间" , example = "2010-01-01 10:10:10")
    private String begin;
}
