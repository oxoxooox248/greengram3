package com.green.greengram3.user.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "유저 정보 데이터를 얻기 위해 받는 데이터")
public class UserSelDto {
    private String uid;
    private int iuser;
}
