一、基础环境依赖：
下载consul 1.4.4，运行start_consul.sh

下载zipkin server,命令:  curl -sSL https://zipkin.io/quickstart.sh | bash -s,
运行 start_zipkinserver.sh

二、
configserver  配置服务器， 使用github作为后端配置文件存储

authserver  授权服务器，使用jwt传递token

ssoclient1  ssoclient2  两个单点登录客户端

gateway  使用zuul 做网关

service1  service2  分别为两个微服务，service1使用feign调用service2，其中service1使用feign拦截器传递token

service的feign客户端集成hystrix包装
 
configserver  和 service1  service2集成了spring cloud bus,在github更新文件后，可以直接访问任何一台服务器的/actuctor/bus_refresh端点，
刷新所有服务器配置，这里使用rabbitmq作为消息总线

