package com.green.greengram3.user;

import com.green.greengram3.user.model.*;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int insUser(UserSignupDto dto);// insert의 리턴타입은 int or void
    UserEntity selUser(UserSelDto dto);
    int insFollow(UserFollowDto dto);
    int delFollow(UserFollowDto dto);
}
