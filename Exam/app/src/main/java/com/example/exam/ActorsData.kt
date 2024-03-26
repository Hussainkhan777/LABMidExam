package com.example.exam

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.res.stringArrayResource
import com.example.lab_03.ActorDataClass

@Composable
fun RetrieveActorsData(): SnapshotStateList<ActorDataClass> {

    val actors = stringArrayResource(id = R.array.friend_names)
    val actors_details = stringArrayResource(id = R.array.friend_details)
    val actors_images = arrayOf(
        R.drawable.chandler,
        R.drawable.joey,
        R.drawable.monica,
        R.drawable.phoebe,
        R.drawable.rachel,
        R.drawable.ross
    )

    val actors_image_preview = arrayOf(
        R.drawable.chandlerpreview,
        R.drawable.joeypreview,
        R.drawable.monicapreview,
        R.drawable.phoebepreview,
        R.drawable.rachelpreview,
        R.drawable.rosspreview
    )

    val actorsModalList = remember {

        mutableStateListOf<ActorDataClass>(
            ActorDataClass(
                1,
                actors[0],
                0,
                actors_details[0],
                actors_images[0],
                actors_image_preview[0]
            ),
            ActorDataClass(
                2,
                actors[1],
                0,
                actors_details[1],
                actors_images[1],
                actors_image_preview[1]
            ),
            ActorDataClass(
                3,
                actors[2],
                0,
                actors_details[2],
                actors_images[2],
                actors_image_preview[2]
            ),
            ActorDataClass(
                4,
                actors[3],
                0,
                actors_details[3],
                actors_images[3],
                actors_image_preview[3]
            ),
            ActorDataClass(
                5,
                actors[4],
                0,
                actors_details[4],
                actors_images[4],
                actors_image_preview[4]
            ),
            ActorDataClass(
                6,
                actors[5],
                0,
                actors_details[5],
                actors_images[5],
                actors_image_preview[5]
            )

        )
    }

    return actorsModalList
}