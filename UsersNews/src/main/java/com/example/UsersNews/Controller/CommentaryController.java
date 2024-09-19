package com.example.UsersNews.Controller;
import com.example.UsersNews.Mapper.CommentMapper;
import com.example.UsersNews.Service.CommentaryService;
import com.example.UsersNews.different.PageFilter;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import com.example.UsersNews.web.CommentListResponse;
import com.example.UsersNews.web.CommentResponse;
import com.example.UsersNews.web.CommentRequest;
import com.example.UsersNews.Entity.Commentary;

@RestController
@RequestMapping("/api/comm")
@RequiredArgsConstructor
public class CommentaryController {
    
    private final CommentaryService commentaryService;
    private final CommentMapper commentMapper;
    
    @GetMapping
    public ResponseEntity <CommentListResponse> findAll(@Valid PageFilter pageFilter) {
        return ResponseEntity.ok(commentMapper.commentListToCommentListResponse(commentaryService.findAll(pageFilter)));
    }
    
     @GetMapping("/{id}")
     public ResponseEntity <CommentResponse> findById (@PathVariable Integer id)  {
         return ResponseEntity.ok(commentMapper.commentToResponse(commentaryService.findById(id)));
     }
     
      @PostMapping
      public ResponseEntity <CommentResponse> create (@RequestBody CommentRequest request) {
          Commentary commentary = commentaryService.save(commentMapper.requestToCommentary(request));
          return ResponseEntity.status(HttpStatus.CREATED).body(commentMapper.commentToResponse(commentary));
                }
      
       @PutMapping("/{id}")
       public ResponseEntity<CommentResponse> update (@PathVariable("id") Integer commentaryId, @RequestBody CommentRequest request) {
           Commentary ucomm = commentaryService.update(commentMapper.requestToCommentary(commentaryId, request));
           return ResponseEntity.ok(commentMapper.commentToResponse(ucomm));
       }
      
       @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        commentaryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
}
