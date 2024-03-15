/*
 * Author  : Mr.electrix
 * Project : LibraLink
 * Date    : 3/13/24

 */

package lk.ijse.libraLink.dto;

public class BookDTO {
    private int id;
    private String title;
    private String author;
    private String genre;
    private String availability;

    public BookDTO(int id, String title, String author, String genre, String availability) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.availability = availability;
    }

    public BookDTO() {
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", availability='" + availability + '\'' +
                '}';
    }
}
