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
@PropertySource(value = "classpath:/config/consumer.properties")
public class ConsumerBootstrap {

    @Reference(version = "${demo.service.version}")
    EchoService echoService;

    @Reference(version = "${demo.service.version}")
    Demo1Service echoService1;

    @Reference(version = "${demo.service.version}")
    Demo2Service echoService2;

    @PostConstruct
    public void test(){
        System.out.println(echoService.echo("hollo dubbo"));
        System.out.println(echoService1.echo("hollo dubbo1"));
        System.out.println(echoService2.echo("hollo dubbo2"));

    }


    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ConsumerBootstrap.class);
        context.refresh();
        System.out.println("消费者启动...");
        System.in.read();
    }


}
