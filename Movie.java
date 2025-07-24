import java.util.ArrayList;

public class Movie extends Material{
    private ArrayList<Person> actors;
    private Person director;
    public Movie(int id, String name, ArrayList<Integer> scores, int release_year, int price, Category category, String type, ArrayList<Person> actors, Person director) {
        super(id, name, scores, release_year, price, category, type); // to call the superclass constructor (Material)
        this.actors = actors != null ? actors : new ArrayList<>();
        this.director = director;
    }

    // Getter methods
    public ArrayList<Person> getActors() {
        return actors;
    }
    public Person getDirector() {
        return director;
    }

    // Setter methods
    public void setActors(ArrayList<Person> actors) {
        this.actors = actors;
    }
    public void setDirector(Person director) {
        this.director = director;
    }

    public void addActor(Person actor) {
        if(this.actors == null) {
            this.actors = new ArrayList<>();
        }
        this.actors.add(actor);
    }
    @Override
    public void showDetail() {
        System.out.println("--- Film Detayları ---");
        System.out.println("ID: " + getId());
        System.out.println("Adı: " + getName());
        System.out.println("Yayın Yılı: " + getRelease_year());
        System.out.println("Fiyat: " + getPrice() + " TL");
        System.out.println("Kategori: " + getCategory().getCategoryName());
        System.out.println("Ortalama Skor: " + String.format("%.2f", getAvgScore()));

        System.out.print("Aktörler");
        if(actors != null && !actors.isEmpty()) {
            for(int i = 0; i < actors.size(); i++) {
                System.out.print(actors.get(i).getFirstName() + " " + actors.get(i).getLastName());
                if( i < actors.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }else{
            System.out.println("Yok");
        }
        System.out.println("Yönetmen: " + getDirector().getFirstName() + " " + getDirector().getLastName());
        System.out.println("----------------------\n");
    }

    @Override
    public String toString() {
        StringBuilder actorNames = new StringBuilder();
        if (actors != null && !actors.isEmpty()) {
            for (int i = 0; i < actors.size(); i++) {
                actorNames.append(actors.get(i).getFirstName()).append(" ").append(actors.get(i).getLastName());
                if (i < actors.size() - 1) {
                    actorNames.append(", ");
                }
            }
        }else {
            actorNames.append("Yok");
        }

        return "Movie{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", director=" + director.getFirstName() + " " + director.getLastName() +
                ", actors=[" + actorNames.toString() + "]" +
                ", release_year=" + getRelease_year() +
                ", price=" + getPrice() +
                ", category=" + getCategory().getCategoryName() +
                ", avgScore=" + String.format("%.2f", getAvgScore()) +
                '}';
    }
}