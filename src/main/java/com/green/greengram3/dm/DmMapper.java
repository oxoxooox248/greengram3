package com.green.greengram3.dm;

import com.green.greengram3.dm.model.*;
import com.green.greengram3.user.model.UserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DmMapper {
    int insDm(DmInsDto dto);//CREATE DM
    int insDmUser(DmInsDto dto);//INSERT USER
    int updDmLastMsg(DmMsgInsDto dto);//UPDATE LATEST MSG
    Integer selDmUserCheck(DmInsDto dto);//CHECK DM_EXISTENCE
    List<DmMsgSelVo> selDmMsgAll(DmMsgSelDto dto);//DM MSG LIST
    int updDmLastMsgAfterDelByLastMsg(DmMsgDelDto dto);
    //UPDATE LATEST MSG < DELETE MSG
    List<DmSelVo> selDmAll(DmSelDto dto);//DM LIST
    int insDmMsg(DmMsgInsDto dto);//WRITE DM MSG
    int delDmMsg(DmMsgDelDto dto);//DELETE DM MSG
    UserEntity selOtherPersonByLoginUser(DmMsgInsDto dto);
}
