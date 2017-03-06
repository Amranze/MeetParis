package fr.amrane.amranetest.account.model;

import java.util.List;

/**
 * Created by Amrane Ait Zeouay on 28-Feb-17.
 */

public class Details {
    private String aboutMe;
    private List<String> interestedPreference;
    private List<String> interstedIn;
    private RelationShipStatus relationshipStatus;
    //appearance should be like height, body format
    private List<String> appearance;
    private ChildrenStatus hasChildren;
    private LivingSituation livingSituation;
    private EducationStatus education;
    private ProfessionStatus profession;
    private RelagionStatus religion;
    private List<String> languages;
    private Habbits habbits;
    private String hobbies;

    public Details(String aboutMe, List<String> interestedPreference,
                   List<String> interstedIn, RelationShipStatus relationshipStatus,
                   List<String> appearance, ChildrenStatus hasChildren,
                   LivingSituation livingSituation, EducationStatus education,
                   ProfessionStatus profession, RelagionStatus religion,
                   List<String> languages, Habbits habbits, String hobbies) {
        super();
        this.aboutMe = aboutMe;
        this.interestedPreference = interestedPreference;
        this.interstedIn = interstedIn;
        this.relationshipStatus = relationshipStatus;
        this.appearance = appearance;
        this.hasChildren = hasChildren;
        this.livingSituation = livingSituation;
        this.education = education;
        this.profession = profession;
        this.religion = religion;
        this.languages = languages;
        this.habbits = habbits;
        this.hobbies = hobbies;
    }


    public Details() {
    }


    @Override
    public String toString() {
        return "Details [aboutMe=" + aboutMe + ", interestedPreference="
                + interestedPreference + ", interstedIn=" + interstedIn
                + ", relationshipStatus=" + relationshipStatus
                + ", appearance=" + appearance + ", hasChildren=" + hasChildren
                + ", livingSituation=" + livingSituation + ", education="
                + education + ", profession=" + profession + ", religion="
                + religion + ", languages=" + languages + ", habbits="
                + habbits + ", hobbies=" + hobbies + "]";
    }

    public String getAboutMe() {
        return aboutMe;
    }
    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }
    public List<String> getInterestedPreference() {
        return interestedPreference;
    }


    public void setInterestedPreference(List<String> interestedPreference) {
        this.interestedPreference = interestedPreference;
    }


    public List<String> getInterstedIn() {
        return interstedIn;
    }


    public void setInterstedIn(List<String> interstedIn) {
        this.interstedIn = interstedIn;
    }


    public RelationShipStatus getRelationshipStatus() {
        return relationshipStatus;
    }


    public void setRelationshipStatus(RelationShipStatus relationshipStatus) {
        this.relationshipStatus = relationshipStatus;
    }


    public List<String> getAppearance() {
        return appearance;
    }


    public void setAppearance(List<String> appearance) {
        this.appearance = appearance;
    }


    public ChildrenStatus getHasChildren() {
        return hasChildren;
    }


    public void setHasChildren(ChildrenStatus hasChildren) {
        this.hasChildren = hasChildren;
    }


    public LivingSituation getLivingSituation() {
        return livingSituation;
    }


    public void setLivingSituation(LivingSituation livingSituation) {
        this.livingSituation = livingSituation;
    }


    public EducationStatus getEducation() {
        return education;
    }


    public void setEducation(EducationStatus education) {
        this.education = education;
    }


    public ProfessionStatus getProfession() {
        return profession;
    }


    public void setProfession(ProfessionStatus profession) {
        this.profession = profession;
    }


    public RelagionStatus getReligion() {
        return religion;
    }


    public void setReligion(RelagionStatus religion) {
        this.religion = religion;
    }


    public List<String> getLanguages() {
        return languages;
    }


    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }


    public Habbits getHabbits() {
        return habbits;
    }


    public void setHabbits(Habbits habbits) {
        this.habbits = habbits;
    }


    public String getHobbies() {
        return hobbies;
    }


    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public enum Gender{
        MAN,
        WOMAN,
        BOTH,
        OTHER,
    }
    public enum Habbits{
        NORESPONSE,
        NOTHING,
        SMOKING,
        ALCOHOLIC,
        DRUG
    }
    public enum Hobbies{
        SWIMMING,
        FOOTBALL,
        CHESS
    }
    public enum RelagionStatus{
        NORESPONSE,
        NOTRELIGIOUS,
        ATHESIT,
        SPIRITUAL,
        BUDDHIST,
        TOIST,
        PROTESTANT,
        HINDU,
        JEWISH,
        CATHOLIC,
        MUSLIM,
        OTHER
    }
    public enum ProfessionStatus{
        NORESPONSE,
        UNEMPLOYED,
        APPRENTICE,
        EMPLOYEE,
        CIVILSERVANT,
        HOMEMAKER,
        RETIRED,
        SELFEMPLOYED,
        STUDENT,
    }
    public enum EducationStatus{
        NORESPONSE,
        NOTFINISHED,
        APPRENTICESHIP,
        HIGHSCHOOL,
        HIGHSCHOOLDIPLOMA,
        UNIVERSITY,
        POSTGRADUATE
    }

    public enum LivingSituation{
        NORESPONSE,
        ALONE,
        PARENTS,
        SWEETHEART,
        DORM,
        SHAREDFLAT
    }
    public enum ChildrenStatus{
        NORESPONSE,
        NOCHILDREN,
        LIVINGATHOME,
        NOTLIVINGATHOME
    }
    public enum RelationShipStatus {
        NORESPONSE,
        SINGLE,
        HAVINGARELATION,
        OPENRELATION,
        INARELATIONSHIP,
        MARRIED,
        COMPLICATED
		/*"No response"(0),
		"Single" (1),
		"Having a romantic relation" (2),
		"Open relationship" (3),
		"In a relationship" (4),
		"Married" (5),
		"It's complicated" (6);

		private final int status;

		private RelationShipStatus(int status){
			this.status = status;
		}
		public int getStatus(){
			return status;
		}*/
    }

}