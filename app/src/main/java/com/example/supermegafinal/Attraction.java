package com.example.supermegafinal;

import android.os.Parcel;
import android.os.Parcelable;

import java.time.Duration;

public class Attraction implements Parcelable {

    private String name;
    private String description;
    private String longDescription;
    private double latitude;
    private double longitude;

    private Duration exhibitionDuration;

    public Attraction(String name, String description,String longDescription, double latitude, double longitude, Duration exhibitionDuration) {
        this.name = name;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
        this.longDescription = longDescription;
        this.exhibitionDuration = exhibitionDuration;
    }

    protected Attraction(Parcel in) {
        name = in.readString();
        description = in.readString();
        longDescription = in.readString();
        latitude = in.readDouble();
        longitude = in.readDouble();
        long exhibitionDurationSeconds = in.readLong();
        exhibitionDuration = Duration.ofSeconds(exhibitionDurationSeconds);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(description);
        dest.writeString(longDescription);
        dest.writeDouble(latitude);
        dest.writeDouble(longitude);
        dest.writeLong(exhibitionDuration.getSeconds());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Attraction> CREATOR = new Creator<Attraction>() {
        @Override
        public Attraction createFromParcel(Parcel in) {
            return new Attraction(in);
        }

        @Override
        public Attraction[] newArray(int size) {
            return new Attraction[size];
        }
    };

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getLongDescription() {
        return longDescription;
    }
    public Duration getExhibitionDuration() {
        return exhibitionDuration;
    }

}