package dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ReadUserDto {

    Integer id;
    String name;
    String email;
    Integer winGame;
    Integer loseGame;

    @Override
    public String toString() {
        return "ReadUserDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", winGame=" + winGame +
                ", loseGame=" + loseGame +
                '}';
    }
}
