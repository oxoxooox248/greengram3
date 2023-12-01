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
    @Operation(summary = "피드 등록", description = "피드 등록 처리 (iuser: 유저 pk, contents: 내용, location: 위치, pics: 피드 사진)")
    public ResVo postFeed(@RequestBody FeedInsDto dto){
        return service.postFeed(dto);
    }
    @GetMapping
    @Operation(summary = "피드 리스트", description = "피드 리스트(page: 페이지(=20))")
    public List<FeedSelVo> getFeedAll(int page){
        return service.getFeedAll(new FeedSelDto(page));
    }
    @GetMapping("/fav")
    @Operation(summary = "좋아요 처리", description = "토글로 처리함(등록됨: result(1),취소됨: result(0))(iuser= 유저 pk, ifeed= 해당 피드 pk)")
    public ResVo toggleFav(FeedFavDto dto){
        return service.toggleFav(dto);
    }
}
