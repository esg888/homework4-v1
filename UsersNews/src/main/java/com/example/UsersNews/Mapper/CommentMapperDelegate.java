package com.example.UsersNews.Mapper;

import com.example.UsersNews.Entity.Commentary;
import com.example.UsersNews.Repo.ItemRepo;
import com.example.UsersNews.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.UsersNews.web.CommentRequest;

public abstract class CommentMapperDelegate implements CommentMapper {

    @Autowired
    UserRepo userRepo;

    @Autowired
    ItemRepo itemRepo;

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
        comment.setUser(userRepo.findById(commentRequest.getUserId()));
        comment.setItem(itemRepo.findById(commentRequest.getItemId()));
        return comment;
    }
}
