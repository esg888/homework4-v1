package com.example.UsersNews.Controller;
import com.example.UsersNews.Entity.Item;
import com.example.UsersNews.web.CommentRequest;
import com.example.UsersNews.web.ItemRequest;
import com.example.UsersNews.web.ItemResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.UsersNews.Mapper.ItemMapper;
import com.example.UsersNews.web.ItemListResponse;
import com.example.UsersNews.Service.ItemsService;
import java.util.List;

@RestController
@RequestMapping("/api/item")
@RequiredArgsConstructor
public class ItemController {
    
    private final ItemMapper itemMapper;
    private final ItemsService itemsService;
    
    @GetMapping
    public ResponseEntity<ItemListResponse> findAll(){
        List<Item> items = itemsService.findAll();
      return ResponseEntity.ok(itemMapper.itemListToResponseList(items));
    }

    @GetMapping("/{id}")
    public ResponseEntity <ItemResponse> findById (@PathVariable Integer id) {
        return ResponseEntity.ok(itemMapper.itemToResponse(itemsService.findById(id)));
    }

@PostMapping
   public  ResponseEntity <ItemResponse> create (@RequestBody ItemRequest request) {
Item item = itemsService.save(itemMapper.requestToItem(request));
       return ResponseEntity.status(HttpStatus.CREATED).body(itemMapper.itemToResponse(item));
   }

@PutMapping("/{id}")
    public ResponseEntity <ItemResponse> update (@PathVariable("id")
     Integer itemId, @RequestBody ItemRequest request){
Item upItem = itemsService.update(itemMapper.requestToItem(itemId, request));
        return ResponseEntity.ok(itemMapper.itemToResponse(upItem));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        itemsService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
