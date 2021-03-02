package movie;

public class War extends DVD {

    private final String title;
    private final String duration;
    private final String[] mainCharacters;

    private final String timePeriod;
    private final String[] countriesInvolved;

    public War(String title, String duration, String[] mainCharacters, String timePeriod, String[] countriesInvolved) {
        this.title = title;
        this.duration = duration;
        this.mainCharacters = mainCharacters;
        this.timePeriod = timePeriod;
        this.countriesInvolved = countriesInvolved;
    }

    @Override
    public String title() {
        return title;
    }

    @Override
    public String duration() {
        return duration;
    }

    @Override
    public String[] mainCharacters() {
        return mainCharacters;
    }

    public String getTimePeriod() {
        return timePeriod;
    }

    public String[] getCountriesInvolved() {
        return countriesInvolved;
    }

}
