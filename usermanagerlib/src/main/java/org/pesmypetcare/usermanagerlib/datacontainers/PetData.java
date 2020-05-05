package org.pesmypetcare.usermanagerlib.datacontainers;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Map;

/**
 * @author Santiago Del Rey
 */
public class PetData {
    public static final String GENDER = "gender";
    public static final String BIRTH = "birth";
    public static final String BREED = "breed";
    public static final String PATHOLOGIES = "pathologies";
    public static final String RECOMMENDED_KCAL = "recommendedKcal";
    public static final String NEEDS = "needs";
    private GenderType gender;
    private String breed;
    private String birth;
    private String pathologies;
    private String needs;
    private Double recommendedKcal;

    /**
     * The method that returns the pet gender.
     * @return The pet's gender
     */
    public GenderType getGender() {
        return gender;
    }

    /**
     * The method that set the pet gender.
     * @param gender The pet's gender
     */
    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    /**
     * The method that returns the pet breed.
     * @return The pet's breed
     */
    public String getBreed() {
        return breed;
    }

    /**
     * The method that set the pet breed.
     * @param breed The pet's breed
     */
    public void setBreed(String breed) {
        this.breed = breed;
    }

    /**
     * The method that returns the pet birth.
     * @return The pet's birth
     */
    public String getBirth() {
        return birth;
    }

    /**
     * The method that set the pet birth.
     * @param birth The pet's birth
     */
    public void setBirth(String birth) {
        checkDateFormat(birth);
        this.birth = birth;
    }

    /**
     * The method that returns the pet needs.
     * @return The pet's needs
     */
    public String getNeeds() {
        return needs;
    }

    /**
     * The method that set the pet needs.
     * @param needs The pet's needs
     */
    public void setNeeds(String needs) {
        this.needs = needs;
    }

    /**
     * The method that returns the pet pathologies.
     * @return The pet's pathologies
     */
    public String getPathologies() {
        return pathologies;
    }

    /**
     * The method that set the pet pathologies.
     * @param pathologies The pet's pathologies
     */
    public void setPathologies(String pathologies) {
        this.pathologies = pathologies;
    }

    /**
     * The method that returns the pet recommended kcal.
     * @return The pet's recommended kcal
     */
    public Double getRecommendedKcal() {
        return recommendedKcal;
    }

    /**
     * The method that set the pet recommended kcal.
     * @param recommendedKcal The pet's recommended kcal
     */
    public void setRecommendedKcal(Double recommendedKcal) {
        this.recommendedKcal = recommendedKcal;
    }

    /**
     * Checks that field has the correct format for a Pet simple attribute.
     * @param field Name of the attribute.
     */
    public static void checkSimpleField(String field) {
        if (!GENDER.equals(field) && !BREED.equals(field) && !BIRTH.equals(field)
            && !PATHOLOGIES.equals(field) && !NEEDS.equals(field) && !RECOMMENDED_KCAL.equals(field)) {
            throw new IllegalArgumentException("Field does not exists");
        }
    }

    /**
     * Checks that the field and the new value for this field have the correct format for a Pet simple attribute.
     * @param field Name of the attribute.
     * @param newValue Value of the attribute.
     */
    public static void checkSimpleFieldAndValues(String field, Object newValue) {
        if ((field.equals(BIRTH) || field.equals(BREED) || (field.equals(PATHOLOGIES)
            || field.equals(NEEDS))) && !(newValue instanceof String)) {
            throw new IllegalArgumentException("New value must be a String");
        } else if (field.equals(RECOMMENDED_KCAL) && !(newValue instanceof Double)) {
            throw new IllegalArgumentException("New value must be a Double");
        } else if (field.equals(GENDER) && !(newValue instanceof GenderType)) {
            throw new IllegalArgumentException("New value must be a GenderType");
        }
    }

    /**
     * Checks that field has the correct format for a Pet collection attribute.
     * @param field Name of the attribute collection. Possible fields: meals, trainings, washes, weights
     */
    public static void checkCollectionField(String field) {
        if (!"meals".equals(field) && !"trainings".equals(field) && !"washes".equals(field)
            && !"weights".equals(field)) {
            throw new IllegalArgumentException("Field does not exists");
        }
    }

    /**
     * Checks that field, key and body have the correct format of a Pet attribute.
     * @param field Name of the attribute collection. Possible fields: meals, trainings, washes, weights
     * @param key Key of the attribute
     * @param body Body of the attribute
     */
    public static void checkCollectionKeyAndBody(String field, String key, Map<String, Object> body) {
        switch (field) {
            case "meals":
                checkMeals(key, body);
                break;
            case "trainings":
            case "washes":
            case "weights":
                checkDateAndValueInteger(key, body);
                break;
            default:
                throw new IllegalArgumentException("Field does not exists");
        }
    }

    /**
     * Checks that key and body have the correct format for a meal.
     * @param key Key of the attribute
     * @param body Body of the attribute
     */
    public static void checkMeals(String key, Map<String, Object> body) {
        checkDateFormat(key);
        if (body.size() != 2 || !body.containsKey("kcal") || !body.containsKey("mealName")) {
            throw new IllegalArgumentException("Request body does not have a correct format");
        }
        if (!(body.get("kcal") instanceof Double) || !(body.get("mealName") instanceof String)) {
            throw new IllegalArgumentException("Request body does not have a correct format");
        }
    }

    /**
     * Checks that key and body have the correct format for a date key and body with one element whose key is 'value'
     * and has an Object of type Integer.
     * @param key Key of the attribute
     * @param body Body of the attribute
     */
    public static void checkDateAndValueInteger(String key, Map<String, Object> body) {
        checkDateFormat(key);
        if (body.size() != 1 || !body.containsKey("value")) {
            throw new IllegalArgumentException("Request body does not have a correct format");
        }
        if (!(body.get("value") instanceof Integer)) {
            throw new IllegalArgumentException("Request body does not have a correct format");
        }
    }

    /**
     * Checks that the string date follows the specified .
     * @param date String that contains a date
     */
    public static void checkDateFormat(String date) {
        if (!date.matches("\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}")) {
            throw new IllegalArgumentException("Incorrect date format");
        }
    }

    @NonNull
    @Override
    public String toString() {
        return "{"
            + "gender=" + gender
            + ", breed='" + breed + '\''
            + ", birth=" + birth
            + ", pathologies='" + pathologies + '\''
            + ", needs='" + needs + '\''
            + ", recommendedKcal=" + recommendedKcal
            + '}';
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof PetData) {
            return ((PetData) obj).getBirth().equals(this.getBirth())
                && ((PetData) obj).getBreed().equals(this.getBreed())
                && ((PetData) obj).getGender() == this.getGender()
                && ((PetData) obj).getPathologies().equals(this.getPathologies())
                && ((PetData) obj).getRecommendedKcal().equals(this.getRecommendedKcal())
                && ((PetData) obj).getNeeds().equals(this.getNeeds());
        }
        return false;
    }
}
