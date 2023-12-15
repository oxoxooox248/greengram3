package com.green.greengram3.dm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class DmMsgInsDto {
    private int idm;//해당 디엠pk
    @JsonIgnore
    private int seq;//디엠 메시지가 작성되면서 생성되는 seq
    private int loginedIuser;//작성자pk
    private String loginedPic;//상대방에 보여줄 나의 프로필 사진
    private String msg;//메시지 내용
}
