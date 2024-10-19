package zz.graftcopolymer.todo_list_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zz.graftcopolymer.todo_list_backend.model.DataRequest;
import zz.graftcopolymer.todo_list_backend.service.ToDoItemService;
import zz.graftcopolymer.todo_list_backend.vo.Result;

@RestController
@RequestMapping("/todo")
public class ToDoItemController {
    @Autowired
    private ToDoItemService toDoItemService;

    // 获取用户的所有ToDo项
    @PostMapping("/getAllItems")
    public Result getAllItems( DataRequest req){
        return toDoItemService.getAllItems(req);
    }

    // 获取用户未完成的待办项
    @PostMapping("/getUnfinishedItems")
    public Result getUnfinishedItems(DataRequest req){
        return toDoItemService.getUnfinishedItems(req);
    }

    // 获取用户已完成的所有待办项
    @PostMapping("/getFinishedItems")
    public Result getFinishedItems( DataRequest req){
        return toDoItemService.getFinishedItems(req);
    }

    // 添加ToDo项
    @PostMapping("/addItem")
    public Result addItem( DataRequest req){
        return toDoItemService.addItem(req);
    }

    // 完成某个待办项
    @PostMapping("/finishItem")
    public Result finishItem( DataRequest req){
        return toDoItemService.finishItem(req);
    }

    // 删除某个待办项
    @PostMapping("/deleteItem")
    public Result deleteItem(DataRequest req){
        return toDoItemService.deleteItem(req);
    }

    // 获取某个待办项的信息
    @PostMapping("/getItem")
    public Result getItem( DataRequest req){
        return toDoItemService.getItem(req);
    }
}
