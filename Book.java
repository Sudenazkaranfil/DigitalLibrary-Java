import java.util.ArrayList;

public class Book extends Material {
    private Person writer; //an object of the person class
    private int numberOfPages;

    //Constructor
    public Book(int id, String name, ArrayList<Integer> scores, int release_year, int price, Category category, String type, Person writer, int numberOfPages) {
        super(id, name, scores, release_year, price, category, type); // to call the superclass constructor (Material)
        this.writer = writer;
        this.numberOfPages = numberOfPages;
    }

    // Getter Methods
    public Person getWriter() {
        return writer;
    }
    public int getNumberOfPages() {
        return numberOfPages;
    }
    public void setWriter(Person writer) {
        this.writer = writer;
    }
    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    @Override
    public void showDetail() {
        System.out.println("--- Kitap Detayları ---");
        System.out.println("ID: " + getId());
        System.out.println("Adı: " + getName());
        System.out.println("Yayın Yılı: " + getRelease_year());
        System.out.println("Fiyat: " + getPrice() + " TL");
        System.out.println("Kategori: " + getCategory().getCategoryName());
        System.out.println("Ortalama Skor: " + String.format("%.2f", getAvgScore()));
        System.out.println("Yazar: " + getWriter().getFirstName() + " " + getWriter().getLastName());
        System.out.println("Sayfa Sayısı: " + getNumberOfPages());
        System.out.println("------------------------------\n");
    }

    public String toString() {
        return "Book{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", writer=" + writer.getFirstName() + " " +
                ", numberOfPages=" + numberOfPages +
                ", release_year=" + getRelease_year() +
                ", price=" + getPrice() +
                ", category=" + getCategory().getCategoryName() +
                ", avgScore=" + String.format("%.2f", getAvgScore()) +
                "}";
    }
}