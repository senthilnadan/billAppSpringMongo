package com.vscube.billApp.Service.controller;


import com.vscube.billApp.Service.repos.BillRepository;
import com.vscube.billApp.domain.bill.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("app")
public class BillRestController {

    @Autowired
    BillRepository billRepository;

    @GetMapping("bills/{id}")
    public Invoice getBookById(@PathVariable(required = true, name = "id") Long id){
        Optional<Invoice> authorOptional = billRepository.findById(id);
        if(authorOptional.isPresent()){
            return authorOptional.get();
        }else{
            return null;
        }
    }

    @GetMapping("bills")
    public List<Invoice> getAuthors(){
        List<Invoice> authorList = billRepository.findAll();
        return  authorList;
    }

    @PostMapping("bills")
    public Invoice insertBook(@RequestBody Invoice invoice){
        System.out.println(invoice.toString());
        Invoice invoiceInserted = billRepository.insert(invoice);
        return invoiceInserted;
    }

    @PatchMapping("bills/{id}")
    public Invoice insertBook(@PathVariable(required = true, name = "id") Long id, @RequestBody Invoice invoice){

        Invoice existingInvoice;
        Optional<Invoice> billOptional = billRepository.findById(id);
        if(billOptional.isPresent()){
            existingInvoice =  billOptional.get();
        }else{
            return null;
        }
        System.out.println(invoice.toString());
        if (!(existingInvoice.getCustomer().equals(invoice.getCustomer()))) existingInvoice.setCustomer(invoice.getCustomer());
        if(existingInvoice.getState()!= invoice.getState()) existingInvoice.setState(invoice.getState());
        existingInvoice.setBillLines(invoice.getBillLines());
        existingInvoice.setDiscount(invoice.getDiscount());
        existingInvoice.setBillTotal(invoice.getBillTotal());
        existingInvoice.setDiscountPercentage(invoice.getDiscountPercentage());
        existingInvoice.setTotalItems(invoice.getTotalItems());
        existingInvoice.setSubtotal(invoice.getSubtotal());
        existingInvoice.setQuickCustomerName(invoice.getQuickCustomerName());
        existingInvoice.setQuickContact(invoice.getQuickContact());
        existingInvoice.setLastModifiedDate(new Date());
        Invoice invoiceInserted = billRepository.save(existingInvoice);

        return invoiceInserted;
    }
}
