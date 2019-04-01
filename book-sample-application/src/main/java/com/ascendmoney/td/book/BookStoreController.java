package com.ascendmoney.td.book;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookStoreController {

    @GetMapping("/store")
    public String storeDetail(){
        return "ok";
    }
}
