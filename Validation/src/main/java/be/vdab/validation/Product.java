package be.vdab.validation;

import java.math.BigDecimal;

class Product {
    @PositiveOrZero @Digits (integer = 7, fraction = 2)
    private BigDecimal aankoopPrijs;
    @PositiveOrZero @Digits (integer = 7, fraction = 2)
    private BigDecimal verkoopPrijs;


    public BigDecimal getAankoopPrijs() {
        return aankoopPrijs;
    }

    public void setAankoopPrijs(BigDecimal aankoopPrijs) {
        this.aankoopPrijs = aankoopPrijs;
    }

    public BigDecimal getVerkoopPrijs() {
        return verkoopPrijs;
    }

    public void setVerkoopPrijs(BigDecimal verkoopPrijs) {
        this.verkoopPrijs = verkoopPrijs;
    }
}