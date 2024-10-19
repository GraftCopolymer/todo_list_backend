package zz.graftcopolymer.todo_list_backend.handlerResolver;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
// 注册自定义解析器
public class ResolverConfig implements WebMvcConfigurer {
    @Autowired
    private CustomHandlerResolver customHandlerResolver;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers){
        resolvers.add(customHandlerResolver);
    }
}
