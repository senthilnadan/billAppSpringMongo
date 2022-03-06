package com.vscube.billApp.Service.controller;

import com.vscube.billApp.Service.repos.InventoryItemLogRepository;
import com.vscube.billApp.Service.repos.InventoryItemRepository;
import com.vscube.billApp.domain.Inventory.InventoryItemLog;
import com.vscube.billApp.domain.book.Author;
import com.vscube.billApp.domain.book.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("app")
public class InventoryItemLogController {

    @Autowired
    InventoryItemLogRepository inventoryItemLogRepository;

    @PostMapping("inventoryLog")
    public InventoryItemLog insertInventoryItemLog(@RequestBody InventoryItemLog inventoryItemLog){
        final String eventMsgId = UUID.randomUUID().toString();
        inventoryItemLog.setId(eventMsgId);
        InventoryItemLog inventoryItemLogInserted = inventoryItemLogRepository.insert(inventoryItemLog);
        return inventoryItemLogInserted;
    }




}
