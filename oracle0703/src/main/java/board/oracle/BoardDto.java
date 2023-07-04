package board.oracle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor
@NoArgsConstructor
public class BoardDto {
    private int    num;
    private String writer;
    private String title;
    private String content;
    private String regtime;
    private int    hits;
}
