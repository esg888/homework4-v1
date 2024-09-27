package com.example.UsersNews.Mapper;

import com.example.UsersNews.Entity.Commentary;
import com.example.UsersNews.Service.UserService;
import com.example.UsersNews.Service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.UsersNews.web.CommentRequest;

public abstract class CommentMapperDelegate implements CommentMapper {

    @Autowired
    UserService userService;

    @Autowired
    ItemsService itemsService;

    @Override
    public Commentary requestToCommentary(Integer commentId, CommentRequest commentRequest) {
        Commentary comment = requestToCommentary(commentRequest);
        comment.setId(commentId);
        return comment;
    }

    @Override
    public Commentary requestToCommentary(CommentRequest commentRequest) {
        Commentary comment = new Commentary();
        comment.setText(commentRequest.getText());
        comment.setUser(userService.findById(commentRequest.getUserId()));
        comment.setItem(itemsService.findById(commentRequest.getItemId()));
        return comment;
    }
}
