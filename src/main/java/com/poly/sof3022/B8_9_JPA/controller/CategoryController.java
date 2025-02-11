package com.poly.sof3022.B8_9_JPA.controller;

import com.poly.sof3022.B8_9_JPA.entity.Category1;
import com.poly.sof3022.B8_9_JPA.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CategoryController {
    // Neu co service: service

    @Autowired
    private CategoryRepository repository;

    @GetMapping("/hien-thi")
    public String hienThiCategory(Model model) {
        // hien thi du lieu len table
//        repository.findAll(); // = getAll: lay tat ca
//        // findById(truyen vao id): detail theo id
//        repository.findById(id)
//        // add/update: save(doi tuong)
//        repository.save(doi tuong)
//        // remove
//        repository.deleteById(id);
//        repository.delete(doi tuong);
        model.addAttribute("lists", repository.findAll());
        return "buoi8/category";
    }

    @ResponseBody
    @GetMapping("/phan-trang")
    public List<Category1> phanTrang(@RequestParam("pageNo1") Integer pageNo,
                                     @RequestParam(value = "pageSize1", defaultValue = "3") Integer pageSize) {
        // import domain
        Pageable pageable = PageRequest.of(pageNo,pageSize);
        return  repository.findAll(pageable).getContent();
    }
}
