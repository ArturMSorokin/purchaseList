package ru.innopolis.uni.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.innopolis.uni.Service.PurchaseListService;

import java.util.Map;

/**
 * Created by MrArtur on 02.12.2016.
 */
@Controller
public class PurchaseListController {
    @Autowired
    private PurchaseListService purchaseListService;
    public void setPurchaseListService(PurchaseListService purchaseListService) {
        this.purchaseListService = purchaseListService;
    }
    @RequestMapping({"/"})
    public String show(Map<String, Object> model) {
        if (  )
    }
}
