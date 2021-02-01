package com.tuowazi.demo.spring.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhangweixiao - 19-3-28
 */
@Service
@Log4j2
@Transactional
public class TransCallTransServiceImpl implements TransCallTransService {

    @Autowired
    private TransService transService;

    @Override
    public void callRequired() {
        transService.requiredTrans();
    }

    @Override
    public void callSupports() {
        transService.supportsTrans();
    }

    @Override
    public void callMandatory() {
        transService.mandatoryTrans();
    }

    @Override
    public void callRequiredNew() {
        transService.requiredNewTrans();
    }

    @Override
    public void callNotSupported() {
        transService.notSupportedTrans();
    }

    @Override
    public void callNever() {
        transService.neverTrans();
    }

    @Override
    public void callNested() {
        transService.nestedTrans();
    }
}
