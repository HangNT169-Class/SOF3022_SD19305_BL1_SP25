package com.poly.sof3022.B4_5_CRUDListFixCung.controller;

import com.poly.sof3022.B4_5_CRUDListFixCung.entity.SinhVien;
import com.poly.sof3022.B4_5_CRUDListFixCung.service.SinhVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SinhVien1Controller {
    //    Tra ve bat cu kieu du lieu

    @Autowired
    private SinhVienService sinhVienService;

    @GetMapping("/demo/rest-controller")
    public List<SinhVien> getAll() {
        return sinhVienService.getLists();
    }

    @GetMapping("/a")
    public String test(){
        return "test1";
    }
}
