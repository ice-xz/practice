package com.zhang.practice.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.sql.Date;


/**
 * @Author: zhangwenliang
 * @createTime: 2022年07月13日 11:15:40
 * @version:
 * @Description: YsPracticeZwlDTO类
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class YsPracticeZwlDTO {

    @NotEmpty(message = "姓名不能为空!")
    @ApiModelProperty(value = "姓名")
    private String sname;

    @NotEmpty(message = "学号不能为空")
    @ApiModelProperty(value = "学号")
    private String sno;

    @NotEmpty(message = "学校不能为空")
    @ApiModelProperty(value = "学校")
    private String schoolName;

    @NotEmpty(message = "专业不能为空")
    @ApiModelProperty(value = "专业")
    private String major;

    @NotNull(message = "实习开始时间不能为空")
    @ApiModelProperty(value = "实习开始时间")
    private Date practiceStart;

    @NotNull(message = "实习结束时间不能为空")
    @ApiModelProperty(value = "实习结束时间")
    private Date practiceEnd;

    @NotEmpty(message = "是否毕业不能为空")
    @ApiModelProperty(value = "是否毕业")
    private String graduation;

    @Pattern(regexp = "^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}$",message = "手机号码有误！")
    @ApiModelProperty(value = "手机号")
    private String tel;
}
