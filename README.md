# Digital Library Java Project

Bu proje, Java ile Nesne Yönelimli Programlama (OOP) prensipleri kullanılarak geliştirilmiş basit bir dijital kütüphane/medya yönetim sistemidir. Filmler, kitaplar gibi farklı materyalleri yönetmek, kategorize etmek, detaylarını görüntülemek ve bazı sorgulamalar yapmak amacıyla tasarlanmıştır.

## İçerdiği OOP Prensipleri

Bu proje, aşağıdaki temel OOP prensiplerini uygulamaktadır:

* **Kapsülleme (Encapsulation):** Tüm sınıf özelliklerinin (field) `private` olarak tanımlanması ve bunlara `public` getter/setter metotları aracılığıyla erişilmesi sağlanmıştır. Bu, verinin bütünlüğünü korur ve dışarıdan doğrudan müdahaleyi engeller.
* **Kalıtım (Inheritance):** Ortak özellik ve davranışları paylaşan sınıflar arasında hiyerarşik bir ilişki kurulmuştur. Örneğin:
    * `User` sınıfı `Person` sınıfından miras alır.
    * `Movie` ve `Book` sınıfları `Material` soyut sınıfından miras alır.
* **Çok Biçimlilik (Polymorphism):** Farklı sınıfların aynı metot imzasına sahip olup farklı şekillerde davranması prensibi kullanılmıştır. Örneğin, `Material` soyut sınıfındaki `showDetail()` metodu, `Movie` ve `Book` sınıflarında kendi özel detaylarını gösterecek şekilde `@Override` edilmiştir. `Netflix` sınıfı, `Material` tipindeki bir koleksiyon üzerinde dönerken, her bir materyalin kendi `showDetail()` metodunu çağırabilir.
* **Soyutlama (Abstraction):** Ortak bir temel arayüz veya şablon tanımlamak için soyut sınıflar kullanılmıştır. `Material` sınıfı `abstract` olarak tanımlanmıştır ve `showDetail()` gibi metotların alt sınıflar tarafından implemente edilmesini zorunlu kılar. Bu, karmaşık detayları gizleyerek yalnızca gerekli işlevselliği sunar.

## Özellikler

* **Materyal Yönetimi:** Filmler (`Movie`) ve Kitaplar (`Book`) gibi farklı materyalleri sisteme ekleme.
* **Kullanıcı ve Kategori Tanımlama:** Kullanıcılar (`User`) ve Kategoriler (`Category`) oluşturma.
* **Puanlama Sistemi:** Materyallere puanlar ekleyebilme ve ortalama puanlarını hesaplama.
* **Detay Görüntüleme:** Her materyalin kendine özgü detaylarını (`showDetail()`) görüntüleyebilme.
* **Sorgulama Fonksiyonları:**
    * En yüksek ortalama skora sahip materyali bulma.
    * En düşük ortalama skora sahip filmi bulma.
    * Belirli bir kategoriye ait en pahalı materyali bulma.
    * Belirli bir aktörün oynadığı tüm filmleri listeleme.

## Proje Yapısı
staj/

├── src/

│   ├── Book.java

│   ├── Category.java

│   ├── Main.java

│   ├── Material.java

│   ├── Movie.java

│   ├── Netflix.java

│   ├── Person.java

│   └── User.java

├── .idea/                 (IntelliJ IDEA proje ayarları)

├── out/                   (Derlenmiş Java sınıfları)

├── lib/                   (Jackson kütüphaneleri: jar dosyaları)

└── README.md              (Bu dosya)

## Gereksinimler

* Java Development Kit (JDK) 8 veya daha yeni bir sürüm. (Proje JDK 24 ile test edilmiştir.)

## Nasıl Çalıştırılır

1.  **Projeyi Klonlayın:**
    ```bash
    git clone [https://github.com/Sudenazkaranfil/DigitalLibrary-Java.git](https://github.com/Sudenazkaranfil/DigitalLibrary-Java.git)
    ```
    (Kendi GitHub deponuzun URL'si ile değiştirin.)

2.  **IntelliJ IDEA ile Açın:**
    * IntelliJ IDEA'yı açın.
    * "Open" (Aç) seçeneğini tıklayın ve klonladığınız `DigitalLibrary-Java` klasörünü seçin.

3.  **Kütüphaneleri Ekleyin:**
    * `File -> Project Structure` (veya `Ctrl+Alt+Shift+S`) yolunu izleyin.
    * "Apply" ve "OK" butonlarına tıklayın.

4.  **Projeyi Yeniden Derleyin:**
    * `Build -> Rebuild Project` seçeneğini tıklayın.

5.  **`Main` Sınıfını Çalıştırın:**
    * `src/Main.java` dosyasını açın.
    * `main` metodu içerisinden sağ tıklayarak veya üst menüdeki "Run" butonu aracılığıyla `Main.main()` metodunu çalıştırın.
