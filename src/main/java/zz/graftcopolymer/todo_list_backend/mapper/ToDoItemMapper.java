package zz.graftcopolymer.todo_list_backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import zz.graftcopolymer.todo_list_backend.po.ToDoItem;

import java.util.List;

@Mapper
public interface ToDoItemMapper extends BaseMapper<ToDoItem> {
    @Select("SELECT * FROM todo_item WHERE user_id=#{userId}")
    List<ToDoItem> selectByUserId(Integer userId);

    @Select("SELECT * FROM todo_item WHERE user_id=#{userId} AND finished=1")
    List<ToDoItem> selectFinishedByUserId(Integer userId);

    @Select("SELECT * FROM todo_item WHERE user_id=#{userId} AND finished=0")
    List<ToDoItem> selectUnfinishedByUserId(Integer userId);
}
