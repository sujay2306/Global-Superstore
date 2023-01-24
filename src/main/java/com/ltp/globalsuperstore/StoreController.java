package com.ltp.globalsuperstore;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public  class StoreController {
    List<item> items = new ArrayList<>();
    @GetMapping("/")
    public String getForm(Model model){
        model.addAttribute("item", new item());
        model.addAttribute("categories", Constants.CATEGORIES);
        return "form";
    }
    @GetMapping("/inventory")
    public String inventory(Model model){
        model.addAttribute("items",items); //mapping to items array
        return "inventory";
    }
    @PostMapping("/submitItem")
    public String handleSubmit(item  item){
        items.add(item);
        return "redirect:/inventory";
    }
}
