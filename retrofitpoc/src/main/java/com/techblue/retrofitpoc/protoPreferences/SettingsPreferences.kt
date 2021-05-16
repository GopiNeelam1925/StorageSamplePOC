package com.techblue.retrofitpoc.protoPreferences

import android.content.Context
import androidx.datastore.core.CorruptionException
import androidx.datastore.core.DataStore
import androidx.datastore.core.Serializer
import androidx.datastore.dataStore
import androidx.datastore.preferences.preferencesDataStore
import androidx.datastore.preferences.protobuf.InvalidProtocolBufferException
import com.techblue.retrofitpoc.User
import java.io.InputStream
import java.io.OutputStream


object SettingsPreferences : Serializer<User> {
    override val defaultValue: User = User.getDefaultInstance()

    @Suppress("BlockingMethodInNonBlockingContext")
    override suspend fun readFrom(input: InputStream): User {
        try {
            return User.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto.", exception)
        }
    }

    @Suppress("BlockingMethodInNonBlockingContext")
    override suspend fun writeTo(t: User, output: OutputStream) = t.writeTo(output)
}

val Context.protoDataStore: DataStore<User>  by dataStore(
    fileName = "settings.proto",
    serializer = SettingsPreferences
)