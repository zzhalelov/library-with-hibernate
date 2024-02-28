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
@Table(name = "books_in_library")
public class BookInLibrary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(mappedBy = "books_in_library")
    @Column(name = "book_id")
    private Book book;

    @OneToOne(mappedBy = "books_in_library")
    @Column(name = "status_id")
    private BookStatus bookStatus;
}