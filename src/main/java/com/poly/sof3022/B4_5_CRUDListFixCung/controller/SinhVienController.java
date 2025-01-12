package com.poly.sof3022.B4_5_CRUDListFixCung.controller;

import com.poly.sof3022.B4_5_CRUDListFixCung.service.DongVatService;
import com.poly.sof3022.B4_5_CRUDListFixCung.service.SinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class SinhVienController {
    // goi ham service

    @Autowired
    private SinhVienService sinhVienService;

    @Autowired
    private DongVatService service;

    @GetMapping("sinh-vien/hien-thi")
    public String hienThiDanhSachSinhVien(Model model) {
        model.addAttribute("sinhViens", sinhVienService.getLists());
        return "buoi4/sinh-viens";
    }

    @GetMapping("sinh-vien/delete/{id}")
    public String xoaSinhVien(@PathVariable("id") String mssv) {
        sinhVienService.removeSinhVien(mssv);
        return "redirect:/sinh-vien/hien-thi";
    }

    @GetMapping("sinh-vien/detail/{a}")
    public String detailSinhVien(@PathVariable("a") String mssv,
                                 Model model) {
        model.addAttribute("sv",
                sinhVienService.
                        detailSinhVien(mssv));
        return "buoi4/detail-sinh-vien";
    }
}
