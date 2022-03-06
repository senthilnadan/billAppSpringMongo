package com.vscube.billApp.Service.events;

import com.vscube.billApp.Service.SequenceGeneratorService;
import com.vscube.billApp.domain.book.Author;
import com.vscube.billApp.domain.book.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class UserListener  extends AbstractMongoEventListener<User> {

    private SequenceGeneratorService sequenceGenerator;

    @Autowired
    public UserListener(SequenceGeneratorService sequenceGenerator) {
        this.sequenceGenerator = sequenceGenerator;
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<User> event) {
        if (event.getSource().getId() < 1) {
            event.getSource().setId(sequenceGenerator.generateSequence(User.SEQUENCE_NAME));
            event.getSource().setCreatedDate(new Date());
        }
        event.getSource().setLastModifiedDate(new Date());
    }


}