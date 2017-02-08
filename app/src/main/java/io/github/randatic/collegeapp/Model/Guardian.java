package io.github.randatic.collegeapp.Model;

/**
 * Created by Randy Bruner on 12/13/16.
 */
public class Guardian extends FamilyMember {
    private String occupation;

    public Guardian () {
        super("Berry", "Benson");
        this.occupation = "NONE";
    }

    public Guardian (String firstName, String lastName, String occupation) {
        super(firstName, lastName);
        this.occupation = occupation;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}
