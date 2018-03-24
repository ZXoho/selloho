package com.cn.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.chrono.JapaneseChronology;
import java.util.List;

public interface OrderDetail extends JpaRepository<OrderDetail, String> {
    List<OrderDetail> findByOrderId(String orderId);
}
