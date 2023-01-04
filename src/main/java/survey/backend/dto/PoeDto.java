package survey.backend.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.SuperBuilder;
import survey.backend.tools.PoeType;

import java.util.Date;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class PoeDto {

    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date beginDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date endDate;

    private String title;

    private Enum<PoeType> poeType;
}
