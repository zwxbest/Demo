SpringCloud eureka 服务宕机踢掉演示DEMO

版本信息：<br>
springboot 1.5.9<br>
springcloud Dalston.RC1<br>

贴重点配置：<br>
server:<br>
```aidl
eureka:
  instance:
    hostname: localhost
    prefer-ip-address: true
    instance-id: ${spring.cloud.client.ipAddress}:${server.port}
  client:
    register-with-eureka: true
    fetch-registry: false
    service-url:
      defaultZone: http://172.16.80.194:8888/eureka/
  server:
    ###自我保护机制关闭
    enable-self-preservation: false
    ## 清理间隔（单位毫秒，默认是60*1000）
    eviction-interval-timer-in-ms: 2000
```
client:<br>
```aidl
eureka:
  instance:
    hostname: localhost
    instance-id: ${spring.cloud.client.ipAddress}:${server.port}
    prefer-ip-address: true
    ##设置心跳的周期间隔(默认90s)[如果10s没响应默认服务宕机]
    lease-expiration-duration-in-seconds: 10
    #设置心跳时间间隔(默认30s)[心跳时间2s]
    lease-renewal-interval-in-seconds: 2
  client:
    serviceUrl:
      defaultZone: http://172.16.80.194:8888/eureka/
    #开启健康检查（需要spring-boot-starter-actuator依赖）
    healthcheck:
      enable: true
```
重点提示：<br>
**生产环境不建议这么搞**

 