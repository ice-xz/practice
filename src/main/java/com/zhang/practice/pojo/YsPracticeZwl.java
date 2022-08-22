package com.zhang.practice.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.sql.Date;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


/**
 * <p>
 * 实习表_张文亮
 * </p>
 *
 * @author zhangwenliang
 * @since 2022-07-13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("ys_practice_zwl")
@ApiModel(value="YsPracticeZwl对象", description="实习表_张文亮")
public class YsPracticeZwl implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "姓名")
    private String sname;

    @ApiModelProperty(value = "学号")
    private String sno;

    @ApiModelProperty(value = "学校")
    private String schoolName;

    @ApiModelProperty(value = "专业")
    private String major;

    @ApiModelProperty(value = "实习开始时间")
    private Date practiceStart;

    @ApiModelProperty(value = "实习结束时间")
    private Date practiceEnd;

    @ApiModelProperty(value = "是否毕业")
    private String graduation;

    @ApiModelProperty(value = "手机号")
    private String tel;


}
