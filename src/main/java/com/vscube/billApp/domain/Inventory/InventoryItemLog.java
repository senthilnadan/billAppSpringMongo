package com.vscube.billApp.domain.Inventory;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.UUID;

@Document
public class InventoryItemLog {


    public InventoryItemLog() {
    }

    @Id
    private  String id;

    public InventoryItemLogState getInventoryItemLogState() {
        return inventoryItemLogState;
    }

    public void setInventoryItemLogState(InventoryItemLogState inventoryItemLogState) {
        this.inventoryItemLogState = inventoryItemLogState;
    }

    private Long inventoryId;

    @DBRef
    private StockItem stockItem;

    private Long billId;

    private Long lineNo;

    private Long quantity;

    private String details;

    private InventoryOperation inventoryOperation;

    private InventoryItemLogState inventoryItemLogState;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Long inventoryId) {
        this.inventoryId = inventoryId;
    }

    public StockItem getStockItem() {
        return stockItem;
    }

    public void setStockItem(StockItem stockItem) {
        this.stockItem = stockItem;
    }

    public Long getBillId() {
        return billId;
    }

    public void setBillId(Long billId) {
        this.billId = billId;
    }

    public Long getLineNo() {
        return lineNo;
    }

    public void setLineNo(Long lineNo) {
        this.lineNo = lineNo;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public InventoryOperation getInventoryOperation() {
        return inventoryOperation;
    }

    public void setInventoryOperation(InventoryOperation inventoryOperation) {
        this.inventoryOperation = inventoryOperation;
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


    @Override
    public String toString() {
        return "InventoryItemLog{" +
                "id='" + id + '\'' +
                ", inventoryId=" + inventoryId +
                ", stockItem=" + stockItem +
                ", billId=" + billId +
                ", lineNo=" + lineNo +
                ", quantity=" + quantity +
                ", details='" + details + '\'' +
                ", inventoryOperation=" + inventoryOperation +
                ", inventoryItemLogState=" + inventoryItemLogState +
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
