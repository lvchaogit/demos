package com.lc.demo.multidata.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest
public class DriverServiceTest {

    @Resource
    private DriverService driverService;

    @Test
    public void testQueryCount(){
        driverService.queryCount();
    }
}
 