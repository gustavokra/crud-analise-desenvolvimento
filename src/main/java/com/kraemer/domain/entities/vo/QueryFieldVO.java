package com.kraemer.domain.entities.vo;

public class QueryFieldVO {

    private String fieldName;

    private Object fieldValue;

    public QueryFieldVO(final String fieldName, final Object fieldValue) {
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }

}
