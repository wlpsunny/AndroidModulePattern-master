package com.guiying.module.common.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2019/3/27.
 */

public class Test implements Parcelable {
    public Test(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private String name;
    private int age;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.age);
    }

    protected Test(Parcel in) {
        this.name = in.readString();
        this.age = in.readInt();
    }

    public static final Parcelable.Creator<Test> CREATOR = new Parcelable.Creator<Test>() {
        @Override
        public Test createFromParcel(Parcel source) {
            return new Test(source);
        }

        @Override
        public Test[] newArray(int size) {
            return new Test[size];
        }
    };

    @Override
    public String toString() {
        return "name='" + name  + ", age=" + age;
    }
}
