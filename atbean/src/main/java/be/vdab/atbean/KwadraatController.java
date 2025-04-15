package be.vdab.atbean;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("kwadraat")
class KwadraatController {
    private final KwadraatService kwadraatService;
    KwadraatController(KwadraatService kwadraatService) {
        this.kwadraatService = kwadraatService;
    }
    //http://localhost:8080/v3/api-docs
    //http://localhost:8080/v3/api-docs.yaml
    //https://www.postman.com
    @GetMapping("{getal}")
    @Operation(summary = "het kwadraat van een getal")
    int kwadraat(@PathVariable int getal) {
        return kwadraatService.kwadraat(getal);
    }

}