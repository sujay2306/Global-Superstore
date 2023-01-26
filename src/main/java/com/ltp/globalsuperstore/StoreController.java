package com.ltp.globalsuperstore;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
    public String handleSubmit(@Valid item  item, BindingResult result ,RedirectAttributes redirectAttributes){
        if (result.hasErrors()) {
            return "form";
        }
        int index = getIndexFromId(item.getId());
        String status = Constants.SUCCESS_STATUS;
        if (index == Constants.NOT_FOUND){
            items.add(item);
        }
        else if(within5Days(item.getDate(),items.get(index).getDate())) {
            items.set(index, item);
        }else{
            status = Constants.FAILED_STATUS;
        }
        redirectAttributes.addFlashAttribute("status", status);
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

    public boolean within5Days(Date newDate, Date oldDate) {
        long diff = Math.abs(newDate.getTime() - oldDate.getTime());
        return (int) (TimeUnit.MILLISECONDS.toDays(diff)) <= 5;
    }
}
