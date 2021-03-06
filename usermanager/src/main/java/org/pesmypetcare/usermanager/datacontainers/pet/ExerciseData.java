package org.pesmypetcare.usermanager.datacontainers.pet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Marc Simó
 */
public class ExerciseData {
    private static final String LATITUDE = "latitude";
    private static final String LONGITUDE = "longitude";
    private String name;
    private String description;
    private List<Map<String, Double>> coordinates;
    private String endDateTime;

    /**
     * ExerciseData constructor.
     */
    public ExerciseData() {
    }

    /**
     * ExerciseData constructor.
     *
     * @param name name
     * @param description description
     * @param endDateTime endDateTime
     */
    public ExerciseData(String name, String description, String endDateTime) {
        PetData.checkDateFormat(endDateTime);
        this.name = name;
        this.description = description;
        this.endDateTime = endDateTime;
        this.coordinates = new ArrayList<>();
    }

    /**
     * ExerciseData constructor.
     *
     * @param name name
     * @param description description
     * @param endDateTime endDateTime
     * @param coordinates coordinates
     */
    public ExerciseData(String name, String description, String endDateTime, @NonNull List<LatLng> coordinates) {
        PetData.checkDateFormat(endDateTime);
        this.name = name;
        this.description = description;
        this.endDateTime = endDateTime;
        this.coordinates = new ArrayList<>();
        for (LatLng lat : coordinates) {
            if (lat != null) {
                Map<String, Double> point = new HashMap<>();
                point.put(LATITUDE, lat.latitude);
                point.put(LONGITUDE, lat.longitude);
                this.coordinates.add(point);
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(String endDateTime) {
        this.endDateTime = endDateTime;
    }

    /**
     * Gets the exercise coordinates as a LatLng list.
     *
     * @return List containing the coordinates
     */
    public List<LatLng> getCoordinates() {
        Double latitude;
        Double longitude;
        List<LatLng> response = new ArrayList<>();
        for (Map<String, Double> point : this.coordinates) {
            latitude = point.get(LATITUDE);
            longitude = point.get(LONGITUDE);
            if (latitude != null && longitude != null) {
                response.add(new LatLng(latitude, longitude));
            }
        }
        return response;
    }

    /**
     * Sets the exercise coordinates.
     *
     * @param coordinates Coordinates values
     */
    public void setCoordinates(@NonNull List<LatLng> coordinates) {
        this.coordinates = new ArrayList<>();
        for (LatLng lat : coordinates) {
            if (lat != null) {
                Map<String, Double> point = new HashMap<>();
                point.put(LATITUDE, lat.latitude);
                point.put(LONGITUDE, lat.longitude);
                this.coordinates.add(point);
            }
        }
    }

    /**
     * Turns the ExerciseData into a Map of key String and element Object.
     *
     * @return ExerciseData turned into map
     */
    public Map<String, Object> getAsMap() {
        Map<String, Object> response = new HashMap<>();
        response.put("endDateTime", endDateTime);
        response.put("name", name);
        response.put("description", description);
        response.put("coordinates", coordinates);
        return response;
    }

    @NonNull
    @Override
    public String toString() {
        return "{" + "name='" + name + '\'' + ", description='" + description + '\'' + ", endDateTime='" + endDateTime
                + '\'' + ", coordinates=" + coordinates + '}';
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof ExerciseData) {
            return ((ExerciseData) obj).getName().equals(this.getName()) && ((ExerciseData) obj).getDescription()
                    .equals(this.getDescription()) && ((ExerciseData) obj).getEndDateTime().equals(
                    this.getEndDateTime()) && ((ExerciseData) obj).getCoordinates().equals(this.getCoordinates());
        }
        return false;
    }
}
