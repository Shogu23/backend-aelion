package survey.backend.entities;

import lombok.Getter;
import lombok.Setter;
import survey.backend.enums.AnswerType;

import javax.persistence.*;

@Getter @Setter
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String text;

    @Column(length = 11, nullable = false)
    @Enumerated(EnumType.STRING)
    private AnswerType answerType;
}
