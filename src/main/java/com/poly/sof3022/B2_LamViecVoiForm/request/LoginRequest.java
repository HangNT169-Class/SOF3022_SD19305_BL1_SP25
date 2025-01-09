package com.poly.sof3022.B2_LamViecVoiForm.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class LoginRequest {

    private String username;

    private String password;

}
