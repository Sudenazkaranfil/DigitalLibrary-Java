import java.util.ArrayList;
import java.util.Collections;

public class Netflix {
    private ArrayList<Material> materials;
    private User credential; // for user information that successfully logs in
    private boolean isLogin;

    public Netflix(ArrayList<Material> materials) {
        this.materials = materials != null ? materials : new ArrayList<>();
        this.isLogin = false;
        this.credential = null;
    }

    // Getter methods
    public ArrayList<Material> getMaterials() {
        return materials;
    }
    public User getCredential() {
        return credential;
    }
    public boolean isLogin() {
        return isLogin;
    }

    public boolean login(User user) {
        String predefinedUsername = "testUser";
        String predefinedPassword = "123456";

        if (user.getUserName().equals(predefinedUsername) && user.getPassword().equals(predefinedPassword)) {
            this.isLogin = true;
            this.credential = user;
            System.out.println("Başarıyla oturum açıldı: " + user.getUserName());
            return true;
        } else {
            this.isLogin = false;
            this.credential = null;
            System.out.println("Kullanıcı adı veya şifre yanlış.");
            return false;
        }
    }

    public void addMovie(Movie m1) {
        if (isLogin) {
            this.materials.add(m1);
            System.out.println(m1.getName() + " filmi başarıyla eklendi.");
        } else {
            System.out.println("Film eklemek için önce oturum açmalısınız.");
        }
    }

    public void addBook(Book b1) {
        if (isLogin) {
            this.materials.add(b1);
            System.out.println(b1.getName() + " kitabı başarıyla eklendi.");
        } else {
            System.out.println("Kitap eklemek için oturum açmalısınız.");
        }
    }

    public void addMaterial(Material m2) {
        if (isLogin) {
            this.materials.add(m2);
            System.out.println(m2.getName() + " materyali başarıyla eklendi.");
        } else {
            System.out.println("Materyal eklemek için önce oturum açmalısınız.");
        }
    }

    // QUERY FUNCTİNS
    public void showHighestAvgScoreMaterial() {
        if (materials.isEmpty()) {
            System.out.println("Kütüphanede materyal bulunmuyor.");
            return;
        }
        Material highestScoredMaterial = materials.get(0);

        for (Material material : materials) {
            if(material.getAvgScore() > highestScoredMaterial.getAvgScore()) {
                highestScoredMaterial = material;
            }
        }
        System.out.println("\n--- En Yüksek Ortalama Skora Sahip Materyal ---");
        highestScoredMaterial.showDetail();
    }

    public void showLowestAvgScoreMovie() {
        Movie lowestScoredMovie = null;
        for (Material material : materials) {
            if(material instanceof Movie) {
                Movie currentMovie = (Movie) material;
                if(lowestScoredMovie == null || currentMovie.getAvgScore() < lowestScoredMovie.getAvgScore()) {
                    lowestScoredMovie = currentMovie;
                }
            }
        }
        if (lowestScoredMovie != null) {
            System.out.println("\n--- En Düşük Ortalama Skora Sahip Film ---");
            lowestScoredMovie.showDetail();
        } else {
            System.out.println("Kütüphanede film bulunmuyor veya skorları mevcut değil.");
        }
    }

    public void showMostExpensiveMaterialByCategory(int categoryId) {
        Material mostExpensiveMaterial = null;
        for (Material material : materials) {
            if(material.getCategory().getId() == categoryId) {
                if(mostExpensiveMaterial == null || material.getPrice() > mostExpensiveMaterial.getPrice()) {
                    mostExpensiveMaterial = material;
                }
            }
        }
        if(mostExpensiveMaterial != null) {
            System.out.println("\n--- Kategori ID " + categoryId + " İçin En Pahalı Materyal ---");
            mostExpensiveMaterial.showDetail();
        } else {
            System.out.println("Belirtilen kategori ID'sine sahip materyal bulunamadı.");
        }
    }

    public void showMoviesByActor(int personId) {
        ArrayList<Movie> actorMovies = new ArrayList<>();
        Person actorFound = null;
        for(Material material : materials) {
            if(material instanceof Movie) { //if the material is a film
                Movie movie = (Movie) material; //cast in Movie
                for(Person actor : movie.getActors()) {
                    if(actor.getId() == personId) {
                        actorMovies.add(movie);
                        actorFound = actor;
                        break;
                    }
                }
            }
        }
        if(!actorMovies.isEmpty()){
            System.out.println("\n---" + (actorFound != null ? actorFound.getFirstName() + " " + actorFound.getLastName() : "ID " + personId) + " Tarafından Oynanan Filmler ---");
            for(Movie movie : actorMovies) {
                movie.showDetail();
            }
        } else {
            System.out.println("ID " + personId + " ile eşleşen bir aktör tarafından oynanan film bulunamadı.");
        }
    }

    public String toString() {
        return "Netflix{" +
                "materialCount=" + materials.size() +
                ", isLogin=" + isLogin +
                ", currentUser=" + (credential != null ? credential.getUserName() : "None") +
                "}";
    }
}