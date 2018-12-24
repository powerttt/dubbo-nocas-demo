package demo.dubbo.nacos.service.demo2;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.RpcContext;

@Service(version = "${demo.service.version}")
public class DefaultDemo2Service implements Demo2Service {

    public String echo(String message) {
        RpcContext rpcContext = RpcContext.getContext();
        return String.format("Echo [port : %d] :  %s",
                rpcContext.getLocalPort(),
                message);
    }
}
