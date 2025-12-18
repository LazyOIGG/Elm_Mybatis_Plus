package ynu.edu.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ynu.edu.entity.Business;
import ynu.edu.service.IBusinessService;

import java.util.List;

@RestController
@RequestMapping("/BusinessController")
@Tag(name = "商家管理", description = "商家信息查询")
@RequiredArgsConstructor
public class BusinessController {

    private final IBusinessService businessService;

    @PostMapping("/listBusinessByOrderTypeId")
    @Operation(summary = "根据点餐分类查询商家", description = "根据点餐分类编号查询所属商家信息")
    public ResponseEntity<List<Business>> listBusinessByOrderTypeId(
            @Parameter(description = "商家实体，需包含orderTypeId", required = true)
            @RequestBody Business business) throws Exception {
        List<Business> businessList = businessService.listBusinessByOrderTypeId(business.getOrderTypeId());
        return ResponseEntity.ok(businessList);
    }

    @PostMapping("/getBusinessById")
    @Operation(summary = "根据商家ID查询商家信息", description = "根据商家编号查询商家信息")
    public ResponseEntity<Business> getBusinessById(
            @Parameter(description = "商家实体，需包含businessId", required = true)
            @RequestBody Business business) throws Exception {
        Business result = businessService.getBusinessById(business.getBusinessId());
        return ResponseEntity.ok(result);
    }
}