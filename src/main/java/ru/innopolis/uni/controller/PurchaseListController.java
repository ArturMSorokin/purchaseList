package ru.innopolis.uni.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.innopolis.uni.Service.PurchaseListService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by MrArtur on 02.12.2016.
 */
@Controller
public class PurchaseListController {

    private PurchaseListService purchaseListService;
    @Autowired
    public void setPurchaseListService(PurchaseListService purchaseListService) {
        this.purchaseListService = purchaseListService;
    }
    Map<Long,String> openedSessions = new HashMap<>();

    @RequestMapping(value="/",method = RequestMethod.GET)
    public String show(Map<String, Object> model,HttpServletRequest request) {
        HttpSession session = request.getSession();
        Long token=(Long)session.getAttribute("token");
        if (token!=null &&
                openedSessions.containsKey(token)) {
            purchaseListService.getItems(openedSessions.get(token),"default",model);
            return "itemsTable";
        } else {
            return "redirect:/login";
        }
    }

    @RequestMapping(value="/login",method = RequestMethod.POST)
    public String loginAction(Map<String, Object> model, HttpServletRequest request) {

        return "login";
    }

    @RequestMapping(value="/register",method = RequestMethod.POST)
    public String registerAction(Map<String, Object> model, HttpServletRequest request) {

        return "register";
    }
}
