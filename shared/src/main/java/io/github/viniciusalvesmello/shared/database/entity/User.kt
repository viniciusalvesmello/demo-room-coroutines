package io.github.viniciusalvesmello.shared.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "email") val email: String?,
    @ColumnInfo(name = "name") val name: String?
)