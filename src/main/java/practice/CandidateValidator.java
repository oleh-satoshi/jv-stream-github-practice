package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int ALLOWED_AGE = 35;
    private static final int LIVING_PERIOD = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final String REGEX_CONDITION = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= ALLOWED_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.isAllowedToVote()
                && calculatePeriodInUkraine(candidate.getPeriodsInUkr()) >= LIVING_PERIOD;
    }

    private int calculatePeriodInUkraine(String periodInUkraine) {
        String[] years = periodInUkraine.split("REGEX_CONDITION");
        return Integer.parseInt(years[1]) - Integer.parseInt(years[0]);
    }
}
