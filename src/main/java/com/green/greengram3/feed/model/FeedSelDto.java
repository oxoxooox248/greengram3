package com.green.greengram3.feed.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.green.greengram3.common.Const;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


@Data
@Schema(title="피드 리스트 출력을 위한 데이터")
public class FeedSelDto {
    private int page;
    private int loginedIuser;
    @JsonIgnore
    private int startIdx;
    @JsonIgnore
    private int rowCount= Const.FEED_COUNT_PER_PAGE;

    public void setPage(int page){
        this.startIdx=(page-1)*rowCount;
    }
}
