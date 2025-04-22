package mi.sprtrdrd.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
@EqualsAndHashCode
public class TeamScore {
    private final Team team;
    @EqualsAndHashCode.Exclude private Integer score = 0;
}
