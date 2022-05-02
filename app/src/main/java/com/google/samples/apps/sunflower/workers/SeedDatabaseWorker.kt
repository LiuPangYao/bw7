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

            val toy0: Plant = Plant("BW7-透明", "BW7-透明", "未販售,透明版.", 2500, 2500, "https://imgur.com/nAbEfEw.png", 0,"", 4)
            val toy1: Plant = Plant("BW7-綠", "BW7-綠", "紅,藍,綠 3色早期作品,Monster Taipei 20週年紀念版-軟膠公仔.", 2200, 2200, "https://imgur.com/yfRrPDJ.png", 1,"R.drawable.bw01", 1)
            val toy2: Plant = Plant("BW7-藍", "BW7-藍", "紅,藍,綠 3色早期作品.", 2500, 2500, "https://imgur.com/wHHk3cs.png", 2,"R.drawable.bw02", 1)
            val toy3: Plant = Plant("BW7-紅", "BW7-紅", "紅,藍,綠 3色早期作品,BW-7 Robot 紅色聖誕版本,除了原有的舊化厚實質感,這次應景了聖誕氣氛,以鮮豔的紅色,整體配色較為繽紛豐富,還有附上可愛白色小毛球可隨意搭配,像是聖誕老公公一般帶給大家祝福!", 2500, 2500, "https://imgur.com/AAI9dn3.png",3, "R.drawable.bw03", 1)
            val toy4: Plant = Plant("BW7-巴斯光年", "BW7-巴斯光年", "玩具總動員巴斯光年配色,BW-7 Robot Ver.4 宇宙版本,除了原有的舊化厚實質感,也帶出十足的宇宙感,猶如要奔向外太空般的氣勢.", 2600, 2600, "https://imgur.com/bMDWcpI.png", 4,"R.drawable.bw04", 1)
            val toy5: Plant = Plant("BW7-復仇者聯盟", "BW7-復仇者聯盟", "胸口紅色寶石,搭配藍寶石手套.", 2500, 2500, "https://imgur.com/9DxxmxR.png", 5,"R.drawable.bw05", 1)
            val toy6: Plant = Plant("BW7-大黃蜂", "BW7-大黃蜂", "2020 TTF 會場限定版,變形金剛大黃蜂配色.", 2500, 2500, "https://imgur.com/pASuuVN.png", 6,"R.drawable.bw06", 1)
            val toy7: Plant = Plant("BW7-原子小金剛", "BW7-原子小金剛", "原子小金剛配色,本次全新 BW-7 Power 版本,除了原有的舊化厚實質感外,也展現了十足力量感.", 2600, 2600, "https://imgur.com/1QOZdzV.png", 7, "R.drawable.bw07", 1)
            val toy8: Plant = Plant("BW7-柯博文", "BW7-柯博文", "變形金剛柯博文配色,本次全新 BW-7 MR 版本,除了原有的舊化厚實質感外,也展現了帥氣的機器人造型.", 2600, 2600, "https://imgur.com/9s4luw2.png", 8,"R.drawable.bw08", 1)
            val toy9: Plant = Plant("BW7-Moss", "BW7-Moss", "本次全新 BW-7 MOSS 版本,加入青苔元素,除了原有的舊化厚實質感外,也有著融入大自然,展現生命力的一面.", 2400, 2400, "https://imgur.com/zW4Ap3X.png", 9,"R.drawable.bw09", 1)
            val toy10: Plant = Plant("BW7-GID", "BW7-GID", "帥氣的夜光款設計師軟膠,超限定版本.", 2700, 2700, "https://imgur.com/ZVR8rcc.png", 10, "R.drawable.bw10", 1)
            val toy11: Plant = Plant("BW7-戰士", "BW7-戰士", "本次全新 BW-7 戰士版本，加入鋼彈的元素，除了原有的舊化厚實質感外，也展現帥氣的機器人一面.", 2600, 2600, "https://imgur.com/gC52tIH.png", 11, "R.drawable.bw11", 1)
            val toy12: Plant = Plant("BW7-金剛", "BW7-金剛", "全新推出 BW-7 金剛 Monster Taipei 限定版，加入鐵金剛元素，除了原有的厚實質感外，也展現帥氣的一面.", 2600, 2600, "https://imgur.com/nAbEfEw.png", 12, "R.drawable.bw11", 1)
            val toy13: Plant = Plant("BW7-英雄", "BW7-英雄", "年末全新推出 BW-7 英雄版本，融入日本英雄角色配色，除展現原有的銀色質感外，也露出即將到來聖誕年節的喜氣。", 2300, 2300, "https://imgur.com/2kmJWmP.png", 13, "R.drawable.bw13", 1)
            val toy14: Plant = Plant("BW7-大鐵人", "BW7-大鐵人", "本次全新 BW-7 大鐵人07 版本，有著亮眼的機器人主題塗裝，也展現了十足力量感。", 2400, 2400, "https://imgur.com/nAbEfEw.png", 14, "R.drawable.bw14", 1)


            val plantList: MutableList<Plant>  = mutableListOf()
            plantList.add(toy0)
            plantList.add(toy1)
            plantList.add(toy2)
            plantList.add(toy3)
            plantList.add(toy4)
            plantList.add(toy5)
            plantList.add(toy6)
            plantList.add(toy7)
            plantList.add(toy8)
            plantList.add(toy9)
            plantList.add(toy10)
            plantList.add(toy11)
            plantList.add(toy12)
            plantList.add(toy13)
            plantList.add(toy14)

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
