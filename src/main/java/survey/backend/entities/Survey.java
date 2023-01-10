package survey.backend.entities;

import lombok.Getter;
import lombok.Setter;
import survey.backend.enums.Level;
import survey.backend.enums.PoeType;

import javax.persistence.*;

@Getter @Setter
@Entity
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(length = 10, nullable = false)
    @Enumerated(EnumType.STRING)
    private Level level;

    @Column(length = 4)
    @Enumerated(EnumType.STRING)
    private PoeType type;

}
