package movie;

public class Action extends DVD {

    private final String title;
    private final String subgenre;
    private final String duration;
    private final String[] mainCharacters;

    public Action(String title, String subgenre, String duration, String[] mainCharacters) {
        this.title = title;
        this.subgenre = subgenre;
        this.duration = duration;
        this.mainCharacters = mainCharacters;
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

    public String getSubgenre() {
        return subgenre;
    }

}
