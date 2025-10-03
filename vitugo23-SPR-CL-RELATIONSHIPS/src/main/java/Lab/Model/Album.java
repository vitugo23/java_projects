package Lab.Model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Album {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long albumId;

    private String title;

    // ✅ Fix Many-to-One relationship with Artist
    @ManyToOne
    @JoinColumn(name = "artist_id", nullable = false) // Foreign key to artist table
    private Artist artist;

    // ✅ Fix One-to-Many relationship with Song
    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Song> songs;

    public Album(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Album{" +
                "albumId=" + albumId +
                ", title='" + title + '\'' +
                '}';
    }
}













