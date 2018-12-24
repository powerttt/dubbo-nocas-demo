package demo.dubbo.nacos.service.demo1;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.RpcContext;
import demo.dubbo.nacos.service.EchoService;

@Service(version = "${demo.service.version}")
public class DefaultDemo1Service implements Demo1Service {

    public String echo(String message) {
        RpcContext rpcContext = RpcContext.getContext();
        return String.format("Echo [port : %d] :  %s",
                rpcContext.getLocalPort(),
                message);
    }
}
