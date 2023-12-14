package com.green.greengram3.dm;

import com.green.greengram3.common.ResVo;
import com.green.greengram3.dm.model.*;
import com.green.greengram3.user.UserMapper;
import com.green.greengram3.user.model.UserEntity;
import com.green.greengram3.user.model.UserSelDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DmService {
    private final DmMapper mapper;
    private final UserMapper userMapper;

    public List<DmMsgSelVo> getMsgAll(DmMsgSelDto dto){
        return mapper.selDmMsgAll(dto);
    }

    public List<DmSelVo> getDmAll(DmSelDto dto){
        return mapper.selDmAll(dto);
    }

    public ResVo postDmMsg(DmMsgInsDto dto){
        int affectedRows= mapper.insDmMsg(dto);
        int updRow= mapper.updDmLastMsg(dto);
        return new ResVo(dto.getSeq());
    }

    public ResVo delDmMsg(DmMsgDelDto dto){
        int delAffectedRows = mapper.delDmMsg(dto);
        if(delAffectedRows == 1) {
            int updAffectedRows = mapper.updDmLastMsgAfterDelByLastMsg(dto);
        }
        return new ResVo(delAffectedRows);
    }

    public DmSelVo postDm(DmInsDto dto){
        Integer check= mapper.selDmUserCheck(dto);
        //두 유저가 있는 dm이 있는지 체크
        if(check!=null){return null;}//이미 있는 dm
        mapper.insDm(dto);//dm 생성
        mapper.insDmUser(dto);//생성된 dm에 들어갈 유저 2명
        UserSelDto uDto= new UserSelDto();
        uDto.setIuser(dto.getOtherPersonIuser());
        //다른 유저의 이름, 사진
        UserEntity entity= userMapper.selUser(uDto);
        return DmSelVo.builder().idm(dto.getIdm())
                .otherPersonIuser(entity.getIuser())
                .otherPersonNm(entity.getNm())
                .otherPersonPic(entity.getPic())
                .build();
    }
}
