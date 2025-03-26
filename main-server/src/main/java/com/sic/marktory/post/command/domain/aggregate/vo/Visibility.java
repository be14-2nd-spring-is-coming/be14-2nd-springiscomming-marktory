package com.sic.marktory.post.command.domain.aggregate.vo;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Embeddable
@Getter
@EqualsAndHashCode
@ToString
public class Visibility {

    private String value;

    protected Visibility() {}

    public Visibility(String value) {
        if (!value.equals("public") && !value.equals("private") && !value.equals("subonly")) {
            throw new IllegalArgumentException("Invalid visibility type: " + value);
        }
        this.value = value;
    }
}

