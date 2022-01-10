package com.example.springdcserviceapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ServiceController {

    private RepairRepository repairRepository;

    public ServiceController(RepairRepository repairRepository) {
        this.repairRepository = repairRepository;

    }

    @GetMapping("/lista")
    public String list(Model model) {
        prepareDataForTableOrList(model);
        return "list";
    }

    @GetMapping("/tab")
    public String table(Model model) {
        prepareDataForTableOrList(model);
        return "table";
    }

    private void prepareDataForTableOrList(Model model) {
        List<Repair> repairs = repairRepository.findAll();
        model.addAttribute("repairs", repairs);
        double sum = 0;
        for (Repair repair : repairs) {
            sum += repair.getPrice();
        }
        model.addAttribute("priceSum", sum);
    }

    @PostMapping("/dodaj")
    public String add(@RequestParam String id, @RequestParam String name, @RequestParam double price) {

        Repair repair = new Repair(id, name, price);
        repairRepository.add(repair);

        return "redirect:/lista";
    }

    @GetMapping("/naprawa")
    public String repair(Model model, @RequestParam String id, @RequestParam String name, @RequestParam double price) {
        Repair repair = repairRepository.findById(id);

        if(repair != null) {
            model.addAttribute("repair", repair);
            return "repair";
        } else {
            return "redirect:/lista";
        }
    }


}
