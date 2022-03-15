package se.lexicon.g40_thymeleaf_firstlook;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import se.lexicon.g40_thymeleaf_firstlook.model.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Controller
public class ProductController {

    List<Product> productList;

    public ProductController() {
        this.productList = new ArrayList<>(
                Arrays.asList(
                        new Product(UUID.randomUUID().toString(), "Wooden Sword", "It's wooden sword not that sharp. for playing with", BigDecimal.TEN, true),
                        new Product(UUID.randomUUID().toString(), "Iron Sword", "A very dull for being a ron weapon", BigDecimal.valueOf(100),true)
                )
        );
    }

    @GetMapping("/products")
    public String showProductsView(Model model){
        model.addAttribute("productItems", productList);
        return "products";
    }

    @GetMapping("/products/add")
    public String showProductForm(){
        return "product-form";
    }

    @PostMapping("/products/add/process")
    public String processProductForm(
           @RequestParam(name = "name") String name,
           @RequestParam("price") BigDecimal price,
           @RequestParam("description") String description
    ){
        Product product = new Product(UUID.randomUUID().toString(),name,description,price, true);
        productList.add(product);

        return "redirect:/products";
    }


}
