package com.valtech.training.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.valtech.training.ecommerce.services.InventoryService;
import com.valtech.training.ecommerce.services.OrderService;
import com.valtech.training.ecommerce.vos.ItemVO;
import com.valtech.training.ecommerce.vos.OrderVO;

import jakarta.servlet.http.HttpSession;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;


    
    @PostMapping("/dashboard")
    public String addItemToCart(@ModelAttribute("order") OrderVO orderVO, Model model, HttpSession session) {
        session.setAttribute("cart", orderVO);
        return "redirect:/dashboard";
    }

    @PostMapping("/placeOrder")
    public String placeOrder(HttpSession session, Model model) {
        OrderVO orderVO = (OrderVO) session.getAttribute("cart");

        if (orderVO != null) {
            if (orderService.isOrderPlaced(orderVO)) {
                session.removeAttribute("cart");
                model.addAttribute("orderPlaced", true);
                return "redirect:/dashboard";
            }
        }
        model.addAttribute("orderPlaced", false);
        return "redirect:/dashboard";
    }
}
