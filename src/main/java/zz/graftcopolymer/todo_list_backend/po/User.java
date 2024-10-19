package zz.graftcopolymer.todo_list_backend.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@TableName("user")
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String username;
    private String password;

    @TableField(exist = false)
    private List<ToDoItem> toDoItems = new ArrayList<>();
}
