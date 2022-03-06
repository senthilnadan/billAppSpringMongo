package com.vscube.billApp.Service.repos;

import com.vscube.billApp.domain.Inventory.StockItem;
import com.vscube.billApp.domain.book.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface InventoryItemRepository extends MongoRepository<StockItem, Long> {

    List<StockItem> findByBook(Book existingBook);
}
