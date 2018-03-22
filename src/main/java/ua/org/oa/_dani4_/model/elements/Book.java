package ua.org.oa._dani4_.model.elements;

/**
 * Created by Admin on 03.04.2016.
 */
public class Book {
    //ID РєРЅРёРіРё
    private int id;
    //РђРІС‚РѕСЂ РєРЅРёРіРё
    private String author;
    //РќР°Р·РІР°РЅРёРµ РєРЅРёРіРё
    private String title;
    //РЎРєРѕР»СЊРєРѕ С‚Р°РєРёС… РєРЅРёРі РѕСЃС‚Р°Р»РѕСЃСЊ РІ Р±РёР±Р»РёРѕС‚РµРєРµ
    private int count;

    public Book(String author, String title, int count) {
        this.setAuthor(author);
        this.setTitle(title);
        this.setCount(count);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("id=").append(id);
        sb.append(", author='").append(author).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", count=").append(count);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (getId() != book.getId()) return false;
        if (getCount() != book.getCount()) return false;
        if (getAuthor() != null ? !getAuthor().equals(book.getAuthor()) : book.getAuthor() != null) return false;
        return getTitle() != null ? getTitle().equals(book.getTitle()) : book.getTitle() == null;

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getAuthor() != null ? getAuthor().hashCode() : 0);
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + getCount();
        return result;
    }
}