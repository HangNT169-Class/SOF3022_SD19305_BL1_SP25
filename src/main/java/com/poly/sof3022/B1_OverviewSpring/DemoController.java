package com.poly.sof3022.B1_OverviewSpring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("demo")
    public String demoSof3022() {
        return "buoi1";
    }
}
