package com.dengqiao.codegenerator.utils;

import lombok.Data;

import java.util.List;

/**
 * @author dengqiao
 * @date 2019-09-17 09:50
 */
@Data
public class PageUtils {
    private int totalCount;
    private int pageSize;
    private int totalPage;
    private int currPage;
    private List<?> list;

    public PageUtils(List<?> list, int totalCount, int pageSize, int currPage) {
        this.list = list;
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.currPage = currPage;
        this.totalPage = ((int) Math.ceil(totalCount / pageSize));
    }
}
