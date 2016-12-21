package io.github.randatic.collegeapp.Model;

/**
 * Created by Randy Bruner on 12/13/16.
 */
public class Guardian extends FamilyMember {
    private String occupation;

    public Guardian (String firstName, String lastName, String occupation) {
        super(firstName, lastName);
        this.occupation = occupation;
    }

    public Guardian (String firstName, String lastName) {
        super(firstName, lastName);
        this.occupation = "NONE";
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}
