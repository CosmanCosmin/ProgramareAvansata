package Database;

public class Movie {
    private int id;
    private String title;
    private String date;
    private int duration;
    private float score;
    public Movie(int id, String title, String date, int duration, float score) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.duration = duration;
        this.score = score;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public float getScore() {
        return score;
    }
    public void setScore(float score) {
        this.score = score;
    }
    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", duration=" + duration +
                ", score=" + score +
                '}';
    }
}
