package com.dengqiao.codegenerator.utils;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author dengqiao
 * @date 2019-09-17 09:51
 */
public class Query extends LinkedHashMap<String, Object> {
    private int page;
    private int limit;

    public Query(Map<String, Object> params) {
        putAll(params);

        this.page = Integer.parseInt(params.get("page").toString());
        this.limit = Integer.parseInt(params.get("limit").toString());
        put("offset", Integer.valueOf((this.page - 1) * this.limit));
        put("page", Integer.valueOf(this.page));
        put("limit", Integer.valueOf(this.limit));
    }

    public int getPage() {
        return this.page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return this.limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
