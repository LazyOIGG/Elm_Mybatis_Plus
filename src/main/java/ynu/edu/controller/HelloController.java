package ynu.edu.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/hello")
@Tag(name = "测试控制器", description = "用于测试系统和API基本功能的控制器")
public class HelloController {

    @GetMapping(value = "/say")
    @Operation(
            summary = "GET请求测试",
            description = "这是一个简单的GET接口测试，用于验证Spring Boot应用是否正常运行"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "请求成功"),
            @ApiResponse(responseCode = "500", description = "服务器内部错误")
    })
    public String hello() {
        return "Hello Spring Boot!";
    }

    @PostMapping(value = "/say")
    @Operation(
            summary = "POST请求测试",
            description = "这是一个简单的POST接口测试，演示如何接收和处理POST请求"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "请求处理成功"),
            @ApiResponse(responseCode = "400", description = "请求参数错误"),
            @ApiResponse(responseCode = "500", description = "服务器内部错误")
    })
    public String post(
            @Parameter(
                    description = "测试参数",
                    example = "test",
                    required = false
            )
            @RequestParam(value = "param", required = false) String param
    ) {
        if (param != null && !param.isEmpty()) {
            return "已收到POST请求，参数: " + param;
        }
        return "已收到POST请求，无参数";
    }

    @GetMapping("/echo/{message}")
    @Operation(
            summary = "路径参数测试",
            description = "演示如何使用路径参数，返回接收到的消息"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "成功返回消息"),
            @ApiResponse(responseCode = "404", description = "路径参数缺失")
    })
    public String echo(
            @Parameter(
                    description = "要返回的消息",
                    example = "你好世界",
                    required = true
            )
            @PathVariable String message
    ) {
        return "你发送的消息是: " + message;
    }

    @GetMapping("/health")
    @Operation(
            summary = "健康检查接口",
            description = "用于检查系统是否正常运行，常用于监控和负载均衡器健康检查"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "系统运行正常")
    })
    public String healthCheck() {
        return "{\"status\":\"UP\",\"timestamp\":\"" + System.currentTimeMillis() + "\"}";
    }

    @GetMapping("/version")
    @Operation(
            summary = "获取系统版本",
            description = "返回当前系统的版本信息和状态"
    )
    public String getVersion() {
        return "{\"name\":\"饿了么外卖系统\",\"version\":\"v1.0.0\",\"status\":\"running\",\"timestamp\":\"" +
                System.currentTimeMillis() + "\"}";
    }
}
