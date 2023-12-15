package com.green.greengram3.dm.model;

import lombok.Data;

@Data
public class DmMsgSelVo {
    private int seq;//메시지 순서
    private String msg;//메시지 내용
    private String createdAt;//메시지 작성일자
    private int writerIuser;//작성자pk
    private String writerPic;//작성자 프로필 사진
}
