package com.poly.sof3022.B8_9_JPA.repository;

import com.poly.sof3022.B8_9_JPA.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// extends: JpaRepository , CRUDRepository
//THS1: Doi tuong can truy van: CRUD, tim kiem, sap xep...
//TS2: Kieu du lieu cua khoa chinh: CHI NHAN VAO KIEU OBJECT => truyen kieu du lieu cua khoa chinh cua 1 bang
public interface ProductRepository extends JpaRepository<Product, Long> {

}
