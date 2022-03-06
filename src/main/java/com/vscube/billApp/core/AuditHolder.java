package com.vscube.billApp.core;

import java.util.Date;

public class AuditHolder<T> {
    private  T entity;
    private Date createdDate;
    private  long version;

    private final String key;

    public AuditHolder(T entity, String key , long version) {
        this.entity = entity;
        this.key = key;
        this.createdDate = new Date();
        this.version = version;
    }

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }

    public String getKey() {
        return key;
    }
}

