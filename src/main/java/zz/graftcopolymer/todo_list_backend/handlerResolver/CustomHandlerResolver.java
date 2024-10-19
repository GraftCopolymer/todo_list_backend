package zz.graftcopolymer.todo_list_backend.handlerResolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import zz.graftcopolymer.todo_list_backend.model.DataRequest;

import java.util.Map;
import java.util.Objects;

@Component
// 自定义参数解析器，让小朋友可以直接传Map，而不用多加一个"data"字段
public class CustomHandlerResolver implements HandlerMethodArgumentResolver {

    @Autowired
    private ObjectMapper mapper;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(DataRequest.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        Map<String, Object> data = (Map<String, Object>) mapper.readValue(Objects.requireNonNull(webRequest.getNativeRequest(HttpServletRequest.class)).getInputStream(), Map.class);
        if (data == null) {
            throw new IllegalArgumentException("请求体不能为空");
        }
        return new DataRequest(data);
    }
}
