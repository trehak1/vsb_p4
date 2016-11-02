package cz.vsb.p4.testapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * This is test controller to demonstrate spring MVC capabilities
 */
@Controller
public class StromController {

    private final StromRepository stromRepository;

    @Autowired
    public StromController(StromRepository stromRepository) {
        this.stromRepository = stromRepository;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public String listAll(Model model) {
        Map<String, Strom> stromy = stromRepository.getAll();
        model.addAttribute("stromy", stromy);
        return "/index";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/delete/{nazev}")
    public String deleteStrom(@PathVariable("nazev") String nazev) {
        stromRepository.deleteStrom(nazev);
        return "/index";
    }

    @RequestMapping(method = RequestMethod.POST, path = "/createStrom")
    public String createStrom(@RequestParam("nazev") String nazev) {
        Strom strom = new Strom(nazev);
        stromRepository.saveStrom(strom);
        return "/index";
    }

}
