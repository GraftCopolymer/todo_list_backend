package zz.graftcopolymer.todo_list_backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import zz.graftcopolymer.todo_list_backend.po.ToDoItem;

@Mapper
public interface ToDoItemMapper extends BaseMapper<ToDoItem> {

}
