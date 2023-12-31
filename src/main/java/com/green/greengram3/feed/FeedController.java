package com.green.greengram3.feed;

import com.green.greengram3.common.*;
import com.green.greengram3.feed.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/feed")
@Tag(name="피드 API", description = "피드 관련 처리")
public class FeedController {
    private final FeedService service;

    @PostMapping
    @Operation(summary = "피드 등록", description = "피드 등록 처리<br>(iuser: 유저 pk, contents: 내용, location: 위치, pics: 피드 사진)")
    public ResVo postFeed(@RequestBody FeedInsDto dto){return service.postFeed(dto);
    }

    @GetMapping
    @Operation(summary = "피드 리스트", description = "피드 리스트<br>(page: 페이지(=20), loginedIuser: 로그인한 유저 pk, targetIuser: 프로필 주인 유저pk)")
    public List<FeedSelVo> getFeedAll(FeedSelDto dto){
        log.info("dto: {}", dto);
        return service.getFeedAll(dto);
    }

    @GetMapping("/fav")
    @Operation(summary = "좋아요 처리", description = "토글로 처리함<br>(등록됨: result(1),취소됨: result(0))(iuser= 유저 pk, ifeed= 해당 피드 pk)")
    public ResVo toggleFav(FeedFavDto dto){
        return service.toggleFav(dto);
    }

    @DeleteMapping
    @Operation(summary = "피드 삭제", description = "피드 삭제 처리<br>(삭제됨: result(1),삭제 안됨: result(0))(iuser= 유저 pk, ifeed= 해당 피드 pk)")
    public ResVo delFeed(FeedDelDto dto){
        log.info("dto: {}", dto);
        return service.delFeed(dto);
    }
}
