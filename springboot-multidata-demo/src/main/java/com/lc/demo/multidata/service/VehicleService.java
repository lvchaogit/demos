package com.lc.demo.multidata.service;

import javax.annotation.Resource;

import com.lc.demo.multidata.mapper.second.VehicleMapper;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

    @Resource
    private VehicleMapper vehicleMapper;

    public void queryCount(){
        int count = vehicleMapper.queryCount();
        System.out.println(count);
    }

}
 