package com.lc.demo.multidata.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class VehicleServiceTest {

    @Resource
    private VehicleService vehicleService;

    @Test
    public void testQueryCount(){
        vehicleService.queryCount();
    }
}
 