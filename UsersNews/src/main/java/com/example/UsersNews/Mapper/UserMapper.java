package com.example.UsersNews.Mapper;

import com.example.UsersNews.Entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import com.example.UsersNews.web.UserListResponse;
import com.example.UsersNews.web.UserRequest;
import com.example.UsersNews.web.UserResponse;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {ItemMapper.class, CommentMapper.class})
public interface UserMapper {
User requestToUser (UserRequest request);
    @Mapping(source = "userId", target = "id")
    User requestToUser(Integer userId, UserRequest request);

    UserResponse userToResponse(User user);

    default UserListResponse userListResponseList(List<User> users) {
        UserListResponse response = new UserListResponse();
        response.setUsers(users.stream().map(this::userToResponse).collect(Collectors.toList()));
        return response;
    }

}
