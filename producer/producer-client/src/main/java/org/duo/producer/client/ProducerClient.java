package org.duo.producer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.duo.producer.common.ProductInfo;

import java.util.List;

@FeignClient(name = "producer-service", fallback = ProducerClient.ProducerClientFallback.class)
public interface ProducerClient {

    @PostMapping("/producer-service/getItemList")
    List<ProductInfo> getItemList(@RequestBody List<String> ids);

    @Component
    static class ProducerClientFallback implements ProducerClient {

        @Override
        public List<ProductInfo> getItemList(List<String> ids) {
            return null;
        }
    }
}