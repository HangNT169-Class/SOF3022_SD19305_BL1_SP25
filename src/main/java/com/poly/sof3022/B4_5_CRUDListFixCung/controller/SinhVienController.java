package com.poly.sof3022.B4_5_CRUDListFixCung.controller;

import com.poly.sof3022.B4_5_CRUDListFixCung.entity.SinhVien;
import com.poly.sof3022.B4_5_CRUDListFixCung.service.DongVatService;
import com.poly.sof3022.B4_5_CRUDListFixCung.service.SinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("sinh-vien/")
//Tach phan chung trong duong dan
public class SinhVienController {
    // goi ham service

    @Autowired
    private SinhVienService sinhVienService;

    @Autowired
    private DongVatService service;

    // RequestMapping => vua su dung Get & Post
    //    @GetMapping("sinh-vien/hien-thi")
    @RequestMapping("hien-thi")
    public String hienThiDanhSachSinhVien(Model model) {
        model.addAttribute("sinhViens", sinhVienService.getLists());
        return "buoi4/sinh-viens";
    }

    @GetMapping("delete/{id}")
    public String xoaSinhVien(@PathVariable("id") String mssv) {
        sinhVienService.removeSinhVien(mssv);
        return "redirect:/sinh-vien/hien-thi";
    }

    @GetMapping("detail/{a}")
    public String detailSinhVien(@PathVariable("a") String mssv,
                                 Model model) {
        model.addAttribute("sv",
                sinhVienService.
                        detailSinhVien(mssv));
        return "buoi4/detail-sinh-vien";
    }

    @GetMapping("view-update/{id}")
    public String viewUpdate(@PathVariable("id") String id, Model model) {
        model.addAttribute("sv", sinhVienService.detailSinhVien(id));
        return "/buoi4/update-sinh-vien";
    }

    @GetMapping("view-add")
    public String viewAdd(Model model) {
        model.addAttribute("sinhVien", new SinhVien());
        return "/buoi4/add-sinh-vien";
    }

    //    @PostMapping("sinh-vien/add")
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addSinhVien(
            @ModelAttribute("sinhVien")
            SinhVien sv) {
        sinhVienService.addSinhVien(sv);
        return "redirect:/sinh-vien/hien-thi";
    }

    @ResponseBody
    @GetMapping("/demo123")
    public List<SinhVien> getAll() {
        return sinhVienService.getLists();
    }
}
