package ynu.edu.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ynu.edu.entity.User;
import ynu.edu.service.IUserService;

@RestController
@RequestMapping("/UserController")
@Tag(name = "用户管理", description = "用户登录、注册、信息管理")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;

    @PostMapping("/getUserByIdByPass")
    @Operation(summary = "用户登录", description = "根据用户编号与密码查询用户信息")
    public ResponseEntity<User> getUserByIdByPass(
            @Parameter(description = "用户实体，需包含userId和password", required = true)
            @RequestBody User user) throws Exception {
        User result = userService.getUserByIdByPass(user);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/getUserById")
    @Operation(summary = "检查用户是否存在", description = "根据用户编号查询用户表返回的行数")
    public ResponseEntity<Integer> getUserById(
            @Parameter(description = "用户实体，需包含userId", required = true)
            @RequestBody User user) throws Exception {
        int result = userService.getUserById(user.getUserId());
        return ResponseEntity.ok(result);
    }

    @PostMapping("/saveUser")
    @Operation(summary = "用户注册", description = "向用户表中添加一条记录")
    public ResponseEntity<Integer> saveUser(
            @Parameter(description = "用户实体，需包含userId、password、userName、userSex", required = true)
            @RequestBody User user) throws Exception {
        int result = userService.saveUser(user);
        return ResponseEntity.ok(result);
    }
}