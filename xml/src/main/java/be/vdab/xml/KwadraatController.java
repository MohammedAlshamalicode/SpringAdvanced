package be.vdab.xml;

import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("kwadraat")
class KwadraatController {
    private final KwadraatService kwadraatService;
    KwadraatController(KwadraatService kwadraatService) {
        this.kwadraatService = kwadraatService;
    }
    @GetMapping("{getal}")
    int kwadraat(@PathVariable int getal) {
        return kwadraatService.kwadraat(getal);
    }
}