package com.yimi.codegenerator.dao;

import java.util.List;
import java.util.Map;

/**
 * @author dengqiao
 * @date 2019-09-17 09:37
 */
public interface GeneratorDao {
    public List<Map<String, Object>> queryList(Map<String, Object> paramMap);

    public Map<String, String> queryTable(String paramString);

    public List<Map<String, String>> queryColumns(String paramString);
}
