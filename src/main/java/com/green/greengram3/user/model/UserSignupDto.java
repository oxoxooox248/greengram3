package com.green.greengram3.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(title="회원가입 데이터")
public class UserSignupDto {
    private String uid;
    private String upw;
    private String nm;
    private String pic;
    @JsonIgnore
    private int iuser;
}
