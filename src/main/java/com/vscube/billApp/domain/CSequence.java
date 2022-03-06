package com.vscube.billApp.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class CSequence {
    @Id
    private  String id;
    private long seq;

    public CSequence(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getSeq() {
        return seq;
    }

    public void setSeq(long seq) {
        this.seq = seq;
    }

    @Override
    public String toString() {
        return "CSequence{" +
                "id='" + id + '\'' +
                ", seq=" + seq +
                '}';
    }
}
