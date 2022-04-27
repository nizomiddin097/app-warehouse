package uz.pdp.appwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwarehouse.entity.Warehouse;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.repository.WarehouseRepository;

import java.util.Optional;

@Service
public class WarehouseService {
    @Autowired
    WarehouseRepository warehouseRepository;

    public Result addWarehouse(Warehouse warehouse){
        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(warehouse.getId());
        if (optionalWarehouse.isPresent()){
            return new Result("Bunday ombor mavjud",false);
        }
        warehouseRepository.save(warehouse);
        return new Result("Muvaffaqiyatli saqlandi",true);
    }
}
