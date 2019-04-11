package dk.kea.shipgame.Controller;

import dk.kea.shipgame.Model.MyImage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class mainController {

    @GetMapping("/")
    public String index(Model model){
        List<MyImage> images = new ArrayList<>();
        images.add(new MyImage(1, "camel", 100, 100));
        images.add(new MyImage(2, "terminator", 300, 400));
        images.add(new MyImage(3, "camel", 100, 400));
        images.add(new MyImage(4, "terminator", 300, 100));
        model.addAttribute("images", images);
        return "Ship-placement.html";
    }
}
