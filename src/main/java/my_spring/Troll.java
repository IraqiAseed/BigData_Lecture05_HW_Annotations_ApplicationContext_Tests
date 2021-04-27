package my_spring;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Troll {

    @my_spring.InjectRandomInt(min = 10,max = 20)
    private int power;

}
