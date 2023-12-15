package com.green.greengram3.user.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Schema(title="로그인 완료 시 데이터")
@Builder
public class UserSigninVo {
    private int result;
    private int iuser;
    private String nm;
    private String pic;
    private String firebaseToken;
}
