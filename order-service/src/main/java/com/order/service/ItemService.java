package com.order.service;

import com.order.entity.Order;
import com.order.entity.OrderItem;
import com.order.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private OrderItemRepository itemRepository;

    @Autowired
    private OrderService orderService;

    public List<OrderItem> getItems() {
        return itemRepository.findAll();
    }


    public Optional<OrderItem> getItemById(Long id) {
        return itemRepository.findById(id);
    }

    public OrderItem addItem(OrderItem orderItem) {
        return itemRepository.save(orderItem);
    }

    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }

    public boolean addProductToOrder(Long itemId, Long orderId) {
        Optional<OrderItem> item = itemRepository.findById(itemId);
        if (item.isPresent()) {
            Optional<Order> order = orderService.getOrderById(orderId);
            if (order.isPresent()) {
                Order order1 = order.get();
                item.get().setOrder(order1);
                itemRepository.save(item.get());
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }
}
