package com.green.greengram3.dm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class DmInsDto {
    @JsonIgnore
    private int idm;//디엠pk
    private int loginedIuser;//로그인 유저pk
    private int otherPersonIuser;//다른 유저pk
}
