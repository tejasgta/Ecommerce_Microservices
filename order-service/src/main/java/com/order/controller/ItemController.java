package com.order.controller;

import com.order.entity.OrderItem;
import com.order.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping
    public ResponseEntity<List<OrderItem>> getItems(){
        return new ResponseEntity<>(itemService.getItems(), HttpStatus.OK) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity getItemById(@PathVariable Long id){
        Optional<OrderItem> order = itemService.getItemById(id);
        if(order.isPresent()){
            return new ResponseEntity<>(order.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Order with Id: "+id+" not found!", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<OrderItem> addItem(@RequestBody OrderItem orderItem){
        return new ResponseEntity<>(itemService.addItem(orderItem),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public String deleteItem(@PathVariable Long id){
        if(itemService.getItemById(id).isEmpty()){
            return "Order with Id: " + id + " not found";
        }
        else{
            itemService.deleteItem(id);
            return "Order with Id: " + id + " deleted successfully";
        }
    }

    @PutMapping("/{itemId}/order/{orderId}")
    public ResponseEntity addProductToOrder(@PathVariable Long itemId, @PathVariable Long orderId){
        if(itemService.addProductToOrder(itemId, orderId)){
            return new ResponseEntity<>("Item with Id: " + itemId + " added to order with Id: " + orderId,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Item with Id: " + itemId + " or order with Id: " + orderId + " not found!",HttpStatus.NOT_FOUND);
        }
    }


}
