package be.vdab.palindroom;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("woorden")
public class WoordController {

    private final WoordService woordService;

    public WoordController(WoordService woordService) {
        this.woordService = woordService;
    }

    @GetMapping("{woord}/isPalindrom")
    @Operation(summary = "is het woord een palindroom")
    boolean isPalindrom(@PathVariable String woord) {
        return woordService.isPalindrome(woord);
    }
}
