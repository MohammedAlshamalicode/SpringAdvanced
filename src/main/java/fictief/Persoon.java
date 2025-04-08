package fictief;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Persoon(String naam ,
                      @JsonProperty("aantal_kinderen") int aantalKinderen) {
}
