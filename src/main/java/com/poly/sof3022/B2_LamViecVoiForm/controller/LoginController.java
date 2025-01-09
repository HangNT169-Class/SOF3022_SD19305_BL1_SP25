package com.poly.sof3022.B2_LamViecVoiForm.controller;

import com.poly.sof3022.B2_LamViecVoiForm.request.LoginRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("login")
    public String loginForm() {
        return "buoi2/login-form";
    }

    //    @PostMapping("ket-qua")
//    public String hienThiKetQua(@RequestParam("u1")String usename,
//                                @RequestParam("p1")String pass, Model model) {
//        // Lay gia tri vua nhap ben FE(jsp/thymeaf) => controller
//        // J4: getParam..
//        // J5: @ReqestParam
//        model.addAttribute("u1",usename);
//        model.addAttribute("password",pass);
//        return "buoi2/hien-thi-ket-qua";
//    }
    @PostMapping("ket-qua")
    public String hienThiKetQua(LoginRequest request, Model model) {
        model.addAttribute("req", request);
        return "buoi2/hien-thi-ket-qua";
    }
}
