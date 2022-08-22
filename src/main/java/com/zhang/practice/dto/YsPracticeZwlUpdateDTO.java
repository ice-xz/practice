package com.zhang.practice.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.sql.Date;

/**
 * @Author: zhangwenliang
 * @createTime: 2022年07月14日 14:05:45
 * @version:
 * @Description: YsPracticeZwlUpdateDTO类
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class YsPracticeZwlUpdateDTO {

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


    @Pattern(regexp = "^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}$",message = "手机号码有误！")
    @ApiModelProperty(value = "手机号")
    private String tel;
}
