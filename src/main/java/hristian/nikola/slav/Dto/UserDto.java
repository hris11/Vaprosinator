package hristian.nikola.slav.Dto;

public class UserDto {
    private int id;

    private String email;

    private String username;

    private String nickname;

    public UserDto(int id, String email, String username, String nickname) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.nickname = nickname;
    }

    public UserDto() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
