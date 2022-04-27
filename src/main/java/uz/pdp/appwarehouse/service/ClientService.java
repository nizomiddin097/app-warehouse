package uz.pdp.appwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwarehouse.entity.Client;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.repository.ClientRepository;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    public Result addClient(Client client) {
        boolean existsByName = clientRepository.existsByNameAndPhoneNumber(client.getName(), client.getPhoneNumber());
        if (existsByName) {
                return new Result("Bunday client mavjud", false);
        }
        clientRepository.save(client);
        return new Result("Muvaffaqiyatli saqlandi", true);

    }

}
