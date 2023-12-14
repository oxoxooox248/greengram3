package com.green.greengram3.dm.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DmSelVo {
    private int idm;//디엠pk
    private String lastMsg;//디엠의 최신 메시지
    private String lastMsgAt;//디엠의 최신 메시지 작성일자
    private int otherPersonIuser;//디엠에 참여한 다른 유저pk
    private String otherPersonNm;//디엠에 참여한 다른 유저의 닉네임
    private String otherPersonPic;//디엠에 참여한 다른 유저의 프로필사진
}
