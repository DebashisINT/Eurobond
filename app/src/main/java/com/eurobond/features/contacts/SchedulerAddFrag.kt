package com.eurobond.features.contacts

import android.content.Context
import android.os.Bundle
import android.service.controls.actions.FloatAction
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.eurobond.R
import com.eurobond.app.types.FragType
import com.eurobond.app.widgets.MovableFloatingActionButton
import com.eurobond.base.presentation.BaseFragment
import com.eurobond.features.dashboard.presentation.DashboardActivity
import com.pnikosis.materialishprogress.ProgressWheel

class SchedulerAddFrag : BaseFragment(), View.OnClickListener {
    private lateinit var mContext: Context
    private lateinit var progress_wheel: ProgressWheel
    private lateinit var rvSchedulL: RecyclerView
    private lateinit var tvNodata: TextView
    private lateinit var mFab: MovableFloatingActionButton

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    companion object{
        fun getInstance(objects: Any): SchedulerAddFrag {
            val objFragment = SchedulerAddFrag()
            var obj = objects as String

            return objFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_scheduler_add, container, false)
        initView(view)
        return view
    }
    private fun initView(view: View) {
        progress_wheel = view.findViewById(R.id.progress_wheel_frag_schedule_his_list)
        rvSchedulL = view.findViewById(R.id.rv_frag_scheduler_list)
        tvNodata = view.findViewById(R.id.tv_frag_schedul_his_noData)
        mFab = view.findViewById(R.id.fab_frag_add_schedule_in_contact)

        mFab.setOnClickListener(this)
        mFab.setCustomClickListener {
            (mContext as DashboardActivity).loadFragment(FragType.SchedulerAddFormFrag, true, "")
        }
    }
    override fun onClick(p0: View?) {

    }

}