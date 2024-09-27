package com.example.UsersNews.Controller;
import com.example.UsersNews.Entity.Item;

import com.example.UsersNews.different.PageFilter;
import com.example.UsersNews.valid.PageFilterValid;
import com.example.UsersNews.web.ItemRequest;
import com.example.UsersNews.web.ItemResponse;
import jakarta.validation.Valid;
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
    public ResponseEntity<ItemListResponse> findAll(@Valid PageFilter pageFilter){
        List<Item> items = itemsService.findAll(pageFilter);
      return ResponseEntity.ok(itemMapper.itemListToResponseList(items));
    }

    @GetMapping("/filter")
    public ResponseEntity<ItemListResponse> filterBy(@Valid PageFilter pageFilter) {
        return ResponseEntity.ok(itemMapper.itemListToResponseList(itemsService.findFilter(pageFilter)));
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

@PutMapping("/{idItem}")
    public ResponseEntity <ItemResponse> update (@PathVariable("idItem")
     Integer itemId, @RequestBody ItemRequest request, Integer ownerId){
Item upItem = itemsService.update(itemMapper.requestToItem(itemId, request), ownerId);
        return ResponseEntity.ok(itemMapper.itemToResponse(upItem));
    }

//    @PutMapping("/{id}")
//    public ResponseEntity <ItemResponse> update (@PathVariable("id")
//                                                 Integer itemId, @RequestBody ItemRequest request){
//        Item upItem = itemsService.update(itemMapper.requestToItem(itemId, request));
//        return ResponseEntity.ok(itemMapper.itemToResponse(upItem));
//    }

    @DeleteMapping("/{idItem}")
    public ResponseEntity<Void> delete(@PathVariable Integer idItem, Integer ownerId){
        itemsService.delete(idItem, ownerId);
        return ResponseEntity.noContent().build();
    }

}
