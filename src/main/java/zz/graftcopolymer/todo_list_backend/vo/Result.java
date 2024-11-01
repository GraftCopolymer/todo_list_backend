package zz.graftcopolymer.todo_list_backend.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private Integer code;
    private Object data;
    private String msg;

    public static Result success(Object data, String msg){
        return new Result(200, data, msg);
    }

    public static Result ok(){
        return new Result(200, null, null);
    }

    public static Result error(Integer code, String msg){
        return new Result(code, null, msg);
    }
}
