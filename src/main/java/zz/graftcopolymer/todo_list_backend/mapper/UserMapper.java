package zz.graftcopolymer.todo_list_backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import zz.graftcopolymer.todo_list_backend.po.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("SELECT * FROM user where username=#{username}")
    User selectByUsername(String username);
}
