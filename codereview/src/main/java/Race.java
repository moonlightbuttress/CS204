import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Race {
    private String name;

    public Race() {
    }

    /**
     * Generates a list of 6 ability scores from 9 to 18, inclusive
     * @return A list of 6 ability scores
     */
    public List<Integer> generateAbilityScores() {
        List<Integer> abilityScores = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int as = generateAbilityScore();
            abilityScores.add(as);
        }
        return abilityScores;
    }

    /**
     * Generates an ability score from 9 to 18
     * @return An int from 9 to 18, inclusive
     */
    private int generateAbilityScore() {
        Random random = new Random();
        return random.nextInt(9) + 9;
    }

    public String getName() {
        return name + " the amazing";
    }
}
