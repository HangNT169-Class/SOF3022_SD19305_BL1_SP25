package com.poly.sof3022.B1_OverviewSpring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
    /**
     * Tat ca cac class trong Spring boot giong nhu 1 bean.
     * De danh dau la 1 bean thi se duoc danh dau bang cac annotation: @
     *    + @Controller/@RestController : Tang trung gian chung chuyen trao doi BE & FE
     *    + @Repository: Tang lam viec truc tiep vs CSDL: viet cac ham CRUD..
     *    + @Service: Tang xu ly logic cua toan bo project
     *    + @Component
     * Tat ca cac ham trong controller => LUON LUON TRA VE VIEW (RETURN 1 STRING)
     * HTTP method:
     *  + GET: hien thi, lay ra..
     *  + POST: xu ly form
     */
    @GetMapping("demo")
    public String demoSof3022(Model model) {
        // Day gia tri tu servlet/controller => giao dien (jsp/thymeaf)
        // J4: request.setAttribute
        // J5: model.addAttribute
        model.addAttribute("mess","SOF3022 - SD19305");
        return "buoi1";
    }
}
