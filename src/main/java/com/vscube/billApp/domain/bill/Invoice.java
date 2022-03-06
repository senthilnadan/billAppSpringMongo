package com.vscube.billApp.domain.bill;

import com.vscube.billApp.domain.book.Customer;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document
public class Invoice {

    public static final String SEQUENCE_NAME = "bill";
    @Id
    private Long id;
    @DBRef
    private Customer customer;
    private InvoiceType state;
    private PaymentType paymentType;

    private InvoiceStatus status;

    private String quickCustomerName;
    private String quickContact;

    @Version
    private long version;
    private Date createdDate;
    private Date lastModifiedDate;

    private List<InvoiceLine> invoiceLines;

    private double discount;
    private double discountPercentage;

    private long totalItems;
    private double subtotal;
    private double billTotal;
    private double mrpAmount;


    public Invoice() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public InvoiceType getState() {
        return state;
    }

    public void setState(InvoiceType state) {
        this.state = state;
    }

    public String getQuickCustomerName() {
        return quickCustomerName;
    }

    public void setQuickCustomerName(String quickCustomerName) {
        this.quickCustomerName = quickCustomerName;
    }

    public String getQuickContact() {
        return quickContact;
    }

    public void setQuickContact(String quickContact) {
        this.quickContact = quickContact;
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

    public List<InvoiceLine> getBillLines() {
        return invoiceLines;
    }

    public void setBillLines(List<InvoiceLine> invoiceLines) {
        this.invoiceLines = invoiceLines;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public long getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(long totalItems) {
        this.totalItems = totalItems;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getBillTotal() {
        return billTotal;
    }

    public void setBillTotal(double billTotal) {
        this.billTotal = billTotal;
    }

    public void setMRPAmount(double mrpAmount) {
        this.mrpAmount = mrpAmount;
    }


}
