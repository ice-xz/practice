package com.zhang.practice.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

/**
 * @Author: zhangwenliang
 * @createTime: 2022年07月20日 08:52:23
 * @version:
 * @Description: 分页查询页码和页大小
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value="PageDTO", description="PageDTO对象")
public class PageDTO {


    @ApiModelProperty(value = "页码")
    @NotNull(message = "页码参数错误!")
    private Integer pageNumber;

    @ApiModelProperty(value = "页大小")
    @NotNull(message = "页大小参数错误!")
    private  Integer  pageSize;

    @ApiModelProperty(value = "专业")
    private String majorname;
}
