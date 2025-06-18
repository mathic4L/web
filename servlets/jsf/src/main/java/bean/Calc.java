package bean;

import lombok.Data;
import lombok.ToString;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;

@Data
@ToString
@ManagedBean // @Named
public class Calc implements Serializable {

    private Integer x;
    private Integer y;
    private String operationType;
    private Integer res;
    private boolean resReady;

    public void calculate() {
        switch (operationType) {
            case "sum":
                sum();
                break;
            case "sub":
                sub();
                break;
            case "mul":
                mul();
                break;
        }
        resReady = true;
    }

    public void sum() {
        res = x + y;
    }

    public void sub() {
        res = x - y;
    }

    public void mul() {
        res = x * y;
    }
}
