package model;

import lombok.*;

import javax.persistence.Column;
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

    @Column(name = "issued_date")
    private LocalDateTime issuedDate;

    @Column(name = "return_date")
    private LocalDateTime returnDate;
}