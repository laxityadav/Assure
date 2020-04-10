package com.example.covid19;

import android.os.Parcel;
import android.os.Parcelable;

public class Utils implements Parcelable {
    private String name, phoneNo, emailId, Address;
    private boolean isFever, isCough, isCorona, isShortBreath;
    private int feverDays, coughDays;
    private int temperature, breathingRate;
    private String typeCough;


    public Utils() {
        this.name = "";
        this.phoneNo = "";
        this.emailId = "";
        this.Address = "";
        this.typeCough = "";
        this.isFever = false;
        this.isCough = false;
        this.isCorona = false;
        this.isShortBreath = false;
        this.feverDays = 0;
        this.coughDays = 0;
        this.temperature = 0;
        this.breathingRate = 0;
    }

    protected Utils(Parcel in) {
        name = in.readString();
        phoneNo = in.readString();
        emailId = in.readString();
        Address = in.readString();
        isFever = in.readByte() != 0;
        isCough = in.readByte() != 0;
        isCorona = in.readByte() != 0;
        isShortBreath = in.readByte() != 0;
        feverDays = in.readInt();
        coughDays = in.readInt();
        temperature = in.readInt();
        breathingRate = in.readInt();
        typeCough = in.readString();
    }

    public static final Creator<Utils> CREATOR = new Creator<Utils>() {
        @Override
        public Utils createFromParcel(Parcel in) {
            return new Utils(in);
        }

        @Override
        public Utils[] newArray(int size) {
            return new Utils[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(phoneNo);
        parcel.writeString(emailId);
        parcel.writeString(Address);
        parcel.writeByte((byte) (isFever ? 1 : 0));
        parcel.writeByte((byte) (isCough ? 1 : 0));
        parcel.writeByte((byte) (isCorona ? 1 : 0));
        parcel.writeByte((byte) (isShortBreath ? 1 : 0));
        parcel.writeInt(feverDays);
        parcel.writeInt(coughDays);
        parcel.writeInt(temperature);
        parcel.writeInt(breathingRate);
        parcel.writeString(typeCough);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public boolean isFever() {
        return isFever;
    }

    public void setFever(boolean fever) {
        isFever = fever;
    }

    public boolean isCough() {
        return isCough;
    }

    public void setCough(boolean cough) {
        isCough = cough;
    }

    public boolean isCorona() {
        return isCorona;
    }

    public void setCorona(boolean corona) {
        isCorona = corona;
    }

    public boolean isShortBreath() {
        return isShortBreath;
    }

    public void setShortBreath(boolean shortBreath) {
        isShortBreath = shortBreath;
    }

    public int getFeverDays() {
        return feverDays;
    }

    public void setFeverDays(int feverDays) {
        this.feverDays = feverDays;
    }

    public int getCoughDays() {
        return coughDays;
    }

    public void setCoughDays(int coughDays) {
        this.coughDays = coughDays;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getBreathingRate() {
        return breathingRate;
    }

    public void setBreathingRate(int breathingRate) {
        this.breathingRate = breathingRate;
    }

    public String getTypeCough() {
        return typeCough;
    }

    public void setTypeCough(String typeCough) {
        this.typeCough = typeCough;
    }

    @Override
    public String toString() {
        return "Utils{" +
                "name='" + name + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", emailId='" + emailId + '\'' +
                ", Address='" + Address + '\'' +
                ", isFever=" + isFever +
                ", isCough=" + isCough +
                ", isCorona=" + isCorona +
                ", isShortBreath=" + isShortBreath +
                ", feverDays=" + feverDays +
                ", coughDays=" + coughDays +
                ", temperature=" + temperature +
                ", breathingRate=" + breathingRate +
                ", typeCough='" + typeCough + '\'' +
                '}';
    }
}
