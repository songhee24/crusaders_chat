import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class UserID {
    long userId;
    String userLogin;
}
