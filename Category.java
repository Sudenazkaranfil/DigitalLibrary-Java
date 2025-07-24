public class Category {
    private int id;
    private String categoryCode;
    private String categoryName;

    public Category(int id, String categoryCode, String categoryName) {
        this.id = id;
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
    }

    // Getter methods
    public int getId() {
        return id;
    }
    public String getCategoryCode() {
        return categoryCode;
    }
    public String getCategoryName() {
        return categoryName;
    }

    // Setter methods
    public void SetId(int id) {
        this.id = id;
    }
    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", categoryCode='" + categoryCode + '\'' +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}