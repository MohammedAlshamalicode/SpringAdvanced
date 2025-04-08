package fictief;

import java.math.BigDecimal;

public record Land(String naam , BigDecimal schuld , String[] talen , Woonplaats[] woonplaatsen) { }
