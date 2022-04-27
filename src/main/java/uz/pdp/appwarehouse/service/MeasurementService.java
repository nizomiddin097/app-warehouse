package uz.pdp.appwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwarehouse.entity.Measurement;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.repository.MeasurementRepository;

@Service
public class MeasurementService {
    @Autowired
    MeasurementRepository measurementRepository;

    public Result addMeasurementService(Measurement measurement){

        boolean existByName = measurementRepository.existsByName(measurement.getName());
        if (existByName){
//            Result result = new Result();
//            result.setMessege("Bunday o'lchov birligi mavjud");
//            result.setSuccess(false);
//            return result;

           return new Result("Bunday o'lchov birligi mavjud",false);
        }
        measurementRepository.save(measurement);


        return new Result("Muvaffaqiyatli saqlandi",true);
    }

}
