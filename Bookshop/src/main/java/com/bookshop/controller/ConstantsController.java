package com.bookshop.controller;

import com.bookshop.model.enums.BookingStatus;
import com.bookshop.model.enums.Role;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/constants")
public class ConstantsController {

    @GetMapping("/role")
    List<String> getRoles() {
        return Stream.of(Role.values()).map(Role::name).collect(Collectors.toList());
    }

    @GetMapping("/bookingStatus")
    List<String> getStatuses() {
        return Stream.of(BookingStatus.values()).map(BookingStatus::name).collect(Collectors.toList());
    }
}
