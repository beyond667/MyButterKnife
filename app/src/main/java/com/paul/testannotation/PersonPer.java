package com.paul.testannotation;

import android.os.Parcel;
import android.os.Parcelable;

public class PersonPer  implements Parcelable {
    public String name;
    public int age;
    protected PersonPer(Parcel in) {
        name = in.readString();
        age = in.readInt();
    }

    public PersonPer() {
    }

    public static final Creator<PersonPer> CREATOR = new Creator<PersonPer>() {
        @Override
        public PersonPer createFromParcel(Parcel in) {
            return new PersonPer(in);
        }

        @Override
        public PersonPer[] newArray(int size) {
            return new PersonPer[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
    }
}
