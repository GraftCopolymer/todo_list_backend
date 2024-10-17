package zz.graftcopolymer.todo_list_backend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("zz.graftcopolymer.todo_list_backend.mapper")
public class TodoListBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoListBackendApplication.class, args);
    }

}
