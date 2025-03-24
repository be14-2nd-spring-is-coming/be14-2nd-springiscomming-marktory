package com.sic.marktory.post.command.domain.aggregate;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@Getter @Setter
@EqualsAndHashCode
@ToString
public class Visibility {
        private String visibility;

        protected Visibility() {}

        public Visibility(String value) {
            if (value == null || (!value.equals("public") && !value.equals("private") && !value.equals("subonly"))) {
                throw new IllegalArgumentException("Invalid visibility type: " + value);
            }
            this.visibility = value;
        }
}

