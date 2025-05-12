// Author: Amit Rizal
// Date: 05/11/2025
// Assignment: Module 10 - Fan Database Manager
// Purpose: This class models the Fan entity.

public class Fan {
    private int id;
    private String firstName;
    private String lastName;
    private String favoriteTeam;

    public Fan(int id, String firstName, String lastName, String favoriteTeam) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.favoriteTeam = favoriteTeam;
    }

    public int getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getFavoriteTeam() { return favoriteTeam; }

    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setFavoriteTeam(String favoriteTeam) { this.favoriteTeam = favoriteTeam; }
}
