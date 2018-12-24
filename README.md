## dubbo + nacos





```
└─src
    ├─main
    │  ├─java
    │  │  └─demo
    │  │      └─dubbo
    │  │          └─nacos
    │  │              ├─bootstrap（启动类）
    │  │              └─service（远程接口）
    │  │                  ├─demo1
    │  │                  └─demo2
    │  └─resources
    │      └─config
    └─test
        └─java
```

______

### 启动类对应的数字对应着相同的接口，此项目测试一个cosumer对多个provider，并且dubbo的负载均衡也有点体现

### 包依赖不是太多，可以在在[小马哥的github](https://github.com/mercyblitz/dubbo-registry-nacos)中找到，进行本地编译，pom里加了注释

