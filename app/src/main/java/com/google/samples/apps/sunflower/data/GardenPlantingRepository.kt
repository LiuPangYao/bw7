/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.samples.apps.sunflower.data

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GardenPlantingRepository @Inject constructor(
    private val gardenPlantingDao: GardenPlantingDao
) {

    suspend fun createGardenPlanting(plantId: String) {

        val gardenPlanting:GardenPlanting
        when (plantId) {
            "BW7-Moss" -> {
                gardenPlanting = GardenPlanting(plantId, "2021-06-11", "2021-06-11")
            }
            "BW7-變形金剛柯博文" -> {
                gardenPlanting = GardenPlanting(plantId, "2021-05-02", "2021-05-02")
            }
            "BW7-原子小金剛" -> {
                gardenPlanting = GardenPlanting(plantId, "2021-01-30", "2021-01-30")
            }
            "BW7-變形金剛大黃蜂" -> {
                gardenPlanting = GardenPlanting(plantId, "2020-12-20", "2020-12-20")
            }
            "BW7-巴斯光年" -> {
                gardenPlanting = GardenPlanting(plantId, "2020-10-21", "2020-10-21")
            }
            "BW7-紅" -> {
                gardenPlanting = GardenPlanting(plantId, "2019-12-25", "2019-12-25")
            }
            "BW7-綠" -> {
                gardenPlanting = GardenPlanting(plantId, "2019-12-20", "2019-12-20")
            }
            else -> {
                gardenPlanting = GardenPlanting(plantId, "unknow", "unknow")
            }
        }

        gardenPlantingDao.insertGardenPlanting(gardenPlanting)
    }

    private fun switch(plantId: String, function: () -> Nothing) {

    }

    suspend fun removeGardenPlanting(gardenPlanting: GardenPlanting) {
        gardenPlantingDao.deleteGardenPlanting(gardenPlanting)
    }

    fun isPlanted(plantId: String) =
        gardenPlantingDao.isPlanted(plantId)

    fun getPlantedGardens() = gardenPlantingDao.getPlantedGardens()
}
