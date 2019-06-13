# springboot

## 1、主程序类

### @SpringbootApplication注解


### logging配置

- logging.level需要配置在包层级上，否则会抛出ConverterNotFoundException异常，因为LoggingApplicationListener接收的是一个map对象，map中有包和对应日志打印级别

