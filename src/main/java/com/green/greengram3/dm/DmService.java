package com.green.greengram3.dm;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import com.green.greengram3.common.Const;
import com.green.greengram3.common.ResVo;
import com.green.greengram3.dm.model.*;
import com.green.greengram3.user.UserMapper;
import com.green.greengram3.user.model.UserEntity;
import com.green.greengram3.user.model.UserSelDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DmService {
    private final DmMapper mapper;
    private final UserMapper userMapper;
    private final ObjectMapper objMapper;
    //DM MSG LIST
    public List<DmMsgSelVo> getMsgAll(DmMsgSelDto dto){
        return mapper.selDmMsgAll(dto);
    }
    //DM LIST
    public List<DmSelVo> getDmAll(DmSelDto dto){
        return mapper.selDmAll(dto);
    }
    //WRITE DM MSG
    public ResVo postDmMsg(DmMsgInsDto dto){
        int affectedRows= mapper.insDmMsg(dto);
        if(affectedRows==1){
            int updRow= mapper.updDmLastMsg(dto);
        }
        LocalDateTime now= LocalDateTime.now();
        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String createdAt= now.format(formatter);
        UserEntity otherPerson= mapper.selOtherPersonByLoginUser(dto);
        try{
            if(otherPerson.getFirebaseToken()!=null){
                DmMsgPushVo pushVo= new DmMsgPushVo();
                pushVo.setIdm(dto.getIdm());
                pushVo.setSeq(dto.getSeq());
                pushVo.setWriterIuser(dto.getLoginedIuser());
                pushVo.setWriterPic(dto.getLoginedPic());
                pushVo.setMsg(dto.getMsg());
                pushVo.setCreatedAt(createdAt);
                String body= objMapper.writeValueAsString(pushVo);
                Notification noti= Notification.builder().
                        setTitle("dm").
                        setBody(body).
                        build();
                Message message= Message.builder().
                        setToken(otherPerson.getFirebaseToken()).
                        setNotification(noti).
                        build();
                FirebaseMessaging.getInstance().sendAsync(message);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResVo(dto.getSeq());//RETURN SEQUENCE
    }
    //DELETE DM MSG
    public ResVo delDmMsg(DmMsgDelDto dto){
        int delAffectedRows = mapper.delDmMsg(dto);
        if(delAffectedRows == Const.SUCCESS) {
            int updAffectedRows = mapper.updDmLastMsgAfterDelByLastMsg(dto);
        }
        return new ResVo(delAffectedRows);
    }
    //CREATE DM
    public DmSelVo postDm(DmInsDto dto){
        Integer check= mapper.selDmUserCheck(dto);
        //Check Dm_Existence
        if(check!=null){return null;}//Already Exist
        mapper.insDm(dto);//Create Dm
        mapper.insDmUser(dto);//Insert User
        UserSelDto uDto= new UserSelDto();
        uDto.setIuser(dto.getOtherPersonIuser());
        //OtherPerson의 PIC, NM
        UserEntity entity= userMapper.selUser(uDto);
        return DmSelVo.builder().
                idm(dto.getIdm()).
                otherPersonIuser(entity.getIuser()).
                otherPersonNm(entity.getNm()).
                otherPersonPic(entity.getPic()).
                build();
    }
}
