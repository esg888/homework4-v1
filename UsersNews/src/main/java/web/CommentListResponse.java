package web;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CommentListResponse {
    private List <CommentResponse> commentarys = new ArrayList<>();

}
