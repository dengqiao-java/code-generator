package com.dengqiao.codegenerator.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author dengqiao
 * @date 2019-09-17 10:04
 */
@Getter
@Setter
public class TableEntity {
    private String tableName;
    private String comments;
    private ColumnEntity pk;
    private List<ColumnEntity> columns;
    private String className;
    private String className0;
}
