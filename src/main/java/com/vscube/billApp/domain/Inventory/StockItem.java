package com.vscube.billApp.domain.Inventory;

import com.vscube.billApp.domain.book.Book;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class StockItem {

    public static final String SEQUENCE_NAME = "stock";

    @Id
    private Long id;

    @DBRef
    private Book book;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }



    public long getQtyInHand() {
        return qtyInHand;
    }

    public void setQtyInHand(long qtyInHand) {
        this.qtyInHand = qtyInHand;
    }


    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }


    private long qtyInHand;

    @Override
    public String toString() {
        return "StockItem{" +
                "id=" + id +
                ", book=" + book +
                ", qtyInHand=" + qtyInHand +
                ", version=" + version +
                ", createdDate=" + createdDate +
                ", lastModifiedDate=" + lastModifiedDate +
                '}';
    }

    @Version
    private long version;
    private Date createdDate;
    private Date lastModifiedDate;

}
