package br.com.voting.vote.models;

import br.com.voting.vote.enums.TypeVote;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("BLANK")
public class BlankVote extends Vote {

    @Override
    public TypeVote getTypeVote() {
        return null;
    }
}
