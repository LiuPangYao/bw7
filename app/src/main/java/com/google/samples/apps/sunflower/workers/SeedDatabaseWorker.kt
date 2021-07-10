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

            val toy_1: Plant = Plant("BW7-Moss", "BW7-Moss", "本次全新 BW-7 MOSS 版本,加入青苔元素,除了原有的舊化厚實質感外,也有著融入大自然,展現生命力的一面.", 2400, 2400, "https://imgur.com/zW4Ap3X.png", 9,"R.drawable.bw09", 1)
            val toy_2: Plant = Plant("BW7-原子小金剛", "BW7-原子小金剛", "原子小金剛配色,本次全新 BW-7 Power 版本,除了原有的舊化厚實質感外,也展現了十足力量感.", 2600, 2600, "https://imgur.com/1QOZdzV.png", 7, "R.drawable.bw07", 1)
            val toy_3: Plant = Plant("BW7-柯博文", "BW7-柯博文", "變形金剛柯博文配色,本次全新 BW-7 MR 版本,除了原有的舊化厚實質感外,也展現了帥氣的機器人造型.", 2600, 2600, "https://imgur.com/9s4luw2.png", 8,"R.drawable.bw08", 1)
            val toy_4: Plant = Plant("BW7-大黃蜂", "BW7-大黃蜂", "2020 TTF 會場限定版,變形金剛大黃蜂配色.", 2500, 2500, "https://imgur.com/pASuuVN.png", 6,"R.drawable.bw06", 1)
            val toy_5: Plant = Plant("BW7-巴斯光年", "BW7-巴斯光年", "玩具總動員巴斯光年配色,BW-7 Robot Ver.4 宇宙版本,除了原有的舊化厚實質感,也帶出十足的宇宙感,猶如要奔向外太空般的氣勢.", 2600, 2600, "https://imgur.com/bMDWcpI.png", 4,"R.drawable.bw04", 1)
            val toy_6: Plant = Plant("BW7-復仇者聯盟", "BW7-復仇者聯盟", "胸口紅色寶石,搭配藍寶石手套.", 2500, 2500, "https://imgur.com/9DxxmxR.png", 5,"R.drawable.bw05", 1)
            val toy_7: Plant = Plant("BW7-紅", "BW7-紅", "紅,藍,綠 3色早期作品,BW-7 Robot 紅色聖誕版本,除了原有的舊化厚實質感,這次應景了聖誕氣氛,以鮮豔的紅色,整體配色較為繽紛豐富,還有附上可愛白色小毛球可隨意搭配,像是聖誕老公公一般帶給大家祝福!", 2500, 2500, "https://imgur.com/AAI9dn3.png",3, "R.drawable.bw03", 1)
            val toy_8: Plant = Plant("BW7-綠", "BW7-綠", "紅,藍,綠 3色早期作品,Monster Taipei 20週年紀念版-軟膠公仔.", 2200, 2200, "https://imgur.com/nAbEfEw.png", 1,"R.drawable.bw01", 1)
            val toy_9: Plant = Plant("BW7-藍", "BW7-藍", "紅,藍,綠 3色早期作品.", 2500, 2500, "https://imgur.com/nAbEfEw.png", 2,"R.drawable.bw02", 1)
            val toy_10: Plant = Plant("BW7-透明", "BW7-透明", "未販售,透明版.", 2500, 2500, "https://imgur.com/nAbEfEw.png", 0,"", 4)
            val toy_11: Plant = Plant("BW7-GID", "BW7-GID", "帥氣的夜光款設計師軟膠,超限定版本.", 2700, 2700, "https://imgur.com/ZVR8rcc.png", 10, "R.drawable.bw10", 1)

            val plantList: MutableList<Plant>  = mutableListOf()
            plantList.add(toy_10)
            plantList.add(toy_8)
            plantList.add(toy_9)
            plantList.add(toy_7)
            plantList.add(toy_5)
            plantList.add(toy_6)
            plantList.add(toy_4)
            plantList.add(toy_3)
            plantList.add(toy_2)
            plantList.add(toy_1)
            plantList.add(toy_11)

            // 20210627 add new data into database
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
