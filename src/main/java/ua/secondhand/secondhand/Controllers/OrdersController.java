package ua.secondhand.secondhand.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.secondhand.secondhand.Models.Orders;
import ua.secondhand.secondhand.Services.OrdersService;

import java.util.List;

@RestController
@RequestMapping("/Orders")
public class OrdersController {
    private final OrdersService ordersService;

    @Autowired
    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @GetMapping("/Select")
    public ResponseEntity<List<Orders>> selectOrder() {
        List<Orders> orders = ordersService.selectOrder();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @PostMapping("/Save")
    public ResponseEntity<Orders> createOrder(@RequestBody Orders orders) {
        Orders order = ordersService.createOrder(orders);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PostMapping("/Update/{id}")
    public ResponseEntity<Orders> updateOrder(@PathVariable Integer id, @RequestBody Orders orders) {
        Orders order = ordersService.updateOrder(orders, id);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PostMapping("/Delete/{id}")
    public void deleteOrder(@PathVariable Integer id) {
        ordersService.deleteOrder(id);
    }
}
