package com.vscube.billApp.tools.csv;

import com.vscube.billApp.Service.repos.BillRepository;
import com.vscube.billApp.Service.repos.BookRepository;
import com.vscube.billApp.Service.repos.CustomerRepository;
import com.vscube.billApp.domain.bill.Invoice;
import com.vscube.billApp.domain.bill.InvoiceLine;
import com.vscube.billApp.domain.bill.InvoiceType;
import com.vscube.billApp.domain.book.Book;
import com.vscube.billApp.domain.book.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.vscube.billApp.tools.csv.BookCSVReader.parseCSVWithHeaderForBillDetail;
import static com.vscube.billApp.tools.csv.BookCSVReader.parseCSVWithHeaderForBillHeader;

@SpringBootTest
class InvoiceCSVReaderTest {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BillRepository billRepository;

    @Test
    public void readCSVBillHeaderFile() throws Exception{

        List<BillHeaderModelFromOldDB> itemModelFromOldDBS = parseCSVWithHeaderForBillHeader("InvoiceHeader.csv");
        for (BillHeaderModelFromOldDB it : itemModelFromOldDBS) {
            System.out.println(it.bill_date + " , " + it.billAmount);

        }
    }

    @Test
    public void readCSVBillDetailFile() throws Exception{

        List<BillDetailModelFromOldDB> itemModelFromOldDBS = parseCSVWithHeaderForBillDetail("BillDetail.csv");
        for (BillDetailModelFromOldDB it : itemModelFromOldDBS) {
            System.out.println(it.invoiceNumber + ", "  + it.billNo + " , " + it.itemNo + " " + it.productName);

        }
    }

    @Test
    public void generateBillFromOldBillItems() throws Exception{

        List<BillHeaderModelFromOldDB> itemModelFromOldDBS = parseCSVWithHeaderForBillHeader("InvoiceHeader.csv");
        Map<Long,BillHeaderModelFromOldDB> billHeaderMap = new HashMap<>();
        for (BillHeaderModelFromOldDB it : itemModelFromOldDBS) {
            billHeaderMap.put(it.headerNumber, it);
        }

        Map<Long, Invoice> newBillModelMap = new HashMap<>();


        List<BillDetailModelFromOldDB> itemDetailModelFromOldDBS = parseCSVWithHeaderForBillDetail("BillDetail.csv");
        for (BillDetailModelFromOldDB it : itemDetailModelFromOldDBS) {
            Invoice invoice = newBillModelMap.get(it.invoiceNumber);
            if(invoice == null){
                BillHeaderModelFromOldDB billHeaderModelFromOldDB = billHeaderMap.get(it.invoiceNumber);
                invoice = convertToBill(billHeaderModelFromOldDB);
                newBillModelMap.put(it.invoiceNumber, invoice);
            }

                InvoiceLine invoiceLine = converToBillLine(it);
                List<InvoiceLine> invoiceLines = invoice.getBillLines();
                if(invoiceLines == null) invoiceLines = new ArrayList<>();
                invoiceLines.add(invoiceLine);
                invoice.setBillLines(invoiceLines);
                  System.out.println(invoiceLine.getLineNo() + ", "  + it.invoiceNumber + " , " + it.itemNo + " " + it.productName);

        }
        Set<Map.Entry<Long, Invoice>> entries = newBillModelMap.entrySet();
        for (Map.Entry<Long, Invoice> entry : entries) {
            Optional<Invoice> billById = billRepository.findById(entry.getKey());
            if (billById.isPresent()) {
                throw new Exception(" Bill Already Found Exception" + entry.getValue().toString());
            }
            billRepository.insert(entry.getValue());
        }

    }

    private InvoiceLine converToBillLine(BillDetailModelFromOldDB it) throws Exception {
        InvoiceLine invoiceLine = new InvoiceLine();
        List<Book> books = bookRepository.findByKeyCode(it.productCode);
        if(books.size() < 1) throw  new Exception("Book Not Found Exception" + it.productCode);
        if(books.size() > 1) throw  new Exception("Too Many Book With Name " + it.productCode);
        invoiceLine.setBook(books.get(0));
        invoiceLine.setItemCode(it.productCode);
        invoiceLine.setLineNo(it.itemNo);
        invoiceLine.setQuantity(it.itemQuantity);
        invoiceLine.setUnitPrice(it.itemRate);
        invoiceLine.setTotal(it.lineAmount);
        return invoiceLine;
    };


    private Invoice convertToBill(BillHeaderModelFromOldDB billHeaderModelFromOldDB) throws Exception {
        Invoice invoice = new Invoice();
        invoice.setId(billHeaderModelFromOldDB.headerNumber);
        List<Customer> customers = customerRepository.findByAMCode(billHeaderModelFromOldDB.customerCode);
        if(customers.size() < 1) throw  new Exception("Customers Not Found Exception" + billHeaderModelFromOldDB.customerCode);
        if(customers.size() > 1) throw  new Exception("Too Many Customers With Name " + billHeaderModelFromOldDB.customerCode);
        invoice.setCustomer(customers.get(0));
        invoice.setSubtotal(billHeaderModelFromOldDB.billAmount);
        if(billHeaderModelFromOldDB.type.equals("INV"))
            invoice.setState(InvoiceType.INVOICE);
        else
            invoice.setState(InvoiceType.valueOf(billHeaderModelFromOldDB.type));
        invoice.setDiscount(billHeaderModelFromOldDB.discountCash);
        invoice.setMRPAmount(billHeaderModelFromOldDB.mrpAmount);
        invoice.setBillTotal(billHeaderModelFromOldDB.grossAmount);
        invoice.setDiscountPercentage(billHeaderModelFromOldDB.discount);
        invoice.setCreatedDate(dateOf(billHeaderModelFromOldDB.bill_date));
        return invoice;
    }

    @Test
    public void dateOfTest() throws ParseException {
        System.out.println(dateOf("01-04-2021"));
    }

    private Date dateOf(String bill_date) throws ParseException {
        return new SimpleDateFormat("MM-dd-yyyy").parse(bill_date);
    }

}
