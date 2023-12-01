package com.green.greengram3.feed;

import com.green.greengram3.common.ResVo;
import com.green.greengram3.feed.model.FeedCommentInsDto;
import com.green.greengram3.feed.model.FeedCommentSelVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/feed/comment")
@Tag(name="피드 댓글 API", description = "피드 댓글 관련 처리")
public class FeedCommentController {
    private final FeedCommentService service;

    @PostMapping
    @Operation(summary = "피드 댓글 작성", description = "유저가 피드에 댓글을 작성할 때<br>(ifeed: 피드 pk, iuser: 유저 pk, comment: 댓글 내용)")
    public ResVo postComment(@RequestBody FeedCommentInsDto dto){
        log.info("dto: {}", dto);
        return service.postComment(dto);
    }
    @GetMapping
    public List<FeedCommentSelVo> getFeedCommentAll(int ifeed){
        return service.getCommentAll(ifeed);
    }

}
