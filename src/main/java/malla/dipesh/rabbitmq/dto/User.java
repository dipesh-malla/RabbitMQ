package malla.dipesh.rabbitmq.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {

    private int id;
    private String firstName;
    private String lastName;

}
