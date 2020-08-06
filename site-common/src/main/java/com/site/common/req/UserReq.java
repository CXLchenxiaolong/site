package com.site.common.req;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Description:
 * @Author: CXL
 * @Date: 2020/8/4 9:11 下午
 */
@Data
public class UserReq {

    @NotNull(message = "pwd不能为空")
    private String pwd;

    @NotNull(message = "name不能为空")
    private String name;
}
