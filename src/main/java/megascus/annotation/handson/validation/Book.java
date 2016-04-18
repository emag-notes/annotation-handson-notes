package megascus.annotation.handson.validation;

import java.io.Serializable;

public class Book implements Serializable {

  @NotNull
  private Long id;

  @NotNull
  private String isbn;

  private String title;

  private Integer price;

  private String summary;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Book book = (Book) o;

    if (id != null ? !id.equals(book.id) : book.id != null) return false;
    if (isbn != null ? !isbn.equals(book.isbn) : book.isbn != null) return false;
    if (title != null ? !title.equals(book.title) : book.title != null) return false;
    if (price != null ? !price.equals(book.price) : book.price != null) return false;
    return summary != null ? summary.equals(book.summary) : book.summary == null;

  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
    result = 31 * result + (title != null ? title.hashCode() : 0);
    result = 31 * result + (price != null ? price.hashCode() : 0);
    result = 31 * result + (summary != null ? summary.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Book{" +
      "id=" + id +
      ", isbn='" + isbn + '\'' +
      ", title='" + title + '\'' +
      ", price=" + price +
      ", summary='" + summary + '\'' +
      '}';
  }
}
