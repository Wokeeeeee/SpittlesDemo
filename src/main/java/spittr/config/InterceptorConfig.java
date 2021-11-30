package spittr.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 注册拦截器
 * 拦截器config
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SpitterIntercepter()).addPathPatterns("/spittles");
        registry.addInterceptor(new ManagerInercepter()).addPathPatterns("/manager/**").addPathPatterns("/checking").excludePathPatterns("/manager/login");
    }
}
