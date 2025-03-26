package com.sic.marktory.member_template.command.application.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

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

