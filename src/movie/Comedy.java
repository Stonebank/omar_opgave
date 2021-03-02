package movie;

public class Comedy extends DVD {

    private final String title;
    private final String duration;
    private final String[] mainCharacters;

    private final String type;

    public Comedy(String title, String duration, String[] mainCharacters, String type) {
        this.title = title;
        this.duration = duration;
        this.mainCharacters = mainCharacters;
        this.type = type;
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

    public String getType() {
        return type;
    }

}
