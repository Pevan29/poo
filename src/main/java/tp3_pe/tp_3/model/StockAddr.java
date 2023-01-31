package tp3_pe.tp_3.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.sql.Date;


@Entity
public class StockAddr {
    @Id
    @GeneratedValue
    private String addr;

    public String getAddr() {
        return addr;
    }
    public void setAddr(String addr) {
        this.addr = addr;
    }




}
