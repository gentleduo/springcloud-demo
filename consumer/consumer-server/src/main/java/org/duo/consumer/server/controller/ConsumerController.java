package org.duo.consumer.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.duo.producer.client.ProducerClient;
import org.duo.producer.common.ProductInfo;

import java.util.List;

@RestController
@RequestMapping("/consumer-service")
public class ConsumerController {

    @Autowired
    private ProducerClient producerClient;

    @PostMapping("/getItemList")
    public List<ProductInfo> getItemList(@RequestBody List<String> ids) {

        return producerClient.getItemList(ids);
    }
}
