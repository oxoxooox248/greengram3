package com.green.greengram3.user;

import com.green.greengram3.user.model.*;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int insUser(UserSignupDto dto);// insert의 리턴타입은 int or void
    UserEntity selUser(UserSelDto dto);//로그인&디엠추가
    int insFollow(UserFollowDto dto);//팔로우 설정
    int delFollow(UserFollowDto dto);//팔로우 해제
    UserInfoVo selUserInfo(UserInfoSelDto dto);//유저 정보
    int updUserFirebaseToken(UserFirebaseTokenPatchDto dto);//유저 FirebaseToken 변경
    int updUserPic(UserPicPatchDto dto);//유저 사진 변경
}
