package uz.pdp.appwarehouse.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Result {

    private String messege;
    private boolean success;
    private Object object;


    public Result(String messege, boolean success) {
        this.messege = messege;
        this.success = success;
    }
}
