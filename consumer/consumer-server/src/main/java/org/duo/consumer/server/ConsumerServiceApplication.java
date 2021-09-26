package org.duo.consumer.server;

import org.duo.consumer.server.config.CustomLoadBalancerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Spring Cloud 2020.0.0版本以后对Spring Cloud NetFlix 组件进行剔除，仅保留了Eureka组件，其核心组件 Hystrix、Ribbon、Zuul、Archaius 等均进入维护状态
 * 旧版本的spring-cloud-netflix-dependencies管理着Netflix所有组件，包括Hystrix、Ribbon、Zuul、Eureka等。而自2020.0版本起，它有且只管理Eureka（包括Server和Client）
 * 其中Feign虽然最初属Netflix公司，但从9.x版本开始就移交给OpenFeign组织管理了，因此不再划入Netflix管辖范畴。
 * 简单一句话概括：Spring Cloud 2020.0.0版本彻底删除掉了Netflix除Eureka外的所有组件
 * Spring Cloud 既然把 Netflix 套件大刀阔斧的砍掉了，那总归得有替代方案吧。那是必然的，Spring Cloud 团队给我们推荐了用于替代的组件：
 * <p>
 * Netflix	                    推荐替代品	                                             说明
 * Hystrix	                    Resilience4j	                                         Hystrix自己也推荐你使用它代替自己
 * Hystrix Dashboard / Turbine	Micrometer + Monitoring System	                         说白了，监控这件事交给更专业的组件去做
 * Ribbon	                    Spring Cloud Loadbalancer	                             忍不住了，Spring终究亲自出手
 * Zuul 1	                    Spring Cloud Gateway	                                 忍不住了，Spring终究亲自出手
 * Archaius 1                   Spring Boot外部化配置 + Spring Cloud配置	                 比Netflix实现的更好、更强大
 * <p>
 * Spring Cloud LoadBalancer 目前仅支持轮询负载均衡策略，默认是用轮询，假如想使用随机或者自定义负载均衡策略，就不能按照以前使用ribbon的模式（注入IRule类，必须引入ribbon依赖），那么如果我使用Loadbalancer的随机负载均衡，要怎么设置呢
 * 1.把官方的@Bean方法拷贝到自己的配置类
 * @Configuration
 * public class CustomLoadBalancerConfiguration {
 *     @Bean
 *     ReactorLoadBalancer<ServiceInstance> randomLoadBalancer(Environment environment,
 *             LoadBalancerClientFactory loadBalancerClientFactory) {
 *         String name = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
 *         return new RandomLoadBalancer(loadBalancerClientFactory
 *             .getLazyProvider(name, ServiceInstanceListSupplier.class),
 *             name);
 *     }
 * }
 * 2.在启动类，使用@LoadBalancerClient或者@LoadBalancerClients注解，加载自己的配置类，由此切换loadBalancer默认的负载均衡策略
 */
@EnableFeignClients(basePackages = "org.duo")
@SpringBootApplication
@EnableDiscoveryClient
//@EnableFeignClients
@LoadBalancerClients(defaultConfiguration = CustomLoadBalancerConfiguration.class)
//@ComponentScan(basePackages = "org.duo")
public class ConsumerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerServiceApplication.class, args);
    }
}
