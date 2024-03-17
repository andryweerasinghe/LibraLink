/*
 * Author  : Mr.electrix
 * Project : LibraLink
 * Date    : 2/28/24

 */

package lk.ijse.libraLink.entity;

import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

public class Book {
    @Id
    private String id;
    private String title;
    private String author;
    private String genre;
    private String availability;

    @OneToMany(mappedBy = "books") private List<Transactions> transactions;

    public Book(String id, String title, String author, String genre, String availability) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.availability = availability;
    }

    public Book(String title, String author, String genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    public Book(String id) {
        this.id = id;
    }

    public Book() {
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

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }
}
