package com.example.UsersNews.Mapper;


import com.example.UsersNews.Entity.Commentary;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import com.example.UsersNews.web.CommentListResponse;
import com.example.UsersNews.web.CommentRequest;
import com.example.UsersNews.web.CommentResponse;

import java.util.List;

@DecoratedWith(CommentMapperDelegate.class)
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CommentMapper {

    Commentary requestToCommentary(CommentRequest commentRequest);

    @Mapping(source = "commentaryId", target = "id")
    Commentary requestToCommentary(Integer commentaryId, CommentRequest commentRequest);

    CommentResponse commentToResponse (Commentary commentary);
List<CommentResponse> commentListToReponseList (List<Commentary> commentarys);

default CommentListResponse commentListToCommentListResponse (List<Commentary> commentarys)
{
    CommentListResponse responseList = new CommentListResponse();
    responseList.setCommentarys(commentListToReponseList(commentarys));
    return responseList;
}
}
