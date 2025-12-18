package ynu.edu.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ynu.edu.entity.DeliveryAddress;
import ynu.edu.service.IDeliveryAddressService;

import java.util.List;

@RestController
@RequestMapping("/DeliveryAddressController")
@Tag(name = "送货地址管理", description = "送货地址相关操作")
@RequiredArgsConstructor
public class DeliveryAddressController {

    private final IDeliveryAddressService addressService;

    @PostMapping("/listDeliveryAddressByUserId")
    @Operation(summary = "查询用户送货地址", description = "根据用户编号查询所属送货地址")
    public ResponseEntity<List<DeliveryAddress>> listDeliveryAddressByUserId(
            @Parameter(description = "送货地址实体，需包含userId", required = true)
            @RequestBody DeliveryAddress deliveryAddress) throws Exception {
        List<DeliveryAddress> addresses = addressService.listDeliveryAddressByUserId(deliveryAddress.getUserId());
        return ResponseEntity.ok(addresses);
    }

    @PostMapping("/getDeliveryAddressById")
    @Operation(summary = "查询送货地址详情", description = "根据送货地址编号查询送货地址")
    public ResponseEntity<DeliveryAddress> getDeliveryAddressById(
            @Parameter(description = "送货地址实体，需包含daId", required = true)
            @RequestBody DeliveryAddress deliveryAddress) throws Exception {
        DeliveryAddress address = addressService.getDeliveryAddressById(deliveryAddress.getDaId());
        return ResponseEntity.ok(address);
    }

    @PostMapping("/saveDeliveryAddress")
    @Operation(summary = "添加送货地址", description = "向送货地址表中添加一条记录")
    public ResponseEntity<Integer> saveDeliveryAddress(
            @Parameter(description = "送货地址实体，需包含contactName、contactSex、contactTel、address、userId", required = true)
            @RequestBody DeliveryAddress deliveryAddress) throws Exception {
        int result = addressService.saveDeliveryAddress(deliveryAddress);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/updateDeliveryAddress")
    @Operation(summary = "更新送货地址", description = "根据送货地址编号更新送货地址信息")
    public ResponseEntity<Integer> updateDeliveryAddress(
            @Parameter(description = "送货地址实体，需包含daId、contactName、contactSex、contactTel、address", required = true)
            @RequestBody DeliveryAddress deliveryAddress) throws Exception {
        int result = addressService.updateDeliveryAddress(deliveryAddress);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/removeDeliveryAddress")
    @Operation(summary = "删除送货地址", description = "根据送货地址编号删除一条记录")
    public ResponseEntity<Integer> removeDeliveryAddress(
            @Parameter(description = "送货地址实体，需包含daId", required = true)
            @RequestBody DeliveryAddress deliveryAddress) throws Exception {
        int result = addressService.removeDeliveryAddress(deliveryAddress.getDaId());
        return ResponseEntity.ok(result);
    }
}