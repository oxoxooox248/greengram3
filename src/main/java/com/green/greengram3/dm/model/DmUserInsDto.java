package com.green.greengram3.dm.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DmUserInsDto {
    private int idm;//디엠pk
    private int iuser;//유저pk
}
