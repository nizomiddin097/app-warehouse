package uz.pdp.appwarehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appwarehouse.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
    boolean existsByFirstNameAndLastNameAndPhoneNumberAndCode(String firstName,String lastName,String phoneNumber,String code);

}
