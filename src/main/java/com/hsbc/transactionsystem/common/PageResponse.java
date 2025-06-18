package com.hsbc.transactionsystem.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageResponse<T> {

    /**
     * 总数据大小
     */
    private Integer total;

    /**
     * 返回的数据
     */
    private List<T> data;

}
