package com.github.gustavoflor.ordo.core.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "agents")
@Getter
@Setter
public class Agent extends Entity {
    @Field(name = "name")
    private String name;

    @Field(name = "origin")
    private Origin origin;

    @Field(name = "role")
    private Role role;

    @Field(name = "expositionLevel")
    private Integer expositionLevel;

    @Field(name = "agility")
    private Integer agility;

    @Field(name = "strength")
    private Integer strength;

    @Field(name = "presence")
    private Integer presence;

    @Field(name = "vitality")
    private Integer vitality;

    @Field(name = "intellect")
    private Integer intellect;

    @Field(name = "lifePoints")
    private Integer lifePoints;

    @Field(name = "currentLifePoints")
    private Integer currentLifePoints;

    @Field(name = "effortPoints")
    private Integer effortPoints;

    @Field(name = "currentEffortPoints")
    private Integer currentEffortPoints;

    @Field(name = "sanityPoints")
    private Integer sanityPoints;

    @Field(name = "currentSanityPoints")
    private Integer currentSanityPoints;

    public static Agent named(final String name) {
        final var agent = new Agent();
        agent.setName(name);
        return agent;
    }
}
