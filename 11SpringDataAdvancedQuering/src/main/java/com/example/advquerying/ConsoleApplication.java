package com.example.advquerying;

import com.example.advquerying.entities.BaseEntity;
import com.example.advquerying.repositories.ShampooRepository;
import com.example.advquerying.services.IngredientService;
import com.example.advquerying.services.ShampooService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ConsoleApplication implements CommandLineRunner {

    private final ShampooService shampooService;
    private final IngredientService ingredientService;

    public ConsoleApplication(ShampooService shampooService, IngredientService ingredientService) {
        this.shampooService = shampooService;
        this.ingredientService = ingredientService;
    }

    @Override
    public void run(String... args) throws Exception {
//        1.
//      showResult(this.shampooService.selectBySize(Size.MEDIUM));
//        2.
//      showResult(this.shampooService.selectBySizeOrLabelId(Size.MEDIUM, 10));
//        3.
//      showResult(this.shampooService.selectByPriceGreaterThan(BigDecimal.valueOf(5)));
//        4.
//      showResult(this.ingredientService.selectNameStartsWith("M"));
//        5.
//      showResult(this.ingredientService.selectNameIn(Set.of("Lavender", "Herbs", "Apple")));
//        6.
//      System.out.println(this.shampooService.countPrice(BigDecimal.valueOf(8.50)));
//        7.
//      showResult(this.shampooService.shampooByIngredients(Set.of("Berry", "Mineral-Collagen")));
//        8.
//        showResult(this.shampooService.shampooByIngredientsCount(2));
//        9.
//        System.out.printf("Affected Ingredients: %d%n", this.ingredientService.deleteByName("Apple"));
//        10.
//        System.out.printf("Affected Ingredients: %d%n", this.ingredientService.increasePriceByPercent(10));
//        11.
        System.out.printf("Affected Ingredients: %d%n",
                this.ingredientService
                        .increasePriceOfIngredientsByPercent(Set.of("Apple", "Nettle", "Macadamia Oil"), 10));


    }

    private <Т> void showResult(List<Т> shampoos) {
        System.out.println(shampoos
                .stream()
                .map(Т::toString)
                .collect(Collectors.joining(System.lineSeparator())));
    }
}
