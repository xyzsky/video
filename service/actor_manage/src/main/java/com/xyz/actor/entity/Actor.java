package com.xyz.actor.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author testjava
 * @since 2021-06-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Actor对象", description="")
public class Actor implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "演员id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "演员姓名")
    private String name;

    @ApiModelProperty(value = "演员简介")
    private String intro;

    @ApiModelProperty(value = "演员资历，一句话说明演员")
    private String career;

    @ApiModelProperty(value = "头衔,演员类型，歌手，配音")
    private Integer level;

    @ApiModelProperty(value = "头像")
    private String avatar;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @TableLogic
    @ApiModelProperty(value = "逻辑删除")
    private Boolean isDeleted;

    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;


}
