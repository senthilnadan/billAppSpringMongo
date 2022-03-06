package com.vscube.billApp.Service.controller;

import com.vscube.billApp.Service.repos.BookRepository;
import com.vscube.billApp.Service.repos.InventoryItemLogRepository;
import com.vscube.billApp.Service.repos.InventoryItemRepository;
import com.vscube.billApp.domain.Inventory.InventoryItemLog;
import com.vscube.billApp.domain.Inventory.InventoryItemLogState;
import com.vscube.billApp.domain.Inventory.InventoryOperation;
import com.vscube.billApp.domain.Inventory.StockItem;
import com.vscube.billApp.domain.book.Author;
import com.vscube.billApp.domain.book.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("app")
public class BookRestController {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    InventoryItemLogRepository inventoryItemLogRepository;

    @Autowired
    InventoryItemRepository stockRepository;

    @GetMapping("books/{id}")
    public Book getBookById(@PathVariable(required = true, name = "id") Long id){
        Optional<Book> authorOptional = bookRepository.findById(id);
        if(authorOptional.isPresent()){
            return authorOptional.get();
        }else{
            return null;
        }
    }

    @GetMapping("books")
    public List<Book> getAuthors(){
        List<Book> authorList = bookRepository.findAll();
        return  authorList;
    }

    @PostMapping("books")
    public Book insertBook(@RequestBody Book book){
        System.out.println(book.toString());
        Book bookInserted = bookRepository.insert(book);
        return bookInserted;
    }

    @PatchMapping("books/{id}")
    public Book insertBook(@PathVariable(required = true, name = "id") Long id, @RequestBody Book book){
        Book existingBook ;
        Optional<Book> bookOptional = bookRepository.findById(id);
        if(bookOptional.isPresent()){
            existingBook =  bookOptional.get();
        }else{
            return null;
        }

        System.out.println(book.toString());
        if(existingBook.getName() != book.getName()) existingBook.setName(book.getName());
        if(existingBook.getKeyCode() != book.getKeyCode()) existingBook.setKeyCode(book.getKeyCode());
        if(existingBook.getPrice() != book.getPrice()) existingBook.setPrice(book.getPrice());
        if(existingBook.getISBN() != book.getISBN()) existingBook.setISBN(book.getISBN());
        if((existingBook.getAuthor() == null) ||  (existingBook.getAuthor().getId()  != book.getAuthor().getId())) existingBook.setAuthor(book.getAuthor());
        if((existingBook.getPublisher() == null) ||  (existingBook.getPublisher().getId()  != book.getPublisher().getId())) existingBook.setPublisher(book.getPublisher());

        Book bookInserted = bookRepository.save(existingBook);
        return bookInserted;
    }


    @PostMapping("books/stocks/{id}")
    public StockItem addStock(@PathVariable(required = true, name = "id") Long id, @RequestBody StockItem stockItem){
        Book existingBook ;
        Optional<Book> bookOptional = bookRepository.findById(id);
        if(bookOptional.isPresent()){
            existingBook =  bookOptional.get();
        }else{
            return null;
        }


        stockItem.setBook(existingBook);
        return stockRepository.insert(stockItem);

    }

    @PostMapping("books/stocks/logs/{id}")
    public InventoryItemLog getStockLogsByBookId(@PathVariable(required = true, name = "id") Long id, @RequestBody InventoryItemLog inventoryItemLog ){


        Book existingBook ;
        Optional<Book> bookOptional = bookRepository.findById(id);
        if(bookOptional.isPresent()){
            existingBook =  bookOptional.get();
        }else{
            return null;
        }

        System.out.println("inventoryItemlog " + inventoryItemLog);
        StockItem stockItem;
        List<StockItem> stockItems = stockRepository.findByBook(existingBook);
        if(stockItems.size()<1) {

            stockItem = emptyStockItem(existingBook);
            stockItem.setId(0l);
            stockItem.setQtyInHand(0);
            stockItem = stockRepository.insert(stockItem);

        }
        else stockItem = stockItems.get(0);
        inventoryItemLog.setId(UUID.randomUUID().toString());
        inventoryItemLog.setStockItem(stockItem);
        inventoryItemLog.setInventoryItemLogState(InventoryItemLogState.OPEN);
         inventoryItemLog = inventoryItemLogRepository.insert(inventoryItemLog);
        System.out.println("inventoryItemlog " + inventoryItemLog);
        return inventoryItemLog;
    }

    @GetMapping("books/stocks/logs/{id}")
    public List<InventoryItemLog> getStockLogsByBookId(@PathVariable(required = true, name = "id") Long id){
        Book existingBook ;
        List<InventoryItemLog>  inventoryItemLogs =  new ArrayList<>();
        Optional<Book> bookOptional = bookRepository.findById(id);
        if(bookOptional.isPresent()){
            existingBook =  bookOptional.get();
        }else{
            return inventoryItemLogs;
        }

        List<StockItem> stockItems = stockRepository.findByBook(existingBook);
        if(stockItems.size()<1) return inventoryItemLogs;
        StockItem stockItem = stockItems.get(0);

          inventoryItemLogs= inventoryItemLogRepository.findByStockItem(stockItem);
        return inventoryItemLogs;
    }

    @GetMapping("books/stocks/{id}")
    public StockItem getStock(@PathVariable(required = true, name = "id") Long id){
        Book existingBook ;
        Optional<Book> bookOptional = bookRepository.findById(id);
        if(bookOptional.isPresent()){
            existingBook =  bookOptional.get();
        }else{
            return null;
        }

        List<StockItem> stockItems = stockRepository.findByBook(existingBook);
        if(stockItems.size()<1) return emptyStockItem(existingBook);
        StockItem stockItem = stockItems.get(0);

        List<InventoryItemLog>  inventoryItemLogs= inventoryItemLogRepository.findByStockItemAndInventoryItemLogState(stockItem, InventoryItemLogState.OPEN);

        if(inventoryItemLogs.size()> 0 ){
            inventoryItemLogs.stream().forEach(inventoryItemLog -> {
                switch (inventoryItemLog.getInventoryOperation()){
                    case ADD :  {
                        stockItem.setQtyInHand(stockItem.getQtyInHand() + inventoryItemLog.getQuantity());
                        inventoryItemLog.setInventoryItemLogState(InventoryItemLogState.CLOSED);
                        break;
                    }
                    case REMOVE:  {
                        stockItem.setQtyInHand(stockItem.getQtyInHand() - inventoryItemLog.getQuantity());
                        inventoryItemLog.setInventoryItemLogState(InventoryItemLogState.CLOSED);
                        break;
                    }

                }
            });
            stockRepository.save(stockItem);
            inventoryItemLogRepository.saveAll(inventoryItemLogs);

        }
        return stockItem;
    }

    private StockItem emptyStockItem(Book existingBook) {
        StockItem stockItem =  new StockItem();
        stockItem.setQtyInHand(0);
        stockItem.setBook(existingBook);
        return stockItem;
    }

}
