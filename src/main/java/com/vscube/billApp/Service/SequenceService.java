package com.vscube.billApp.Service;

import com.vscube.billApp.Service.repos.CSequenceRepository;
import com.vscube.billApp.domain.CSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Component
public class SequenceService {

    @Autowired
    CSequenceRepository cSequenceRepository;


    public Long getNexSequence(String sequenceName) {

        Optional<CSequence> sequence = cSequenceRepository.findById(sequenceName);
        if (sequence.isPresent()) {
            CSequence cSequence = sequence.get();
            long seq = cSequence.getSeq();
            cSequence.setSeq(seq+1);
            cSequenceRepository.save(cSequence);
            return cSequence.getSeq();

        } else {
            CSequence cSequence = CreateSequence(sequenceName);
            return cSequence.getSeq();
        }

    }

    private CSequence CreateSequence(String sequenceName) {
        CSequence cSequence = new CSequence();
        cSequence.setId(sequenceName);
        cSequence.setSeq(1);
        return cSequenceRepository.insert(cSequence);
    }


}
