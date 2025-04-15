package be.vdab.cors;

import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("kwadraat")
class KwadraatController {


    @GetMapping("{getal}")
    int kwadraat(@PathVariable int getal) {
        return getal * getal;
    }

}