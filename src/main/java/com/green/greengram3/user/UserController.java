package com.green.greengram3.user;

import com.green.greengram3.common.ResVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.green.greengram3.user.model.*;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
@Tag(name= "유저 API",description= "유저 관련 처리")
public class UserController {
    private final UserService service;

    @PostMapping("/signup")//주소값도 맞춰 줘야 한다.
    @Operation(summary = "회원가입", description = "회원가입 처리<br>(uid: 아이디, upw: 비밀번호 ,nm: 이름 pic: 프로필 사진)")
    public ResVo postSignup(@RequestBody UserSignupDto dto){
        //@RequestBody를 안적으면 Swagger에서 폼데이터 형태로 넘어간다.
        //클래스 이름은 안 맞춰도 되지만 필드명은 반드시 맞춰줘야 한다.
        log.info("dto: {}", dto);
        return service.signup(dto);
    }
    @PostMapping("/signin")
    @Operation(summary = "인증", description = "아이디/비밀번호을 활용한 인증 처리<br>(uid: 아이디, upw: 비밀번호)")
    public UserSigninVo postSignin(@RequestBody UserSigninDto dto){
        //로그인할 때 받는 UserSigninVo에 이름과 사진을 쿠키 등의 저장공간에 저장
        //pk, 이름, 프로필 사진
        log.info("dto: {}", dto);
        return service.signin(dto);
        //result - (1):성공, (2):아이디 없음, (3):비밀번호 틀림
    }
}
