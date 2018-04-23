package hristian.nikola.slav.Dto;

public class PlayerDto {

    private Integer id;

    private String username;

    private Integer wins;

    public PlayerDto(Integer id, String username, Integer wins) {
        this.id = id;
        this.username = username;
        this.wins = wins;
    }

    public PlayerDto() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }
}
