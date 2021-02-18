package domain.models.objects.molecule.move;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import domain.models.objects.molecule.Molecule;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type",
        defaultImpl = MoveStraight.class
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = MoveStraight.class, name = "moveStraight"),
        @JsonSubTypes.Type(value = MoveZigzag.class, name = "moveZigzag"),
        @JsonSubTypes.Type(value = MoveZigzagAfterQuarter.class, name = "moveZigzagAfterQuarter"),
        @JsonSubTypes.Type(value = MoveZigzagAfterHalf.class, name = "moveZigzagAfterHalf"),
})
public interface MoleculeMoveStrategy {
    void move(Molecule molecule);
}
