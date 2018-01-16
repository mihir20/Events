package in.mi.events.classes;

/**
 * Created by mi on 17/1/18.
 */

public class Event {
    private String title;
    private String author;
    private String description;

    public Event (String title, String author, String description){
        this.author = author;
        this.description = description;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }
}
