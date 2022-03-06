package com.vscube.billApp.Service.events;

import com.vscube.billApp.domain.Inventory.InventoryItemLog;
import com.vscube.billApp.domain.Inventory.StockItem;
import com.vscube.billApp.domain.book.Customer;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class InventoryItemLogListener  extends AbstractMongoEventListener<InventoryItemLog> {
    @Override
    public void onBeforeConvert(BeforeConvertEvent<InventoryItemLog> event) {
        if (event.getSource().getId()==null) event.getSource().setId(UUID.randomUUID().toString());
        System.out.println("Customer Event to be raised is " + event.toString());
        event.getSource().setCreatedDate(new Date());

    }
}
