package com.eurobond.features.contacts

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eurobond.R
import com.eurobond.base.presentation.BaseFragment

class SchedulerAddFormFrag : BaseFragment() {
    private lateinit var mContext: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }
    companion object{
        fun getInstance(objects: Any): SchedulerAddFormFrag {
            val objFragment = SchedulerAddFormFrag()
            var obj = objects as String

            return objFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_scheduler_add_form, container, false)
        initView(view)
        return view
    }

    private fun initView(view: View?) {


    }

}