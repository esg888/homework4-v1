package com.example.UsersNews.Mapper;


import com.example.UsersNews.Entity.Item;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import com.example.UsersNews.web.ItemListResponse;
import com.example.UsersNews.web.ItemRequest;
import com.example.UsersNews.web.ItemResponse;

import java.util.List;
@DecoratedWith(ItemMapperDelegate.class)
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ItemMapper {

    Item requestToItem (ItemRequest itemRequest);

    @Mapping(source = "itemId", target = "id")
    Item requestToItem (Integer itemId, ItemRequest itemRequest);

    ItemResponse itemToResponse(Item item);

    List<ItemResponse> itemListToItemResponseList (List<Item> items);

default ItemListResponse itemListToResponseList(List<Item> items)
{
    ItemListResponse response = new ItemListResponse();
    response.setItems(itemListToItemResponseList(items));
    return response;
}

}
