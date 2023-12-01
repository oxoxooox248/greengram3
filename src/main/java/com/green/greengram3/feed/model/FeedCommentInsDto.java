package com.green.greengram3.feed.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(title="피드 댓글 작성 데이터")
public class FeedCommentInsDto {
    private int ifeed;
    private int iuser;
    private String comment;
    @JsonIgnore
    private int ifeedComment;
}
