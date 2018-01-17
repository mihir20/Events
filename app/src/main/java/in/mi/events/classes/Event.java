package in.mi.events.classes;

/**
 * Created by mi on 17/1/18.
 */

public class Event {
    private int postID;
    private String title;
    private String author;
    private String description;
    private String imageUri;

    public Event (String title, String author, String description, String uri){
        this.author = author;
        this.description = description;
        this.title = title;
        this.imageUri = uri;
    }
    //empty constructer
    public Event () {

    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public int getPostID() { return postID; }

    public String getImageUri(){ return imageUri; }

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
