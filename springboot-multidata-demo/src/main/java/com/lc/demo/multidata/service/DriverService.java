package com.lc.demo.multidata.service;

import javax.annotation.Resource;

import com.lc.demo.multidata.mapper.base.DriverMapper;
import org.springframework.stereotype.Service;

@Service
public class DriverService {

    @Resource
    private DriverMapper driverMapper;

    public void queryCount(){
        int count = driverMapper.queryCount();
        System.out.println(count);
    }
}
 