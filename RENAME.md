# springboot

## 1、主程序类

### @SpringbootApplication注解


### logging配置

- logging.level需要配置在包层级上，否则会抛出ConverterNotFoundException异常，因为LoggingApplicationListener接收的是一个map对象，map中有包和对应日志打印级别

## 2、自定义springMvc配置

#### **在springboot 2.0以后 WebMvcConfigurerAdapter 这个方法已经过时，那怎么来修改呢？**

有两种方式：

第一种 ：继承WebMvcConfigurationSupport这个类，重写父类的方法即可。但是这种方式是有问题的，这种方式会屏蔽Spring Boot的@EnableAutoConfiguration中的设置。

原因：WebMvcAutoConfiguration会先判断如果不存在WebMvcConfigurationSupport类才会生效。

```java
@Configuration
@ConditionalOnWebApplication(
    type = Type.SERVLET
)
@ConditionalOnClass({Servlet.class, DispatcherServlet.class, WebMvcConfigurer.class})
@ConditionalOnMissingBean({WebMvcConfigurationSupport.class})
@AutoConfigureOrder(-2147483638)
@AutoConfigureAfter({DispatcherServletAutoConfiguration.class, ValidationAutoConfiguration.class})
public class WebMvcAutoConfiguration {
```

这时候启动项目时会发现映射根本没有成功，读取不到静态的资源也就是说application.properties中添加配置的映射配置没有启动作用，然后我们会想到重写来进行映射：

```java
@Configuration
public class myMvcConfig extends WebMvcConfigurationSupport{
 
    @Bean
    public WebMvcConfigurationSupport webMvcConfigurationSupport(){
        WebMvcConfigurationSupport support = new WebMvcConfigurationSupport(){
            @Override
            protected void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
                // registry.addViewController("/login.html").setViewName("login");
            }
 
            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                //registry.addResourceHandler("/resources/static/**").addResourceLocations("classpath:/static/");
                registry.addResourceHandler("/static/**").addResourceLocations("classpath:/resources/static/");
                super.addResourceHandlers(registry);
            }
        };
        return support;
    }
```

第二种：实现WebMvcConfigurer这个接口，（推荐使用这种）

```java
@Configuration
public class MyWebMvcConfigurationAdapter implements WebMvcConfigurer{
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/test").setViewName("success");
    }
}
```