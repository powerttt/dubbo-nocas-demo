package demo.dubbo.nacos.bootstrap;


import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import demo.dubbo.nacos.service.EchoService;
import demo.dubbo.nacos.service.demo1.Demo1Service;
import demo.dubbo.nacos.service.demo2.Demo2Service;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;
import java.io.IOException;

@EnableDubbo()
@PropertySource(value = "classpath:/config/consumer1.properties")
public class Consumer1Bootstrap {

    @Reference(version = "${demo.service.version}")
    EchoService echoService;


    @PostConstruct
    public void test(){
        System.out.println(echoService.echo("hollo dubbo consumer demo 1 "));
    }


    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(Consumer1Bootstrap.class);
        context.refresh();
        System.out.println("消费者启动...");
        System.in.read();
    }


}
