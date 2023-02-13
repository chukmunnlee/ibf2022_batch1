package ibf2022.paf.day26.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ibf2022.paf.day26.services.TvShowService;

@Controller
@RequestMapping(path={"/", "/index.html"})
public class IndexController {

    @Autowired
    private TvShowService tvshowSvc;

    // GET /
    @GetMapping
    public String getIndex(Model model) {
        List<String> showTypes = tvshowSvc.getAllTypes();
        model.addAttribute("showTypes", showTypes);
        return "index";
    }
    
}
