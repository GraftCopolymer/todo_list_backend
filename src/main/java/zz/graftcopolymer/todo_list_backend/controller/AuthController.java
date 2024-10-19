package zz.graftcopolymer.todo_list_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zz.graftcopolymer.todo_list_backend.model.DataRequest;
import zz.graftcopolymer.todo_list_backend.service.AuthService;
import zz.graftcopolymer.todo_list_backend.vo.Result;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public Result register( DataRequest req){
        return authService.register(req);
    }

    @PostMapping("login")
    public Result login( DataRequest req){
        return authService.login(req);
    }

    // 修改密码
    @PostMapping("/modifyPassword")
    public Result modifyPassword( DataRequest req){
        return authService.modifyPassword(req);
    }

}
