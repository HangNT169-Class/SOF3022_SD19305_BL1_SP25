package com.poly.sof3022.B8_9_JPA.repository;

import com.poly.sof3022.B8_9_JPA.entity.Category1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
// extends: JpaRepository , CRUDRepository
//THS1: Doi tuong can truy van: CRUD, tim kiem, sap xep...
//TS2: Kieu du lieu cua khoa chinh: CHI NHAN VAO KIEU OBJECT => truyen kieu du lieu cua khoa chinh cua 1 bang
public interface CategoryRepository extends JpaRepository<Category1, Long> {
    // CRUD 1 bang khong can phai viet
    // Custom SQL : Tu viet cau query mong muon
    // C1: Query creation => Truy van tren doi tuong ( OBJECT => CLASS)
    // C2: Raw SQL
    // C1: Menh de => truy van bang menh de
    List<Category1> findCategory1ByIdAndCategoryCode(Long id, String categoryCode);

    // Ten ham => dai
    // Ten bien/Class sua => Khong goi y cho de sua
    // C2: Raw SQL
    // C2.1: JPQL - JPA Query Language <=> HQL : Truy van tren thuc the
    // Khong co SELECT * FROM table => Select object
    @Query("SELECT c FROM Category1 c WHERE c.id = ?2 AND c.categoryName = ?1")
    List<Category1> search(String name, Long id);

    // C2.2: Truy nav tren SQL : *, category_name: native query
    @Query(value = "SELECT * FROM category WHERE id = ?2 AND category_name = ?1",nativeQuery = true)
    List<Category1> search1(String name, Long id);

}
