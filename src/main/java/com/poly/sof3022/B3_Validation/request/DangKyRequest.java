package com.poly.sof3022.B3_Validation.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DangKyRequest {
    @NotBlank
    private String fullName;

    @NotEmpty(message = "Password khong duoc de trong")
//    @Pattern(regexp = "doan regex mong muon",message = "custom mess")
//    @Min(5)
//    @Max(10)
//    @Size
    private String passWord;

//    private String tuoi;

    private Boolean gender;


}
