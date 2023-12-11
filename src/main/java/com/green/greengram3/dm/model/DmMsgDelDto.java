package com.green.greengram3.dm.model;

import lombok.Data;

@Data
public class DmMsgDelDto {
    private int seq;//해당 디엠 메시지 순서
    private int idm;//해당 디엠pk
    private int iuser;//해당 유저pk
}
