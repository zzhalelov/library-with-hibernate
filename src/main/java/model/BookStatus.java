package model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "book_statuses")
public class BookStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String status;

    @ManyToOne
    @JoinColumn(name = "id_reader")
    private Reader reader;

    @ManyToOne
    @JoinColumn(name = "id_book")
    private Book book;

    private boolean onHand;
}