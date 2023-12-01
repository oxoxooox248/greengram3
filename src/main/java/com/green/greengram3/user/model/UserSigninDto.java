package com.green.greengram3.user.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(title="인증 데이터")
public class UserSigninDto {
    private String uid;
    private String upw;
}
