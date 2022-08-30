package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private Integer id;
    private String name;
    private String password;
    private String email;
    private Integer winGame;
    private Integer loseGame;
}
