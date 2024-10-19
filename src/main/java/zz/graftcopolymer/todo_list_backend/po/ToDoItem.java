package zz.graftcopolymer.todo_list_backend.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@TableName("todo_item")
public class ToDoItem {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private boolean finished;
    private String title;
}
