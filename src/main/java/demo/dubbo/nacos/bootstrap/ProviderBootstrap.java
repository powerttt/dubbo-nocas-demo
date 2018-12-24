package demo.dubbo.nacos.bootstrap;


import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;

import java.io.IOException;

@EnableDubbo(scanBasePackages = "demo.dubbo.nacos.service")
@PropertySource(value = "classpath:/config/provider.properties")
public class ProviderBootstrap {

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //注册@Configuration config
        context.register(ProviderBootstrap.class);
        //启动上下文
        context.refresh();
        System.out.println(" service bootstrap ...");
        //持续执行
        System.in.read();
    }



}
