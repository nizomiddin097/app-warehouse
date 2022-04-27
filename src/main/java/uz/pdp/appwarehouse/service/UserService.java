package uz.pdp.appwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwarehouse.entity.User;
import uz.pdp.appwarehouse.entity.Warehouse;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.payload.UserDto;
import uz.pdp.appwarehouse.repository.UserRepository;
import uz.pdp.appwarehouse.repository.WarehouseRepository;

import java.util.Optional;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    WarehouseRepository warehouseRepository;

    public Result addUser(UserDto userDto) {

        boolean existsByFirstNameAndLastNameAndPhoneNumberAndCode = userRepository.existsByFirstNameAndLastNameAndPhoneNumberAndCode(userDto.getFirstName(), userDto.getLastName(), userDto.getPhoneNumber(), userDto.getCode());
        if (existsByFirstNameAndLastNameAndPhoneNumberAndCode) {
            return new Result("Bunday user tizimda mavjud", false);
        }

        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(userDto.getWarehouseId());
        if (optionalWarehouse.isPresent()){

            Warehouse warehouse = optionalWarehouse.get();
            User user = new User();
            user.setFirstName(userDto.getFirstName());
            user.setLastName(userDto.getLastName());
            user.setPhoneNumber(userDto.getPhoneNumber());
            user.setCode(userDto.getCode());
            user.setPassword(userDto.getPassword());
            user.setWarehouses((Set<Warehouse>) warehouse);
            userRepository.save(user);
            return new Result("Muvaffaqiyatli saqlandi",true);
        }
        return new Result("Xatolik",false);

    }
}
