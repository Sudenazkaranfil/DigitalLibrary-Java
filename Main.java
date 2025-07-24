import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Proje Başlatılıyor. ---");

        System.out.println("\n--- Adım 1: Person Nesneleri Oluşturuluyor. ---");
        Person director1 = new Person(101, "Christopher", "Nolan", 53);
        Person actor1 = new Person(201, "Leonardo", "DiCaprio", 49);
        Person actor2 = new Person(202, "Tom", "Hardy", 46);
        Person writer1 = new Person(301, "Stephen",  "King", 76);
        Person actor3 = new Person(203, "Brad", "Pitt", 60);
        Person director2 = new Person(102, "Quentin", "Tarantino", 61);

        System.out.println("\n--- Adım 2: Category Nesneleri Oluşturuluyor. ---");
        Category sciFi = new Category(1, "SF", "Bilim Kurgu");
        Category horror = new Category(2, "HR", "Korku");
        Category drama = new Category(3, "DR", "Dram");
        Category action = new Category(4, "AC", "Aksiyon");
        Category thriller = new Category(5, "TH", "Gerilim");

        System.out.println("\n--- Adım 3: Movie Nesneleri Oluşturuluyor ve Skorlar Ekleniyor.");
        //Movie 1: Inception
        ArrayList<Integer> inceptionScores = new ArrayList<>();
        inceptionScores.add(9);
        inceptionScores.add(10);
        inceptionScores.add(9);
        ArrayList<Person> inceptionActors = new ArrayList<>();
        inceptionActors.add(actor1);
        inceptionActors.add(actor2);
        Movie movie1 = new Movie(1001, "Inception", inceptionScores, 2010, 200, sciFi, "movie", inceptionActors, director1);
        movie1.addScore(8);
        movie1.addScore(9);

        //Movie2: Pulp Fiction
        ArrayList<Integer> pulpFictionScores = new ArrayList<>();
        pulpFictionScores.add(9);
        pulpFictionScores.add(8);
        pulpFictionScores.add(10);
        ArrayList<Person> pulpFictionActors = new ArrayList<>();
        pulpFictionActors.add(actor3);
        pulpFictionActors.add(director2); // the director can also be an actor
        Movie movie2 = new Movie(1002, "Pulp Fiction", pulpFictionScores, 1994, 150, thriller, "movie", pulpFictionActors, director2);
        movie2.addScore(9);

        //Movie3: Interstellar
        ArrayList<Integer> interstellarScores = new ArrayList<>();
        interstellarScores.add(10);
        interstellarScores.add(10);
        interstellarScores.add(9);
        ArrayList<Person> interstellarActors = new ArrayList<>();
        interstellarActors.add(actor1);
        Movie movie3 = new Movie(1003, "Interstellar", interstellarScores, 2014, 220, sciFi, "movie", interstellarActors, director1);
        movie3.addScore(10);

        System.out.println("\n--- Adım 4: Book Nesneleri Oluşturuluyor ve Skorlar Ekleniyor ---");
        //Book 1: It
        ArrayList<Integer> itScores = new ArrayList<>();
        itScores.add(7);
        itScores.add(8);
        itScores.add(7);
        Book book1 = new Book(2001, "It", itScores, 1986, 100, horror, "book", writer1, 1138);
        book1.addScore(9);

        //Book 2: The Shining
        ArrayList<Integer> shiningScores = new ArrayList<>();
        shiningScores.add(9);
        shiningScores.add(9);
        Book book2 = new Book(2002, "The Shining", shiningScores, 1977, 120, horror, "book", writer1, 447);

        // 5- Defining a user object
        System.out.println("\n---- Adım 5: User Nesnesi Tanımlanıyor. ---");
        User currentUser = new User(1, "Deneme", "Kullanıcı", 25, "testUser", "123456");
        User wrongUser = new User(2, "Yanlış", "Kullanıcı", 30, "wrongUser", "wrongPass");

        // 6- Create a Netflix object
        System.out.println("\n--- Adım 6: Netflix nesnesi oluşturuluyor. ---");
        Netflix myNetflix = new Netflix(new ArrayList<>());

        // 7- Sign in for Netflix
        System.out.println("\n--- Adım 7: Netflix Oturumu Açılıyor. ---");
        boolean loginSuccess = myNetflix.login(currentUser);
        // myNetflix.login(wrongUser); // log in trying with wrong user

        System.out.println("\n--- Adım 8: Materyaller Netflix'e Ekleniyor ---");
        if(loginSuccess) {
            myNetflix.addMovie(movie1);
            myNetflix.addMovie(movie2);
            myNetflix.addMovie(movie3);
            myNetflix.addBook(book1);
            myNetflix.addBook(book2);
            myNetflix.addMaterial(new Movie(1004, "Another Movie", new ArrayList<>(), 2020, 180, action, "movie", new ArrayList<>(), director1));
        } else {
            System.out.println("Oturum açılamadığı için materyaller eklenemedi.");
        }

        System.out.println("\n--- Adım 9: Netflix Sorgu Fonksiyonları Çalıştırılıyor ---");
        myNetflix.showHighestAvgScoreMaterial();
        myNetflix.showLowestAvgScoreMovie();
        myNetflix.showMostExpensiveMaterialByCategory(sciFi.getId());
        myNetflix.showMostExpensiveMaterialByCategory(horror.getId());

        myNetflix.showMoviesByActor(actor1.getId());
        myNetflix.showMoviesByActor(actor3.getId());
        myNetflix.showMoviesByActor(9999);

        System.out.println("\n--- Proje Tamamlandı. ---");
    }
}