import java.util.ArrayList;

public abstract class Material {
    private int id;
    private String name;
    private ArrayList<Integer> scores;
    private int release_year;
    private int price;
    private Category category;
    private String type;

    // Constructor
    public Material(int id, String name, ArrayList<Integer> scores, int release_year, int price, Category category, String type) {
        this.id = id;
        this.name = name;
        this.scores = scores != null ? scores : new ArrayList<>(); // Null control
        this.release_year = release_year;
        this.price = price;
        this.category = category;
        this.type = type;
    }

    // Getter methods
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public ArrayList<Integer> getScores() {
        return scores;
    }
    public int getRelease_year() {
        return release_year;
    }
    public int getPrice() {
        return price;
    }
    public Category getCategory() {
        return category;
    }
    public String getType() {
        return type;
    }

    // Setter methods
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setScores(ArrayList<Integer> scores) {
        this.scores = scores;
    }
    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public void setType(String type) {
        this.type = type;
    }

    public void addScore( int score) {
        if(this.scores == null) {
            this.scores = new ArrayList<>(); //start it if it is not already started
        }
        this.scores.add(score);
    }

    public double getAvgScore() {
        if (scores == null || scores.isEmpty()) {
            return 0.0;
        }
        int sum = 0;
        for (int score : scores) {
            sum +=score;
        }
        return (double) sum / scores.size();
    }
    // Abstact - it must be defined in subclass
    public abstract void showDetail(); // Polymorphism - Can be re-implemented as needed

    @Override
    public String toString() {
        return "Material{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", scores=" + scores +
                ", release_year=" + release_year +
                ", price=" + price +
                ", category=" + category.getCategoryName() +
                ", type='" + type + '\'' +
                ", avgScore=" + String.format("%.2f", getAvgScore()) +
                '}';
    }
}
