/*
 * Author  : Mr.electrix
 * Project : LibraLink
 * Date    : 3/16/24

 */

package lk.ijse.libraLink.dto.tm;

public class BookTM {
    private String id;
    private String title;
    private String author;
    private String genre;

    public BookTM(String id, String title, String author, String genre) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    public BookTM() {

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
}
