package com.yimi.codegenerator.utils;

import java.util.List;

/**
 * @author dengqiao
 * @date 2019-09-17 09:50
 */
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

    public int getTotalCount() {
        return this.totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return this.totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrPage() {
        return this.currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public List<?> getList() {
        return this.list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }
}
