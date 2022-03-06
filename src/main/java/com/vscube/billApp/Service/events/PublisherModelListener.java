package com.vscube.billApp.Service.events;

import com.vscube.billApp.Service.SequenceGeneratorService;
import com.vscube.billApp.domain.book.Author;
import com.vscube.billApp.domain.book.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class PublisherModelListener extends AbstractMongoEventListener<Publisher> {

    private SequenceGeneratorService sequenceGenerator;

    @Autowired
    public PublisherModelListener(SequenceGeneratorService sequenceGenerator) {
        this.sequenceGenerator = sequenceGenerator;
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Publisher> event) {
        if (event.getSource().getId() < 1) {
            event.getSource().setId(sequenceGenerator.generateSequence(Publisher.SEQUENCE_NAME));
        }

    }
}
