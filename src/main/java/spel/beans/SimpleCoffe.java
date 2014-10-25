package spel.beans;

import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;

/**
 * Created by tomasz on 25.10.14.
 */

public class SimpleCoffe {

    @Value("#{'HomeMadeArabica'}")
    private String name;
    @Value("#{T(java.lang.Math).random() * 20.0}")
    private BigDecimal price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SimpleCoffe{" +
                "name='" + name + '\'' +
                ", price=" + price.setScale(2, BigDecimal.ROUND_HALF_DOWN) +
                " $}";
    }
}
