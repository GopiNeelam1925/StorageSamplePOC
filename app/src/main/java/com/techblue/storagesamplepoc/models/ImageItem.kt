package com.techblue.storagesamplepoc.models

import android.net.Uri
import java.util.*

data class ImageItem(val id: Long, val name: String, val dateTaken: Date, val uri: Uri)
