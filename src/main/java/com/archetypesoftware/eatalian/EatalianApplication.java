package com.archetypesoftware.eatalian;

import com.archetypesoftware.eatalian.domain.accounts.Account;
import com.archetypesoftware.eatalian.domain.accounts.Address;
import com.archetypesoftware.eatalian.domain.catalogue.Category;
import com.archetypesoftware.eatalian.domain.catalogue.Product;
import com.archetypesoftware.eatalian.domain.monetary.CurrencyAmount;
import com.archetypesoftware.eatalian.repositories.AccountRepository;
import com.archetypesoftware.eatalian.repositories.CategoryRepository;
import com.archetypesoftware.eatalian.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.Currency;

@SpringBootApplication
public class EatalianApplication {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final AccountRepository accountRepository;

    @Autowired
    public EatalianApplication(CategoryRepository categoryRepository,
                               ProductRepository productRepository,
                               AccountRepository accountRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.accountRepository = accountRepository;
    }


    public static void main(String[] args) {
        SpringApplication.run(EatalianApplication.class, args);
    }

	// Gratitude for this delicious menu we owe to one of our favorite
	// restaurants in Belgrade: Cocktail Bar "Cruise"
    @Bean
    ApplicationRunner setup() {
        return args -> {
            Category food = categoryRepository.save(new Category("Food"));
            Category sandwiches = categoryRepository.save(
                    new Category("Sandwiches")
                            .linkParent(food));

            productRepository.save(
                    new Product("Sandwich with rocket salad and tuna fish")
                            .setDescription("Whole wheat bread roll, ketchup, rocket salad, tuna fish, cucumber")
                            .setPrice(CurrencyAmount.of(4, Currency.getInstance("USD")))
                            .linkCategory(sandwiches));

            productRepository.save(
                    new Product("Philadelphia sandwich")
                            .setDescription("Whole wheat bread roll, sour cream, lettuce, beefsteak, smoked hard cheese, onion, tomato, mustard")
                            .setPrice(CurrencyAmount.of(5, Currency.getInstance("USD")))
                            .linkCategory(sandwiches));

            Category pasta = categoryRepository.save(
                    new Category("Pasta")
                            .linkParent(food));

            productRepository.save(
                    new Product("Fusilli with prosciutto, spinach and gorgonzola cheese")
                            .setDescription("Fusilli, prosciutto, spinach, cooking cream, gorgonzola, parmesan")
                            .setPrice(CurrencyAmount.of(7, Currency.getInstance("USD")))
                            .linkCategory(pasta));

            productRepository.save(
                    new Product("Tagliatelle in cream sauce with almonds and chicken")
                            .setDescription("Tagliatelle, chicken breasts, almonds, spices, cooking cream")
                            .setPrice(CurrencyAmount.of(7, Currency.getInstance("USD")))
                            .linkCategory(pasta));

            // some accounts, to make our example more spicy
            accountRepository.save(new Account()
                    .setFirstName("John")
                    .setLastName("Doe")
                    .setEmail("john.doe@gmail.com")
                    .setPassword("P@ssw0rd")
                    .setBillingAddress(sampleAddress())
                    .setShipmentAddress(sampleAddress())
					.setContactPhone("+774421234321")
                    .setDateOfCreation(LocalDateTime.now())
                    .setActive(true));

            accountRepository.save(new Account()
                    .setFirstName("Jane")
                    .setLastName("Doe")
                    .setEmail("jane.doe@gmail.com")
                    .setPassword("P@ssw0rd")
                    .setBillingAddress(sampleAddress())
                    .setShipmentAddress(sampleAddress())
					.setContactPhone("+774421234322")
                    .setDateOfCreation(LocalDateTime.now())
                    .setActive(true));

        };
    }

    private Address sampleAddress() {
        return new Address()
                .setStreetAndNo("Moonlight Avenue 27")
                .setCity("New York")
                .setCountry("Utopia")
                .setPostalCode("432112");
    }

}
