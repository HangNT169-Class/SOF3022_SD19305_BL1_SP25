package com.poly.sof3022.B12_DatLich;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class TestScheduleDemoService {

    @Autowired
    private DemoService service;

//    @Scheduled(fixedDelay = 1000) // ms
    @Scheduled(cron = "0 7 * * * ?")
    public void testSchedule(){
        service.datDongHoBaoThuc();
    }
}
