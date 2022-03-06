package com.vscube.billApp.Service.events;

import com.vscube.billApp.Service.SequenceGeneratorService;
import com.vscube.billApp.domain.book.Customer;
import com.vscube.billApp.domain.book.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

@Component
public class CustomerModelListener extends AbstractMongoEventListener<Customer> {

    @Autowired
    private SequenceGeneratorService sequenceGenerator;

    @Autowired
    public CustomerModelListener(SequenceGeneratorService sequenceGenerator) {
        this.sequenceGenerator = sequenceGenerator;
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Customer> event) {
        System.out.println("Customer Event to be raised is " + event.toString());
        if (event.getSource().getId() < 1) {
            event.getSource().setId(sequenceGenerator.generateSequence(Customer.SEQUENCE_NAME));
        }

    }
}