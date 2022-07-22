package com.github.gustavoflor.ordo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import static com.github.gustavoflor.ordo.model.Weapon.Range.*;
import static com.github.gustavoflor.ordo.model.Weapon.Type.*;

@Getter
@RequiredArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Weapon {
    GUN_BUTT("Coronhada", null, "1d4", 2, 20, null, IMPACT, null),
    KNIFE("Faca", 0, "1d4", 1, 19, CLOSE, CUT, 1),
    HAMMER("Martelo", 0, "1d6", 2, 20, null, IMPACT, 1),
    DAGGER("Punhal", 0, "1d4", 3, 20, null, PERFORATION, 1),
    BAT("Bastão", 0, "1d6/1d8", 2, 20, null, IMPACT, 1),
    MACHETE("Machete", 0, "1d6", 1, 19, null, CUT, 1),
    SPEAR("Lança", 0, "1d6", 2, 20, CLOSE, PERFORATION, 1),
    STAFF("Cajado", 0, "1d6/1d6", 2, 20, null, IMPACT, 2),
    BOW("Arco", 0, "1d6", 3, 20, MID, PERFORATION, 2),
    CROSSBOW("Besta", 0, "1d8", 1, 19, MID, PERFORATION, 2),
    PISTOL("Pistola", 1, "1d12", 1, 18, CLOSE, BALLISTIC, 1),
    REVOLVER("Revólver", 1, "2d6", 3, 19, CLOSE, BALLISTIC, 1),
    HUNTING_RIFLE("Fuzil de caça", 1, "2d8", 3, 19, MID, BALLISTIC, 2),
    HATCHET("Machadinha", 0, "1d6", 3, 20, CLOSE, CUT, 1),
    NUNCHAKU("Nunchaku", 0, "1d8", 2, 20, null, IMPACT, 1),
    CHAIN("Corrente", 0, "1d8", 2, 20, null, IMPACT, 1),
    SWORD("Espada", 1, "1d8/1d10", 1, 19, null, CUT, 1),
    FOIL("Florete", 1, "1d6", 1, 18, null, CUT, 1),
    AXE("Machado", 1, "1d8", 3, 20, null, CUT, 1),
    SLEDGEHAMMER("Marreta", 1, "2d4", 2, 20, null, IMPACT, 1),
    ACHA("Acha", 1, "1d12", 3, 20, null, CUT, 2),
    SCYTHE("Gadanho", 1, "2d4", 4, 20, null, CUT, 2),
    KATANA("Katana", 1, "1d10", 1, 19, null, CUT, 2),
    MONTANTE("Montante", 1, "2d6", 1, 19, null, CUT, 2),
    CHAINSAW("Moto-serra", 1, "3d6", 2, 20, null, CUT, 2),
    COMPOUND_BOW("Arco composto", 1, "1d10", 3, 20, MID, PERFORATION, 2),
    HEAVY_CROSSBOW("Balestra", 1, "1d12", 1, 19, MID, PERFORATION, 2),
    SMG("Submetralhadora", 1, "2d6", 3, 19, CLOSE, BALLISTIC, 1),
    SHOTGUN("Espingarda", 1, "4d6", 3, 20, CLOSE, BALLISTIC, 2),
    ASSAULT_RIFLE("Fuzil de assalto", 2, "2d10", 3, 19, MID, BALLISTIC, 2),
    SNIPER_RIFLE("Fuzil de precisão", 3, "2d10", 3, 19, LONG, BALLISTIC, 2),
    BAZOOKA("Bazuca", 3, "10d8", 2, 20, MID, IMPACT, 2),
    FLAMETHROWER("Lança-chamas", 3, "6d6", 2, 20, CLOSE, FIRE, 2),
    LMG("Metralhadora", 2, "2d12", 3, 19, MID, BALLISTIC, 2);

    private final String name;
    private final Integer category;
    private final String damage;
    private final Integer criticalMultiplier;
    private final Integer threatMargin;
    private final Range range;
    private final Type type;
    private final Integer spaces;

    enum Range {
        CLOSE,
        MID,
        LONG
    }

    enum Type {
        IMPACT,
        CUT,
        PERFORATION,
        BALLISTIC,
        FIRE
    }
}
