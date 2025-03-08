package com.erp.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.student.entity.TCEntity;
import com.erp.student.repo.TCRepository;

@Service
public class TCService {

    @Autowired
    private TCRepository tcRepository;

    public void save(TCEntity tcEntity) {
        tcRepository.save(tcEntity);
    }
}

