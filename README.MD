一、基础环境依赖：
下载consul 1.4.4，运行start_consul.sh

下载zipkin server,命令:  curl -sSL https://zipkin.io/quickstart.sh | bash -s,
运行 start_zipkinserver.sh

二、
configserver  配置服务器， 使用github作为后端配置文件存储

authserver  授权服务器，使用jwt传递token

ssoclient1  ssoclient2  两个单点登录客户端

gateway  使用zuul 做网关,oauth2 sso做单点登录

gateway2  使用zuul 做网关，但不做单点登录，而是 作为资源服务器

service1  service2  分别为两个微服务，service1使用feign调用service2，其中service1使用feign拦截器传递token

service的feign客户端集成hystrix包装
 
configserver  和 service1  service2集成了spring cloud bus,在github更新文件后，可以直接访问任何一台服务器的/actuctor/bus_refresh端点，
刷新所有服务器配置，这里使用rabbitmq作为消息总线

service3   service4  只是作为普通的微服务来使用，但是不引入任何安全框架


-----------------------------------------------------------------------------------------------------------------------
目前看下来，虽然把每个服务都作为资源服务器来使用，能增加服务的安全性，但是处理起来非常复杂，ribbon和feign的token传递问题已经解决，
但是无法解决sleuth的服务跟踪问题 

而在网关层面解决安全问题，但是各个服务不做任何处理，这种方式虽然有内部风险，但是不用处理任何细节，基本可以实现透明调用，不过网关的安全处理必须格外小心，
还得当心任何内部服务器出现安全问题后被作为跳板的问题。



