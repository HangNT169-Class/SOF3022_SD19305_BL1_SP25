package com.poly.sof3022.B3_Validation.controller;

import com.poly.sof3022.B3_Validation.request.DangKyRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DangKyController {
    @GetMapping("dang-ky")
    public String hienThiFormDangKy(Model model) {
        // Tao ra 1 doi tuong de view hung de validate cac truong tren doi tuong day
        DangKyRequest request = new DangKyRequest();
        request.setGender(true);
        model.addAttribute("request1", request);
        return "buoi3/dang-ky";
    }

    @PostMapping("ket-qua1")
    public String xuLyDangKy(@Valid @ModelAttribute("request1") DangKyRequest request,
                             BindingResult result, Model model) {
        if(result.hasErrors()){
            return "buoi3/dang-ky";
        }
        model.addAttribute("req", request);
        return "buoi3/ket-qua";
    }
}
