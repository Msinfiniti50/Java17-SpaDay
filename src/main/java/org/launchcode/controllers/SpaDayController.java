package org.launchcode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;


@Controller
public class SpaDayController {
    public static void main(String [] args) {
    }
    public boolean checkSkinType(String skinType, String facialType) {
        return switch (skinType) {
            case "oily" -> facialType.equals("Microdermabrasion") || facialType.equals("Rejuvenating");
            case "combination" ->
                    facialType.equals("Microdermabrasion") || facialType.equals("Rejuvenating") || facialType.equals("Enzyme Peel");
            case "dry" -> facialType.equals("Rejuvenating") || facialType.equals("Hydrofacial");
            default -> true;
        };
    }

    @GetMapping(value="menu")
    @ResponseBody
    public String customerForm () {
       return "<form method = 'post'>" +
                "Name: <br>" +
                "<input type = 'text' name = 'name'>" +
                "<br>Skin type: <br>" +
                "<select name = 'skintype'>" +
                "<option value = 'oily'>Oily</option>" +
                "<option value = 'combination'>Combination</option>" +
                "<option value = 'normal'>Normal</option>" +
                "<option value = 'dry'>Dry</option>" +
                "</select><br>" +
                "Manicure or Pedicure? <br>" +
                "<select name = 'manipedi'>" +
                "<option value = 'manicure'>Manicure</option>" +
                "<option value = 'pedicure'>Pedicure</option>" +
                "</select><br>" +
                "<input type = 'submit' value = 'Submit'>" +
                "</form>";

    }

    @PostMapping(value="menu")
    public String spaMenu(@RequestParam String name, @RequestParam String skintype, @RequestParam String manipedi, Model model) {

        ArrayList<String> facials = new ArrayList<>();
        facials.add("Microdermabrasion");
        facials.add("Hydrofacial");
        facials.add("Rejuvenating");
        facials.add("Enzyme Peel");

        ArrayList<String> appropriateFacials = new ArrayList<>();
        for (String facial : facials) {
            if (checkSkinType(skintype,facial)) {
                appropriateFacials.add(facial);
            }
        }
                model.addAttribute("name", name);
                model.addAttribute("skintype", skintype);
                model.addAttribute("manipedi", manipedi);
                model.addAttribute("appropriateFacials", appropriateFacials);


        return "menu";
    }
}


