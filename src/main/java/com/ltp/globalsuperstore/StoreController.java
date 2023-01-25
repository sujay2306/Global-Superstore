package com.ltp.globalsuperstore;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public  class StoreController {
    List<item> items = new ArrayList<>();
    @GetMapping("/")
    public String getForm(Model model,  @RequestParam(required=false) String id){
        int index = getIndexFromId(id);
        model.addAttribute("item", index == Constants.NOT_FOUND ? new item() : items.get(index));
        model.addAttribute("categories", Constants.CATEGORIES);
        return "form";
    }

    @PostMapping("/submitItem")
    public String handleSubmit(item  item, RedirectAttributes redirectAttributes){
        int index = getIndexFromId(item.getId());
        if (index == Constants.NOT_FOUND){
            items.add(item);
        }
        else {
            items.set(index, item);
        }
        redirectAttributes.addFlashAttribute("status", Constants.SUCCESS_STATUS);
        //save flash attribute  status: success
        return "redirect:/inventory";
    }
    @GetMapping("/inventory")
    public String inventory(Model model){
        model.addAttribute("items",items); //mapping to items array
        return "inventory";
    }


    public int getIndexFromId(String id){
        for(int i = 0; i< items.size(); i++){
            if(items.get(i).getId().equals(id)) return  i;
        }
        return Constants.NOT_FOUND;
    }
}
