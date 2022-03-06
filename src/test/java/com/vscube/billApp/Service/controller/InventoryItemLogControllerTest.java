package com.vscube.billApp.Service.controller;

import com.vscube.billApp.Service.repos.InventoryItemLogRepository;
import com.vscube.billApp.Service.repos.InventoryItemRepository;
import com.vscube.billApp.domain.Inventory.InventoryItemLog;
import com.vscube.billApp.domain.Inventory.InventoryItemLogState;
import com.vscube.billApp.domain.Inventory.InventoryOperation;
import com.vscube.billApp.domain.Inventory.StockItem;
import com.vscube.billApp.domain.book.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class InventoryItemLogControllerTest {

    @Autowired
    InventoryItemLogRepository inventoryItemLogRepository;
    @Autowired
    InventoryItemRepository inventoryItemRepository;

    @Test
    public void inventoryLogItemInsertTest() throws Exception {
        Book book = new Book();
        book.setId(89l);
        List<StockItem> byBook = inventoryItemRepository.findByBook(book);
        if(byBook.size() <1) throw new Exception("Stock for Book Not Found");
        if(byBook.size() >1) throw new Exception("Multiple Stock Items Found Exception");
        System.out.println(byBook.get(0));

        InventoryItemLog inventoryItemLog = new InventoryItemLog();
        inventoryItemLog.setStockItem(byBook.get(0));
        inventoryItemLog.setQuantity(100L);
        inventoryItemLog.setInventoryOperation(InventoryOperation.ADD);
        inventoryItemLog.setInventoryItemLogState(InventoryItemLogState.OPEN);
        inventoryItemLogRepository.insert(inventoryItemLog);

    }




}