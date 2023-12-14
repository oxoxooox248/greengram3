package com.green.greengram3.user;

import com.green.greengram3.common.Const;
import com.green.greengram3.common.ResVo;
import com.green.greengram3.user.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;

    public ResVo signup(UserSignupDto dto){
        //uid, upw, nm이 제대로 넘어왔는지 체크를 해야한다.(데이터 무결성 때문에)
        String salt= BCrypt.gensalt();
        String hashedPw= BCrypt.hashpw(dto.getUpw(),salt);
        //비밀번호 암호화 (단방향>복호화가 안된다.)
        //(비밀번호를 바꿀수는 있어도 이전 비밀번호가 뭔지는 알수없다.)
        dto.setUpw(hashedPw);
        int affectedCnt= mapper.insUser(dto);
        if(affectedCnt==0){return new ResVo(0);}
        return new ResVo(dto.getIuser());//회원가입한 iuser pk값이 리턴
    }
    public UserSigninVo signin(UserSigninDto dto){
        UserSelDto sDto= new UserSelDto();
        sDto.setUid(dto.getUid());
        UserEntity entity= mapper.selUser(sDto);
        if(entity==null){
            return UserSigninVo.builder().result(Const.LOGIN_NO_UID).build();
        } else if(!BCrypt.checkpw(dto.getUpw(),entity.getUpw())){
            return UserSigninVo.builder().result(Const.LOGIN_DIFF_UPW).build();
        }
        return UserSigninVo.builder().result(Const.SUCCESS).
                iuser(entity.getIuser()).nm(entity.getNm()).
                pic(entity.getPic()).build();
    }
    public ResVo toggleFollow(UserFollowDto dto){
        int delFollow= mapper.delFollow(dto);
        if(delFollow==1){
            return new ResVo(0);
        }
        return new ResVo(mapper.insFollow(dto));
    }
    public UserInfoVo getUserInfo(UserInfoSelDto dto){
        return mapper.selUserInfo(dto);
    }
}
