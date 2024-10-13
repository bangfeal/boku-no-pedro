import java.util.ArrayList;
import java.util.List;

public class Choice {
    List<Object> contents = new ArrayList<>();

    // Might change to a list of effects
    List<Object> effect0 = new ArrayList<>();
    List<Object> effect1 = new ArrayList<>();

    Choice(List<Object> contents, List<Object> effect0, List<Object> effect1) {
        this.contents = contents;
        this.effect0 = effect0;
        this.effect1 = effect1;
    }
}
