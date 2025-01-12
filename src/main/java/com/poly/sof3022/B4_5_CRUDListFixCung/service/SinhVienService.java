package com.poly.sof3022.B4_5_CRUDListFixCung.service;

import com.poly.sof3022.B4_5_CRUDListFixCung.entity.SinhVien;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SinhVienService {
    // 6 chuc nang
    // => load du lieu len table
    private List<SinhVien> lists = new ArrayList<>();

    public SinhVienService() {
        // khoi tao gia tri cac phan tu trong list tai day
        // them 5 phan tu vao list
        lists.add(new SinhVien("ph123", "lam", 20, "hanoi", true));
        lists.add(new SinhVien("ph1234", "nam", 30, "hanam", false));
        lists.add(new SinhVien("ph1235", "ha", 35, "haiphong", true));
        lists.add(new SinhVien("ph1236", "long", 18, "hungyen", false));
        lists.add(new SinhVien("ph1237", "lien", 46, "danang", true));
    }

    public List<SinhVien> getLists() {
        return lists;
    }

    //
//    for(Student s: lists){
//
//    }
    public void removeSinhVien(String ma) {
        // lamda
        lists.removeIf(sv -> sv.getMssv().equalsIgnoreCase(ma));
    }

    //    https://viblo.asia/p/su-dung-streams-filter-trong-java-8-naQZReedKvx
    public SinhVien detailSinhVien(String ma) {
        return lists.stream()
                .filter(s -> s.getMssv().equalsIgnoreCase(ma))
                .findFirst() // min, max, count
                .orElse(null);
    }

    public void addSinhVien(SinhVien sv) {
        lists.add(sv);
    }

    // method reference: ::
    // lamda: ->
    public List<SinhVien> searchByName(String name) {
        return lists.stream()
                .filter(s -> s.getTen().contains(name))
                .collect(Collectors.toList());
    }

    public void updateSinhVien(String mssv,
                               SinhVien newSinhVien) {
        lists = lists.stream()
                .map(s -> s.getMssv()
                        .equalsIgnoreCase(mssv)
                        ? newSinhVien : s)
                .collect(Collectors.toList());
    }
}
