package com.vscube.billApp;

import com.vscube.billApp.Service.SequenceService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SequenceServiceTest {

    @Autowired
    SequenceService sequenceService;

    @Test
    public  void testSequenceIncrement(){
        Long test = sequenceService.getNexSequence("Test");
        Assertions.assertThat(sequenceService.getNexSequence("Test")).isEqualTo(test+1);
    }

}
