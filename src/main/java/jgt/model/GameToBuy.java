package jgt.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "GAME_TO_BUY")
public class GameToBuy {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private long id;

    @OneToOne(cascade = {CascadeType.ALL}, optional = false)
    private Game game;

    @Column(name = "to_buy_order")
    private Integer toBuyOrder;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public GameToBuy() {
    }

    public GameToBuy(String title, User user) {
        toBuyOrder = 1;
        game = new Game(title);
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Integer getToBuyOrder() {
        return toBuyOrder;
    }

    public void setToBuyOrder(Integer toBuyOrder) {
        this.toBuyOrder = toBuyOrder;
    }

    public String getTitle() {
        return game.getTitle();
    }

    public void increaseOrder() {
        toBuyOrder++;
    }

    @JsonIgnore
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
