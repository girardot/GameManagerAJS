package model;

import static model.GameProgression.TO_DO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "GAME")
public class Game implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "progression")
    private GameProgression progression = TO_DO;

    @ManyToOne
    @JoinColumn(name = "console_id")
    private Console console;

    public Game() {
        progression = TO_DO;
    }

    public Game(String title) {
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public GameProgression getProgression() {
        return progression;
    }

    public void setProgression(GameProgression progression) {
        this.progression = progression;
    }

    @JsonIgnore
    public Console getConsole() {
        return console;
    }

    public void setConsole(Console console) {
        this.console = console;
    }

}
