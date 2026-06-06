package com.bano.website;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebsiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebsiteApplication.class, args);
    }

    // Server start hote hi 12 Premium Real Estate Projects automatic load honge
    @Bean
    public CommandLineRunner dataLoader(ServiceRepository repository) {
        return args -> {
            // Purana cached data clear karte hain
            repository.deleteAll();

            // 1. VVIP Namah
            ServiceItem item1 = new ServiceItem();
            item1.setTitle("VVIP Namah");
            item1.setDescription("Mid-density, ultra-luxury residential project located in Aditya World City on the NH-24 highway in Ghaziabad.");
            repository.save(item1);

            // 2. T&T Atlas
            ServiceItem item2 = new ServiceItem();
            item2.setTitle("T&T Atlas");
            item2.setDescription("A newly launched, ultra-luxury residential project by the T&T Group, located in the prominent Raj Nagar Extension.");
            repository.save(item2);

            // 3. Migsun Elite One
            ServiceItem item3 = new ServiceItem();
            item3.setTitle("Migsun Elite One");
            item3.setDescription("An ultra-luxury residential tower featuring premium smart amenities located in Raj Nagar Extension, Ghaziabad.");
            repository.save(item3);

            // 4. SG Vista
            ServiceItem item4 = new ServiceItem();
            item4.setTitle("SG Vista");
            item4.setDescription("An under-construction, premium luxury residential project by the SG Group located in the heart of Ghaziabad.");
            repository.save(item4);

            // 5. Uninav Utopia
            ServiceItem item5 = new ServiceItem();
            item5.setTitle("Uninav Utopia");
            item5.setDescription("Beautifully crafted premium apartments offering spacious 2/3 BHK flats with world-class clubhouse landscapes.");
            repository.save(item5);

            // 6. Charms Castle
            ServiceItem item6 = new ServiceItem();
            item6.setTitle("Charms Castle");
            item6.setDescription("A magnificent high-rise residential masterpiece offering premium smart spaces with central green parks.");
            repository.save(item6);

            // 7. VVIP Mangal
            ServiceItem item7 = new ServiceItem();
            item7.setTitle("VVIP Mangal");
            item7.setDescription("Exclusive independent premium floors featuring private terraces, high-end cross ventilation, and 24/7 smart security networks.");
            repository.save(item7);

            // 8. Ajnara Integrity
            ServiceItem item8 = new ServiceItem();
            item8.setTitle("Ajnara Integrity");
            item8.setDescription("A fully delivered prime society located on the main belt of Rajnagar Extension, offering high-end dynamic amenities.");
            repository.save(item8);

            // 9. Uninav Bliss
            ServiceItem item9 = new ServiceItem();
            item9.setTitle("Uninav Bliss");
            item9.setDescription("Bespoke limited-edition modern apartments designed for elite families seeking premium comfort and quick highway connectivity.");
            repository.save(item9);

            // 10. MGI Gharaunda
            ServiceItem item10 = new ServiceItem();
            item10.setTitle("MGI Gharaunda");
            item10.setDescription("Affordable luxury project built with maximum space optimization, features safe kid play zones and continuous power backups.");
            repository.save(item10);

            // 11. Wave City Executive
            ServiceItem item11 = new ServiceItem();
            item11.setTitle("Wave City Executive");
            item11.setDescription("Smart city integrated township luxury tower offering ultra-modern high-tech security interfaces and private gym club lounges.");
            repository.save(item11);

            // 12. LandCraft Golf Links
            ServiceItem item12 = new ServiceItem();
            item12.setTitle("LandCraft Golf Links");
            item12.setDescription("Premium villa township facing vast lush green open fields, integrated golf spaces, and custom executive parking layouts.");
            repository.save(item12);

            System.out.println(">> Bhai, poore 12 Dynamic Projects Database mein automatic inject ho chuke hain! <<");
        };
    }
}