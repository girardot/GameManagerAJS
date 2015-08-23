package jgt.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CONSOLE")
public class Console {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private long id;

    @Column(name = "console_name")
    private String name;

    @OneToMany(mappedBy = "console", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private List<Game> games;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Console() {
        games = new ArrayList<>();
    }

    public Console(String name) {
        games = new ArrayList<>();
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public int numberOfGames() {
        return games.size();
    }

    public void addGame(Game game) {
        games.add(game);
        game.setConsole(this);
    }

    @JsonIgnore
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
