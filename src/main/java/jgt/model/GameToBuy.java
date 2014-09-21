package jgt.model;

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

    public GameToBuy() {
    }

    public GameToBuy(String title) {
        toBuyOrder = 0;
        game = new Game(title);
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

}
