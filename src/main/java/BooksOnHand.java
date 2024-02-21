import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "books_on_hand")
public class BooksOnHand {
    @Id
    private int id;
    private int bookId;
    private int readerId;
    private LocalDateTime issuedDate;
    private LocalDateTime returnDate;
}