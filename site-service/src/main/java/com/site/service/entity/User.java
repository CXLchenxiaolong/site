package com.site.service.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author cxl
 * @since 2020-08-04
 */
@Data
public class User extends Model<User> {


    private Integer id;

    private String pwd;

    private String name;

}
