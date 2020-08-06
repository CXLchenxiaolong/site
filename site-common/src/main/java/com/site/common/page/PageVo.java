package com.site.common.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description:
 * @Author: CXL
 * @Date: 2020/8/6 12:55 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageVo<T> {

     private Long pageNo;
     private Long pageSize;
     private Long total;
     private List<T> dataList;
}
