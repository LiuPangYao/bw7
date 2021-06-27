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

package com.google.samples.apps.sunflower.workers

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.google.samples.apps.sunflower.data.AppDatabase
import com.google.samples.apps.sunflower.data.Plant
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SeedDatabaseWorker(
        context: Context,
        workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {
    override suspend fun doWork(): Result = withContext(Dispatchers.IO) {
        try {
            /*val filename = inputData.getString(KEY_FILENAME)
            if (filename != null) {
                applicationContext.assets.open(filename).use { inputStream ->
                    JsonReader(inputStream.reader()).use { jsonReader ->
                        val plantType = object : TypeToken<List<Plant>>() {}.type

                        val plantList: List<Plant> = Gson().fromJson(jsonReader, plantType)

                        val database = AppDatabase.getInstance(applicationContext)
                        database.plantDao().insertAll(plantList)

                        Result.success()
                    }
                }
            } else {
                Log.e(TAG, "Error seeding database - no valid filename")
                Result.failure()
            }*/

            val toy_1: Plant = Plant("BW7-Moss", "BW7-Moss", "全身佈滿青苔,適合戶外拍照", 2400, 2400, "https://imgur.com/zW4Ap3X.png")
            val toy_2: Plant = Plant("BW7-原子小金剛", "BW7-原子小金剛", "元子小金剛配色", 2600, 2600, "https://imgur.com/1QOZdzV.png")
            val toy_3: Plant = Plant("BW7-變形金剛配色", "BW7-變形金剛配色", "變形金剛-柯博文配色", 2600, 2600, "https://imgur.com/9s4luw2.png")
            val toy_4: Plant = Plant("BW7-變形金剛配色", "BW7-變形金剛配色", "2020 TTF 限定版,變形金剛-大黃蜂配色", 2600, 2600, "https://imgur.com/pASuuVN.png")
            val toy_5: Plant = Plant("BW7-巴斯光年", "BW7-巴斯光年", "玩具總動員巴斯光年配色,搭配翅膀", 2600, 2600, "https://imgur.com/bMDWcpI.png")
            val toy_6: Plant = Plant("BW7-復仇者聯盟", "BW7-復仇者聯盟", "胸口紅色寶石,搭配藍寶石手套", 2500, 2500, "https://imgur.com/9DxxmxR.png")
            val toy_7: Plant = Plant("BW7-紅", "BW7-紅", "紅,藍,綠 3色早期作品", 2500, 2500, "https://imgur.com/AAI9dn3.png")
            val toy_8: Plant = Plant("BW7-綠", "BW7-綠", "紅,藍,綠 3色早期作品", 2500, 2500, "https://imgur.com/nAbEfEw.png")
            val toy_9: Plant = Plant("BW7-藍", "BW7-藍", "紅,藍,綠 3色早期作品", 2500, 2500, "https://imgur.com/nAbEfEw.png")
            val toy_10: Plant = Plant("BW7-透明", "BW7-透明", "未販售 透明版", 2500, 2500, "https://imgur.com/nAbEfEw.png")

            val plantList: MutableList<Plant>  = mutableListOf()

            plantList.add(toy_1)
            plantList.add(toy_2)
            plantList.add(toy_3)
            plantList.add(toy_4)
            plantList.add(toy_5)
            plantList.add(toy_6)
            plantList.add(toy_7)
            plantList.add(toy_8)
            plantList.add(toy_9)
            plantList.add(toy_10)

            //20210627 新增資進進資料庫
            val database = AppDatabase.getInstance(applicationContext)
            database.plantDao().insertAll(plantList)

            Result.success()
        } catch (ex: Exception) {
            Log.e(TAG, "Error seeding database", ex)
            Result.failure()
        }
    }

    companion object {
        private const val TAG = "SeedDatabaseWorker"
        const val KEY_FILENAME = "PLANT_DATA_FILENAME"
    }
}
