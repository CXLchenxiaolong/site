package com.site.common.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Description:
 * @Author: CXL
 * @Date: 2020/8/4 9:11 下午
 */
@Data
public class UserReq {

    @ApiModelProperty(value="密码",example="test")
    @NotNull(message = "pwd不能为空")
    private String pwd;

    @ApiModelProperty(value="名字",example="test")
    @NotNull(message = "name不能为空")
    private String name;
}
