package br.com.voting.vote.models;

import br.com.voting.vote.enums.TypeVote;
import jakarta.persistence.*;

@Entity
@Table(name = "vote")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "vote_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "associate_id")
    private Associate associate;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;

    @ManyToOne(optional = false)
    @JoinColumn(name = "voting_session_id", nullable = false)
    private VotingSession votingSession;

    public abstract TypeVote getTypeVote();
}
