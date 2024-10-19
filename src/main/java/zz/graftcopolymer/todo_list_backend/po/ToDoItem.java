package zz.graftcopolymer.todo_list_backend.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@TableName("todo_item")
public class ToDoItem {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private Integer finished;
    private String title;
    private LocalDateTime ddl;

    private Integer userId;

    public Map<String, Object> toJson(){
        Map json = new HashMap<>();
        json.put("itemId", id);
        json.put("finished", finished);
        json.put("title", title);
        if(ddl != null){
            json.put("ddl", ddl.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        }
        else{
            json.put("ddl", "");
        }
        return json;
    }
}
