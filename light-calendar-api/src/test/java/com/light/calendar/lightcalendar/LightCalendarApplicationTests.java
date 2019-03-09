package com.light.calendar.lightcalendar;

import com.light.calendar.lightcalendar.application.LightCalendarApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = LightCalendarApplication.class)
public class LightCalendarApplicationTests {

    @Test
    public void contextLoads() {
    }

}
