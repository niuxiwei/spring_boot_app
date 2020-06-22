package cn.sunline.config;

import cn.sunline.domain.User;
import cn.sunline.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;

import java.util.Collection;

/**
 * 路由器函数  配置
 */
@Configuration
public class RouterFunctionConfiguration {

    /**
     * Servlet
     *      请求接口：ServletRequest 或者  HttpServletRequest
     *      响应接口：ServletResponse 或者 HttpServletReponse
     * Spring 5.0 重新定义了服务请求和响应接口：
     *      请求接口：ServerRequest
     *      响应接口：ServerReponse
     *      即可支持Servlet规范，也可以支持自定义，比如Netty（Web Server）
     * 以本例：
     *      定义GET请求，并且返回所有的用户对象  URI：/person/find/all
     * Flux是0-N个对象集合
     * Mono是0-1个对象集合
     * Reactive中的Flux或者Mono 它是异步处理（非阻塞）
     * 集合对象基本上是同步处理（阻塞）
     * Flux  或者  Mono  都是 Publisher
     */
    /**
     * 通过方法参数注入
     * 注入的方式：
     * 1、字段注入
     * 2、properties注入
     * 3、set/get注入
     * 4、方法注入
     * 5、构造器注入
     */
    @Bean
    @Autowired
    public RouterFunction<ServerResponse> personFindAll(UserRepository userRepository){

        return RouterFunctions.route(RequestPredicates.GET("/person/find/all"),
                request -> {
                    //返回所有的用户对象
                    Collection<User> users = userRepository.findAll();
                    Flux<User> userFlux = Flux.fromIterable(users);
                    return ServerResponse.ok().body(userFlux,User.class);
                });
    }

}
