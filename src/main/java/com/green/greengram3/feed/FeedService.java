package com.green.greengram3.feed;

import com.green.greengram3.common.Const;
import com.green.greengram3.common.ResVo;
import com.green.greengram3.feed.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedService {
    private final FeedMapper mapper;
    private final FeedPicMapper picMapper;
    private final FeedFavMapper favMapper;
    private final FeedCommentMapper commentMapper;
    public ResVo postFeed(FeedInsDto dto){
        int affectedCnt= mapper.insFeed(dto);
        int affectedPicCnt= picMapper.insFeedPics(dto);
        return new ResVo(dto.getIfeed());
    }
    public List<FeedSelVo> getFeedAll(FeedSelDto dto){
        List<FeedSelVo> list= mapper.selFeedAll(dto);//피드 리스트 페이징 select 1번!
        FeedCommentSelDto fcDto= new FeedCommentSelDto();
        fcDto.setStartIdx(0);
        fcDto.setRowCount(4);
        for(FeedSelVo vo: list) {//한 페이지에 피드 20
            vo.setPics(picMapper.selFeedPics(vo.getIfeed()));
            //피드에 대한 사진 select 20번! -> 20+1 -> n+1
            fcDto.setIfeed(vo.getIfeed());
            List<FeedCommentSelVo> comments = commentMapper.selCommentAll(fcDto);
            if(comments.size()==Const.FEED_COMMENT_FIRST_CNT){
                vo.setIsMoreComment(1);
                comments.remove(comments.size()-1);
            }
            vo.setComments(comments);
        }
        return list;
    }

    public ResVo delFeed(FeedDelDto dto){
        int affectedPic= picMapper.delFeedPicAll(dto);
        if(affectedPic==0){return new ResVo(Const.FAIL);}
        int affectedfav= favMapper.delFavByIfeed(dto);
        int affectedComment= commentMapper.delCommentByIfeed(dto);
        int affectedFeed= mapper.delFeed(dto);
        return new ResVo(Const.SUCCESS);

    }
    public ResVo toggleFav(FeedFavDto dto){
        int affectedFavCnt= favMapper.delFav(dto);
        if(affectedFavCnt==1){return new ResVo(Const.FEED_FAV_DEL);}
        affectedFavCnt=favMapper.insFav(dto);
        return new ResVo(Const.FEED_FAV_ADD);
    }
}
