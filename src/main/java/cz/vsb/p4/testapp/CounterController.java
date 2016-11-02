package cz.vsb.p4.testapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * This is test controller to demonstrate spring MVC capabilities
 */
@Controller
public class CounterController {

    private final CounterService counterService;

    @Autowired
    public CounterController(CounterService counterService) {
        this.counterService = counterService;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/getValue")
    public String readCounterValue(@RequestParam("key") String key,
                                   @RequestParam("kvet") String kvet,
                                   Model model) throws Exception {
        System.out.println("Kvet: " + kvet);
        counterService.set(key, 1);
        counterService.setKvet(key, kvet);
        CounterValue counterValue = counterService.get(key);
        model.addAttribute("counterValue", counterValue);
        return "/value";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public String getIndex() {
        return "/index";
    }


}
