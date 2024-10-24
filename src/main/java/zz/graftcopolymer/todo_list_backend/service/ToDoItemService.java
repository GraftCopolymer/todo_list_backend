package zz.graftcopolymer.todo_list_backend.service;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import zz.graftcopolymer.todo_list_backend.mapper.ToDoItemMapper;
import zz.graftcopolymer.todo_list_backend.mapper.UserMapper;
import zz.graftcopolymer.todo_list_backend.model.DataRequest;
import zz.graftcopolymer.todo_list_backend.po.ToDoItem;
import zz.graftcopolymer.todo_list_backend.po.User;
import zz.graftcopolymer.todo_list_backend.vo.Result;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ToDoItemService {
    @Autowired
    private ToDoItemMapper toDoItemMapper;
    @Autowired
    private UserMapper userMapper;

    public Result getAllItems(DataRequest req){
        Integer userId = req.getInteger("userId");
        if(userId == null){
            return Result.error(-1, "请提供用户ID");
        }
        User u = userMapper.selectById(userId);
        if(u == null){
            return Result.error(-1, "用户不存在");
        }
        List<ToDoItem> items = toDoItemMapper.selectByUserId(userId);
        List<Map> data = new ArrayList<>();
        for(ToDoItem i : items){
            data.add(i.toJson());
        }
        return Result.success(data, null);
    }

    public Result getUnfinishedItems(DataRequest req){
        Integer userId = req.getInteger("userId");
        if(userId == null){
            return Result.error(-1, "请提供用户ID");
        }
        User u = userMapper.selectById(userId);
        if(u == null){
            return Result.error(-1, "用户不存在");
        }
        List<ToDoItem> unfinishedItems = toDoItemMapper.selectUnfinishedByUserId(userId);
        List<Map> data = new ArrayList<>();
        for(ToDoItem i : unfinishedItems){
            data.add(i.toJson());
        }

        return Result.success(data,null);
    }

    public Result getFinishedItems(DataRequest req){
        Integer userId = req.getInteger("userId");
        if(userId == null){
            return Result.error(-1, "请提供用户ID");
        }
        User u = userMapper.selectById(userId);
        if(u == null){
            return Result.error(-1, "用户不存在");
        }
        List<ToDoItem> finishedItems = toDoItemMapper.selectFinishedByUserId(userId);
        List<Map> data = new ArrayList<>();
        for(ToDoItem i : finishedItems){
            data.add(i.toJson());
        }
        return Result.success(data, null);
    }

    public Result addItem(DataRequest req){
        Integer userId = req.getInteger("userId");
        String title = req.getString("title");
        String ddl = req.getString("ddl");

        if(userId == null){
            return Result.error(-1, "请提供用户ID");
        }
        User u = userMapper.selectById(userId);
        if(u == null){
            return Result.error(-1, "用户不存在");
        }

        if(title == null || title.isEmpty()){
            return Result.error(-1, "请提供待办项标题");
        }
        LocalDate dateTime;
        System.out.println(ddl);
        try{
            if (ddl == null || ddl.isEmpty()){
                dateTime = null;
            }
            else{
                dateTime = LocalDate.parse(ddl, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            }
        }
        catch (DateTimeParseException e){
            e.printStackTrace();
            return Result.error(-1, "日期格式不正确");
        }
        ToDoItem item = new ToDoItem();
        item.setId(null);
        item.setUserId(userId);
        item.setTitle(title);
        item.setFinished(0);
        item.setDdl(dateTime);

        Map data = new HashMap<>();
        data.put("itemId", item.getId());
        return Result.success(data, "保存成功");
    }

    public Result finishItem(DataRequest req){
        Integer itemId = req.getInteger("itemId");
        if(itemId == null){
            return Result.error(-1, "请提供待办项ID");
        }
        ToDoItem item = toDoItemMapper.selectById(itemId);
        if(item == null){
            return Result.error(-1, "待办项不存在");
        }
        item.setFinished(1);
        toDoItemMapper.updateById(item);

        return Result.ok();
    }

    public Result deleteItem(DataRequest req){
        Integer itemId = req.getInteger("itemId");
        if(itemId == null){
            return Result.error(-1, "请提供待办项ID");
        }
        ToDoItem item = toDoItemMapper.selectById(itemId);
        if(item == null){
            return Result.error(-1, "删除失败，待办项不存在");
        }

        toDoItemMapper.deleteById(item);
        return Result.ok();
    }

    public Result getItem(DataRequest req){
        Integer itemId = req.getInteger("itemId");
        if(itemId == null){
            return Result.error(-1, "请提供待办项ID");
        }
        ToDoItem item = toDoItemMapper.selectById(itemId);
        if(item == null){
            return Result.error(-1, "删除失败，待办项不存在");
        }

        return Result.success(item.toJson(), null);
    }
}
