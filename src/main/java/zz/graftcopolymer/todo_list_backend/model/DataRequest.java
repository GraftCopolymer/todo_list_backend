package zz.graftcopolymer.todo_list_backend.model;

import jdk.jfr.StackTrace;
import lombok.*;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataRequest {
    private Map<String, Object> data;

    public String getString(String key){
        return (String) data.get(key);
    }

    public Integer getInteger(String key){
        return (Integer) data.get(key);
    }

    public Boolean getBoolean(String key){
        return (Boolean) data.get(key);
    }

}
