package tp3_pe.tp_3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tp3_pe.tp_3.model.AddressRepository;
import tp3_pe.tp_3.model.StockAddr;
import tp3_pe.tp_3.model.StockAddrRepository;

@Controller
public class FormulaireController {
    @GetMapping("/formulaire")
    public String showForm () {

        return "formulaire";
    }
}
