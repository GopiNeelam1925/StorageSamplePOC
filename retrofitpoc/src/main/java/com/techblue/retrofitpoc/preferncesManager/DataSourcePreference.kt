package com.techblue.retrofitpoc.preferncesManager

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

private val Context.dataStore by preferencesDataStore("user_preferences")

@Singleton
class DataSourcePreference @Inject constructor(context: Context) {

    val dataStore = context.dataStore

    val getAllPreferences = dataStore.data
        .catch { exception ->
            if (exception is IOException) {

            }
        }
        .map { preferences ->
            val sampleString = preferences[PreferencesKeys.SAMPLE_STRING] ?: "Default String"
            val sampleBoolean = preferences[PreferencesKeys.SAMPLE_BOOLEAN] ?: false

            Pair(sampleString, sampleBoolean)
        }

    fun getSampleString(): Flow<String> {
        return dataStore.data.map { preferences ->
            val sampleString = preferences[PreferencesKeys.SAMPLE_STRING] ?: "Default String"
            sampleString
        }
    }

    suspend fun updateSampleString(string: String) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.SAMPLE_STRING] = string
        }
    }

    suspend fun updateSampleBoolean(boolean: Boolean) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.SAMPLE_BOOLEAN] = boolean
        }
    }


    private object PreferencesKeys {
        val SAMPLE_STRING = stringPreferencesKey("sample_string");
        val SAMPLE_BOOLEAN = booleanPreferencesKey("sample_boolean");
    }

}