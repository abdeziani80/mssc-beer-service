package guru.springframework.bootstrap;

import guru.springframework.demain.Beer;
import guru.springframework.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


@Component
public class BeerLoader implements CommandLineRunner {


    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        loadBeerObjects();
    }


    private void loadBeerObjects() {

        System.out.println("....... " + beerRepository.count());

        if (beerRepository.count() == 0){

            beerRepository.save(Beer.builder()
                    .beerName("Mango Bobs")
                    .beerStyle("IPA")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(337010000001L)
                    .price(new BigDecimal("12.95"))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Galaxy Cat")
                    .beerStyle("GOOSE")
                    .quantityToBrew(120)
                    .minOnHand(8)
                    .upc(550210000001L)
                    .price(new BigDecimal("8.95"))
                    .build());




        }

        System.out.println("Loaded Beers " + beerRepository.count());

    }
}
