package zz.graftcopolymer.todo_list_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import zz.graftcopolymer.todo_list_backend.mapper.UserMapper;
import zz.graftcopolymer.todo_list_backend.model.DataRequest;
import zz.graftcopolymer.todo_list_backend.po.User;
import zz.graftcopolymer.todo_list_backend.vo.Result;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class AuthService {
    @Autowired
    private UserMapper userMapper;

    public Result register(DataRequest req){
        String username = req.getString("username");
        String password = req.getString("password");

        if(username == null || username.isEmpty()){
            return Result.error(-1, "请提供用户名");
        }
        if(password == null || password.isEmpty()){
            return Result.error(-1, "请提供密码");
        }

        User u = userMapper.selectByUsername(username);
        if(u != null){
            return Result.error(-1, "用户名已存在");
        }
        u = new User();
        u.setId(null);
        u.setUsername(username);
        u.setPassword(password);
        userMapper.insert(u);
        return Result.ok();
    }

    public Result login(DataRequest req){
        String username = req.getString("username");
        String password = req.getString("password");

        if(username == null || username.isEmpty()){
            return Result.error(-1, "请提供用户名");
        }
        if(password == null || password.isEmpty()){
            return Result.error(-1, "请提供密码");
        }

        User u = userMapper.selectByUsername(username);
        if(u == null){
            return Result.error(-1, "用户不存在");
        }
        if(!Objects.equals(u.getPassword(), password)){
            return Result.error(-1, "密码错误");
        }
        Map dataResult = new HashMap();
        dataResult.put("username", u.getUsername());
        dataResult.put("userId", u.getId());

        return Result.success(dataResult, "登录成功");
    }

    public Result modifyPassword(DataRequest req){
        Integer userId = req.getInteger("userId");
        String oldPassword = req.getString("oldPassword");
        String newPassword = req.getString("newPassword");

        if(userId == null){
            return Result.error(-1, "请提供用户ID");
        }
        User u = userMapper.selectById(userId);
        if(u == null){
            return Result.error(-1, "用户不存在");
        }

        if(!Objects.equals(oldPassword, u.getPassword())){
            return Result.error(-1, "旧密码不正确");
        }
        u.setPassword(newPassword);
        userMapper.updateById(u);
        return Result.ok();
    }
}
