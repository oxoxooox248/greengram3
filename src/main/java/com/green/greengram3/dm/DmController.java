package com.green.greengram3.dm;

import com.green.greengram3.common.ResVo;
import com.green.greengram3.dm.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/dm")
@Tag(name = "디엠 API", description = "디엠 관련 처리")
public class DmController {
    private final DmService service;

    //page, fromIuser, toIuser
    //page=1 > 방이 있음 > 대화 리스트 응답
    //       > 방이 없음 > 방만들고 > 빈 대화 리스트 응답
    //page>=2 > 대화 리스트 응답
    @GetMapping("/msg")
    @Operation(summary = "디엠 메시지 리스트", description = "채팅창 안에서 나타나는 메시지 리스트")
    public List<DmMsgSelVo> getDmMsgAll(DmMsgSelDto dto){
        return service.getMsgAll(dto);
    }

    @GetMapping
    @Operation(summary = "디엠 리스트", description = "해당 유저가 속한 디엠 리스트")
    public List<DmSelVo> getDmAll(DmSelDto dto){
        return service.getDmAll(dto);
    }

    @PostMapping("/msg")
    @Operation(summary = "디엠 메시지 작성", description = "디엠 메시지 작성 처리")
    public ResVo postDmMsg(@RequestBody DmMsgInsDto dto){
        return service.postDmMsg(dto);
    }

    @DeleteMapping("/msg")
    @Operation(summary = "디엠 메시지 삭제", description = "디엠 메시지 삭제 처리")
    public ResVo delDmMsg(DmMsgDelDto dto){
        return service.delDmMsg(dto);
    }
}
