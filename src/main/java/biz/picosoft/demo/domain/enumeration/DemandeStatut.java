package biz.picosoft.demo.domain.enumeration;

import java.util.stream.Stream;

public enum DemandeStatut {

    DRAFT("Brouillon"),
    CREATED("deposé"),
    TREATED("Traité"),
    CANCELED("Annulé"),
    CLOSED("Clôturé");


    private final String label;

    DemandeStatut(String label) {
        this.label = label;
    }

    public static DemandeStatut of(String label) {
        return Stream.of(DemandeStatut.values())
                .filter(p -> p.getLabel() == label)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public String getLabel() {
        return label;
    }

}
