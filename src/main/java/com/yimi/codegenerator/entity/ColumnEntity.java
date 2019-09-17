package com.yimi.codegenerator.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author dengqiao
 * @date 2019-09-17 10:03
 */
@Getter
@Setter
public class ColumnEntity {
    private String columnName;
    private String dataType;
    private String comments;
    private String attrName;
    private String attrname;
    private String attrType;
    private String extra;
}
