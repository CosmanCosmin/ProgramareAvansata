package Database;

public class Movie {
    private String id;
    private String title;
    private int year;
    private String date;
    private String genres;
    private int duration;
    private String language;
    private String directorName;
    private String actors;
    private float score;
    public Movie(String id, String title, int year, String date, String genres, int duration, String language, String directorName, String actors, float score) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.date = date;
        this.genres = genres;
        this.duration = duration;
        this.language = language;
        this.directorName = directorName;
        this.actors = actors;
        this.score = score;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getGenres() {
        return genres;
    }
    public void setGenres(String genres) {
        this.genres = genres;
    }
    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
    public String getDirectorName() {
        return directorName;
    }
    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }
    public String getActors() {
        return actors;
    }
    public void setActors(String actors) {
        this.actors = actors;
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
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", date='" + date + '\'' +
                ", genres='" + genres + '\'' +
                ", duration=" + duration +
                ", language='" + language + '\'' +
                ", directorName='" + directorName + '\'' +
                ", actors='" + actors + '\'' +
                ", score=" + score +
                '}';
    }
}
