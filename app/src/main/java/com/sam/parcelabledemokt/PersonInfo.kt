package com.sam.parcelabledemokt

import android.os.Parcel
import android.os.Parcelable

data class PersonInfo(val name:String? ,val surname:String?) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    )
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(surname)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PersonInfo> {
        override fun createFromParcel(parcel: Parcel): PersonInfo {
            return PersonInfo(parcel)
        }

        override fun newArray(size: Int): Array<PersonInfo?> {
            return arrayOfNulls(size)
        }
    }

}