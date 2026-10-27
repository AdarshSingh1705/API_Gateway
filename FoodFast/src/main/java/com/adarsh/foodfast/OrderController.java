package com.adarsh.foodfast;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @GetMapping({"", "/**"})
    public Map<String, Object> listOrders() {
        return Map.of("service", "FoodFast", "orders", List.of());
    }

    @PostMapping({"", "/**"})
    public ResponseEntity<Map<String, Object>> createOrder(@RequestBody Map<String, Object> order) {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("service", "FoodFast");
        response.put("status", "accepted");
        response.put("order", order);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
