package mi.sprtrdrd;

import mi.sprtrdrd.model.Board;

import java.util.concurrent.atomic.AtomicInteger;

public class SummaryService {
    public static String parseSummary(Board board) {
        var buffer = new StringBuffer();
        var counter = new AtomicInteger(1);
        board.readGameBoard().forEach((key, value) -> {
            buffer.append(counter.getAndIncrement());
            buffer.append(".");
            buffer.append(" ");
            buffer.append(value.getTeamHome().getTeam());
            buffer.append(" ");
            buffer.append(value.getTeamHome().getScore());
            buffer.append(" - ");
            buffer.append(value.getTeamGuest().getTeam());
            buffer.append(" ");
            buffer.append(value.getTeamGuest().getScore());
            if (counter.get()-1 != board.readGameBoard().size()) {
                buffer.append("\n");
            }
        });
        return buffer.toString();
    }
}
