package com.green.greengram3.user.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "모든 유저 정보 데이터")
public class UserEntity {
    private int iuser;
    private String uid;
    private String upw;
    private String nm;
    private String pic;
    private String firebaseToken;
    private String createdAt;
    private String updatedAt;
}
