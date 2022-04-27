package uz.pdp.appwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwarehouse.controller.CurrencyController;
import uz.pdp.appwarehouse.entity.Currency;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.repository.CurrencyRepository;

@Service
public class CurrencyService {
    @Autowired
    CurrencyRepository currencyRepository;

    public Result addCurrency(Currency currency){
        boolean existsByName = currencyRepository.existsByName(currency.getName());
        if (existsByName){
            return new Result("Bunday valyuta mavjud",false);
        }
        currencyRepository.save(currency);
        return new Result("Muvaffaqiyatli saqlandi",true);
    }
}
