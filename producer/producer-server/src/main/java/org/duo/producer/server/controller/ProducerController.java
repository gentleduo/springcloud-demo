package org.duo.producer.server.controller;

import org.springframework.web.bind.annotation.*;
import org.duo.producer.common.ProductInfo;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/producer-service")
public class ProducerController {

    @GetMapping("/msg")
    public String msg() {
        return "this is product3' msg";
    }

    @PostMapping("/getItemList")
    public List<ProductInfo> getItemList(@RequestBody List<String> ids) {

        List<ProductInfo> items = new ArrayList<ProductInfo>();

//        for (String key : ids) {
//
//            if ("1".equals(key)) {
//                items.add(new ProductInfo(1,"one","this first attribute"));
//            } else if ("2".equals(key)) {
//                items.add(new ProductInfo(2,"two","this second attribute"));
//            } else if ("3".equals(key)) {
//                items.add(new ProductInfo(3,"three","this third attribute"));
//            }
//        }

//        items.add(new ProductInfo(1, "one", "this first attribute"));
//        items.add(new ProductInfo(2, "two", "this second attribute"));
        items.add(new ProductInfo(3, "three", "this third attribute"));
        return items;
    }
}
