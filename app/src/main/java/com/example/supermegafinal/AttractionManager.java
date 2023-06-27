package com.example.supermegafinal;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class AttractionManager {
    private List<Attraction> attractions;
    private Duration travelTime;

    public AttractionManager(Duration travelTime) {
        attractions = new ArrayList<>();
        this.travelTime = travelTime;
    }

    public void addAttraction(Attraction attraction) {
        attractions.add(attraction);
    }

    public ArrayList<Attraction> getBestPathForTour() {
        ArrayList<Attraction> bestPath = new ArrayList<>();
        Duration availableTime = Duration.ofHours(24);
        Duration currentTime = Duration.ZERO;

        while (!attractions.isEmpty()) {
            Attraction nextAttraction = null;
            Duration maxExhibitionDuration = Duration.ZERO;

            for (Attraction attraction : attractions) {
                Duration totalDuration = currentTime.plus(attraction.getExhibitionDuration()).plus(travelTime);
                if (totalDuration.compareTo(availableTime) <= 0 && attraction.getExhibitionDuration().compareTo(maxExhibitionDuration) > 0) {
                    nextAttraction = attraction;
                    maxExhibitionDuration = attraction.getExhibitionDuration();
                }
            }

            if (nextAttraction != null) {
                currentTime = currentTime.plus(nextAttraction.getExhibitionDuration()).plus(travelTime);
                bestPath.add(nextAttraction);
                attractions.remove(nextAttraction);
            } else {
                break;
            }
        }

        return bestPath;
    }
}