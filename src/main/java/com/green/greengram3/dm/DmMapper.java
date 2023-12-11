package com.green.greengram3.dm;

import com.green.greengram3.dm.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DmMapper {
    int insDm(DmInsDto dto);
    int insDmUser(DmUserInsDto dto);
    List<DmMsgSelVo> selDmMsgAll(DmMsgSelDto dto);
    List<DmSelVo> selDmAll(DmSelDto dto);
    int insDmMsg(DmMsgInsDto dto);//디엠 메시지 입력
    int delDmMsg(DmMsgDelDto dto);
}
