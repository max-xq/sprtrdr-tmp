package mi.sprtrdrd.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class TeamScore {
    private final Team team;
    private Integer score = 0;
}
