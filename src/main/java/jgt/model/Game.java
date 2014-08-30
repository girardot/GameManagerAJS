package jgt.model;

import static jgt.model.GameProgression.TO_DO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.io.Serializable;


@Entity
@Table(name = "GAME")
public class Game implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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

    public Integer getPercentProgression() {
        int percentProgression = 0;
        switch (progression) {
            case TO_DO:
                percentProgression = 20;
                break;
            case IN_PROGRESS:
                percentProgression = 50;
                break;
            case DONE:
                percentProgression = 100;
                break;
        }
        return percentProgression;
    }

    public void setProgression(GameProgression progression) {
        this.progression = progression;
    }

    public Console getConsole() {
        return console;
    }

    public void setConsole(Console console) {
        this.console = console;
    }

}
