package be.vdab.beveiligd;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bestellingen")
class BestellingController {
    @GetMapping("aantal")
    int aantalBestellingen() {
// Je leest dit aantal normaal in de database,
// je gebruikt hier even een dummy waarde:
        return 7;
    }
}