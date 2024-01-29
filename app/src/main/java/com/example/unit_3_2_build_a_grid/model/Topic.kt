package com.example.unit_3_2_build_a_grid.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val courseTopic: Int,
    val numberOfCourses: Int,
    @DrawableRes val courseImage: Int,
)
