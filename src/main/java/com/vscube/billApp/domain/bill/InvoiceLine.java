package com.vscube.billApp.domain.bill;

import com.vscube.billApp.domain.book.Book;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class InvoiceLine {

    public InvoiceLine() {
    }

    private long lineNo;
    private double unitPrice;
    @DBRef
    private Book book;
    private String itemCode;
    private String itemName;
    private long quantity;
    private double total;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }



    public long getLineNo() {
        return lineNo;
    }

    public void setLineNo(long lineNo) {
        this.lineNo = lineNo;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "BillLine{" +
                "lineNumber=" + lineNo +
                ", unitPrice=" + unitPrice +
                ", itemName='" + itemName + '\'' +
                ", itemCode='" + itemCode + '\'' +
                ", quantity=" + quantity +
                ", total=" + total +
                '}';
    }
}
