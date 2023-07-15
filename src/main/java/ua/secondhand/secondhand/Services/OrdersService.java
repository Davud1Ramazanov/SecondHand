package ua.secondhand.secondhand.Services;

import jakarta.persistence.criteria.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.secondhand.secondhand.Models.Orders;
import ua.secondhand.secondhand.Repositories.IOrdersRepository;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Service
public class OrdersService {
    private final IOrdersRepository ordersRepo;

    @Autowired
    public OrdersService(IOrdersRepository ordersRepo) {
        this.ordersRepo = ordersRepo;
    }

    public List<Orders> selectOrder() {
        return ordersRepo.findAll();
    }

    public Orders createOrder(Orders orders) {
        return ordersRepo.save(orders);
    }

    public Orders updateOrder(Orders orders, Integer id) {
        Orders order = ordersRepo.findById(id).orElseThrow(() -> new RuntimeException("Orders update error!"));
        order.setDate(orders.getDate());
        order.setTotal(orders.getTotal());
        order.setQuantity(orders.getQuantity());
        order.setProduct(orders.getProduct());

        return ordersRepo.save(order);
    }

    public void deleteOrder(Integer id) {
        ordersRepo.deleteById(id);
    }
}
