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

    suspend fun createGardenPlanting(plantId: String, dateBuy: String) {

        val gardenPlanting:GardenPlanting
        when (plantId) {
            "BW7-Moss" -> {
                gardenPlanting = GardenPlanting(plantId, "2021-06-11", dateBuy)
            }
            "BW7-柯博文" -> {
                gardenPlanting = GardenPlanting(plantId, "2021-05-02", dateBuy)
            }
            "BW7-原子小金剛" -> {
                gardenPlanting = GardenPlanting(plantId, "2021-01-30", dateBuy)
            }
            "BW7-大黃蜂" -> {
                gardenPlanting = GardenPlanting(plantId, "2020-12-20", dateBuy)
            }
            "BW7-巴斯光年" -> {
                gardenPlanting = GardenPlanting(plantId, "2020-11-01", dateBuy)
            }
            "BW7-復仇者聯盟" -> {
                gardenPlanting = GardenPlanting(plantId, "2020-10-21", dateBuy)
            }
            "BW7-紅" -> {
                gardenPlanting = GardenPlanting(plantId, "2019-12-25", dateBuy)
            }
            "BW7-綠" -> {
                gardenPlanting = GardenPlanting(plantId, "2019-12-20", dateBuy)
            }
            "BW7-藍" -> {
                gardenPlanting = GardenPlanting(plantId, "2019-12-21", dateBuy)
            }
            "BW7-GID" -> {
                gardenPlanting = GardenPlanting(plantId, "2021-07-01", dateBuy)
            }
            else -> {
                gardenPlanting = GardenPlanting(plantId, "unknow", dateBuy)
            }
        }

        gardenPlantingDao.insertGardenPlanting(gardenPlanting)
    }

    private fun switch(plantId: String, function: () -> Nothing) {

    }

    suspend fun removeGardenPlanting(gardenPlanting: GardenPlanting) {
        gardenPlantingDao.deleteGardenPlanting(gardenPlanting)
    }

    suspend fun removeGardenPlantingUseId(plantId: String) {
        gardenPlantingDao.deleteGardenPlantingUseId(plantId)
    }

    fun isPlanted(plantId: String) =
        gardenPlantingDao.isPlanted(plantId)

    fun getPlantedGardens() = gardenPlantingDao.getPlantedGardens()
}
