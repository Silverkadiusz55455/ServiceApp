package com.example.springdcserviceapp;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RepairRepository {
    private final List<Repair> repairList;

    private RepairRepository() {
        repairList = new ArrayList<>();
        repairList.add(new Repair("A01", "Samsung", 150.50));
        repairList.add(new Repair("A02", "Samsung", 160.50));
        repairList.add(new Repair("A03", "Samsung", 250.50));
        repairList.add(new Repair("A04", "Samsung", 150.50));
        repairList.add(new Repair("A05", "Samsung", 550.50));
        repairList.add(new Repair("A06", "Samsung", 350.50));

    }

    public List<Repair> findAll() {
        return repairList;
    }

    public Repair findById(String id) {
        for (Repair repair : repairList) {
            if(repair.getId().equals(id)) {
                return repair;
            }
        }
        return null;
    }


    public void add(Repair repair) {
        repairList.add(repair);
    }
}
