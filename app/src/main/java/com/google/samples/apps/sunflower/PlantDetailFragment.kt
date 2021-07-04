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

package com.google.samples.apps.sunflower

import android.app.DatePickerDialog
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.app.ShareCompat
import androidx.core.widget.NestedScrollView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.samples.apps.sunflower.PlantDetailFragment.Callback
import com.google.samples.apps.sunflower.data.Plant
import com.google.samples.apps.sunflower.databinding.FragmentPlantDetailBinding
import com.google.samples.apps.sunflower.viewmodels.PlantDetailViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.*


/**
 * A fragment representing a single Plant detail screen.
 */
@AndroidEntryPoint
class PlantDetailFragment : Fragment() {

    private val plantDetailViewModel: PlantDetailViewModel by viewModels()

    lateinit var manualImage: ImageView
    lateinit var manualTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = DataBindingUtil.inflate<FragmentPlantDetailBinding>(
            inflater,
            R.layout.fragment_plant_detail,
            container,
            false
        ).apply {
            viewModel = plantDetailViewModel
            lifecycleOwner = viewLifecycleOwner
            callback = Callback { plant ->
                plant?.let {
                    //hideAppBarFab(fab)
                    createDatePicker(fab, rootview)

                    //20210629 update
                    //plantDetailViewModel.addPlantToGarden()
                    //Snackbar.make(root, R.string.added_plant_to_garden, Snackbar.LENGTH_LONG).show()
                }
            }

            manualImage = root.findViewById(R.id.manualImage1)
            manualTextView = root.findViewById(R.id.manualText)

            galleryNav.setOnClickListener { navigateToGallery() }

            var isToolbarShown = false

            // scroll change listener begins at Y = 0 when image is fully collapsed
            plantDetailScrollview.setOnScrollChangeListener(
                NestedScrollView.OnScrollChangeListener { _, _, scrollY, _, _ ->

                    // User scrolled past image to height of toolbar and the title text is
                    // underneath the toolbar, so the toolbar should be shown.
                    val shouldShowToolbar = scrollY > toolbar.height

                    // The new state of the toolbar differs from the previous state; update
                    // appbar and toolbar attributes.
                    if (isToolbarShown != shouldShowToolbar) {
                        isToolbarShown = shouldShowToolbar

                        // Use shadow animator to add elevation if toolbar is shown
                        appbar.isActivated = shouldShowToolbar

                        // Show the plant name if toolbar is shown
                        toolbarLayout.isTitleEnabled = shouldShowToolbar
                    }
                }
            )

            toolbar.setNavigationOnClickListener { view ->
                view.findNavController().navigateUp()
            }

            toolbar.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.action_share -> {
                        createShareIntent()
                        true
                    }
                    else -> false
                }
            }

            manualButton.setOnClickListener { view ->
                //manualTextView.visibility = View.GONE

                when (plantDetailViewModel.plant.value?.name) {
                    "BW7-Moss" -> {
                        manualImage.setImageResource(R.drawable.bw09)
                        manualTextView.visibility = View.GONE
                    }
                    "BW7-變形金剛柯博文" -> {
                        manualImage.setImageResource(R.drawable.bw08)
                        manualTextView.visibility = View.GONE
                    }
                    "BW7-原子小金剛" -> {
                        manualImage.setImageResource(R.drawable.bw07)
                        manualTextView.visibility = View.GONE
                    }
                    "BW7-復仇者聯盟" -> {
                        manualImage.setImageResource(R.drawable.bw05)
                        manualTextView.visibility = View.GONE
                    }
                    "BW7-變形金剛大黃蜂" -> {
                        manualImage.setImageResource(R.drawable.bw06)
                        manualTextView.visibility = View.GONE
                    }
                    "BW7-巴斯光年" -> {
                        manualImage.setImageResource(R.drawable.bw04)
                        manualTextView.visibility = View.GONE
                    }
                    "BW7-紅" -> {
                        manualImage.setImageResource(R.drawable.bw03)
                        manualTextView.visibility = View.GONE
                    }
                    "BW7-綠" -> {
                        manualImage.setImageResource(R.drawable.bw01)
                        manualTextView.visibility = View.GONE
                    }
                    "BW7-藍" -> {
                        manualImage.setImageResource(R.drawable.bw02)
                        manualTextView.visibility = View.GONE
                    }
                    "BW7-螢光" -> {
                        manualImage.setImageResource(R.drawable.bw10)
                        manualTextView.visibility = View.GONE
                    } else -> {
                        manualTextView.visibility = View.VISIBLE
                        manualTextView.setText(getString(R.string.manual_not_support))
                    }
                }
            }
        }
        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onResume() {
        super.onResume()
    }

    private fun createDatePicker(fab: FloatingActionButton, rootView: CoordinatorLayout) {
        val tvCustomTitle = TextView(activity)

        val lp = RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT
        )

        tvCustomTitle.layoutParams = lp
        tvCustomTitle.setPadding(0, 25, 0, 25)
        tvCustomTitle.gravity = Gravity.CENTER
        tvCustomTitle.setTextColor(Color.parseColor("#000000"))
        tvCustomTitle.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20f)
        tvCustomTitle.text = getString(R.string.date_setting)

        val calendar_inst = Calendar.getInstance()
        val date_picker_dlg = DatePickerDialog(
            requireActivity(),
            { view, year, monthOfYear, dayOfMonth -> },
            calendar_inst.get(Calendar.YEAR),
            calendar_inst.get(Calendar.MONTH),
            calendar_inst.get(Calendar.DAY_OF_MONTH)
        )
        date_picker_dlg.setButton(
            DatePickerDialog.BUTTON_POSITIVE, getString(R.string.ok_setting)
        ) { dialog, which ->

            val mYear = date_picker_dlg.datePicker.year
            val mMonth = date_picker_dlg.datePicker.month+1
            val mDay = date_picker_dlg.datePicker.dayOfMonth
            Log.d("TAG",
                String.format("Selected date : %d/%d/%d", mYear, mMonth, mDay)
            )

            hideAppBarFab(fab)
            plantDetailViewModel.addPlantToGarden(String.format("%d-%d-%d", mYear, mMonth, mDay))
            Snackbar.make(rootView, R.string.added_plant_to_garden, Snackbar.LENGTH_LONG).show()
        }
        date_picker_dlg.setButton(
            DatePickerDialog.BUTTON_NEGATIVE, getString(R.string.cancel_setting)
        ) { dialog, which ->
            Log.d("TAG",
                "Click cancel")
        }

        //date_picker_dlg.datePicker.minDate = Date().getTime()
        // open max day
        date_picker_dlg.datePicker.maxDate = Date().getTime()
        date_picker_dlg.setCustomTitle(tvCustomTitle)
        date_picker_dlg.setTitle(getString(R.string.date_setting))
        date_picker_dlg.datePicker.calendarViewShown = false
        date_picker_dlg.datePicker.spinnersShown = true
        date_picker_dlg.show()
    }

    private fun navigateToGallery() {
        plantDetailViewModel.plant.value?.let { plant ->
            val direction =
                PlantDetailFragmentDirections.actionPlantDetailFragmentToGalleryFragment(plant.name)
            findNavController().navigate(direction)
        }
    }

    // Helper function for calling a share functionality.
    // Should be used when user presses a share button/menu item.
    @Suppress("DEPRECATION")
    private fun createShareIntent() {
        val shareText = plantDetailViewModel.plant.value.let { plant ->
            if (plant == null) {
                ""
            } else {
                getString(R.string.share_text_plant, plant.name)
            }
        }
        val shareIntent = ShareCompat.IntentBuilder.from(requireActivity())
            .setText(shareText)
            .setType("text/plain")
            .createChooserIntent()
            .addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT or Intent.FLAG_ACTIVITY_MULTIPLE_TASK)
        startActivity(shareIntent)
    }

    // FloatingActionButtons anchored to AppBarLayouts have their visibility controlled by the scroll position.
    // We want to turn this behavior off to hide the FAB when it is clicked.
    //
    // This is adapted from Chris Banes' Stack Overflow answer: https://stackoverflow.com/a/41442923
    private fun hideAppBarFab(fab: FloatingActionButton) {
        val params = fab.layoutParams as CoordinatorLayout.LayoutParams
        val behavior = params.behavior as FloatingActionButton.Behavior
        behavior.isAutoHideEnabled = false
        fab.hide()
    }

    fun interface Callback {
        fun add(plant: Plant?)
    }
}
