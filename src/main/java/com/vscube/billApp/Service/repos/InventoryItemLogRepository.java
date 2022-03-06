package com.vscube.billApp.Service.repos;

import com.vscube.billApp.domain.Inventory.InventoryItemLog;
import com.vscube.billApp.domain.Inventory.InventoryItemLogState;
import com.vscube.billApp.domain.Inventory.StockItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public interface InventoryItemLogRepository extends MongoRepository<InventoryItemLog, UUID> {
    List<InventoryItemLog> findByStockItem(StockItem stockItem);

    List<InventoryItemLog> findByStockItemAndInventoryItemLogState(StockItem stockItem, InventoryItemLogState open);
}
