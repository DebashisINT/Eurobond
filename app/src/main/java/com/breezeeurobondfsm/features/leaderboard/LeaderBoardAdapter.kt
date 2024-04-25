package com.breezeeurobondfsm.features.leaderboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.breezeeurobondfsm.R

class LeaderBoardAdapter(private val mLeaderBoardData : ArrayList<LeaderBoardData>):RecyclerView.Adapter<FoodViewHolder>(){
    // class FoodViewHolder here..

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val viewLayout = LayoutInflater.from(parent.context).inflate(
            R.layout.row_leaderboard_frag,
            parent,false)
        return FoodViewHolder(viewLayout)    }

    override fun getItemCount(): Int {
      return  mLeaderBoardData.size
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val currentFood = mLeaderBoardData[position]
        holder.name_TV.text = currentFood.name
        holder.tv_designation.text = currentFood.tv_designation
        holder.tv_mobile.text = currentFood.phonenumber
        holder.tv_score.text = currentFood.totalscore

        if (currentFood.rank==1){
            holder.iv_badge.setBackgroundResource(R.drawable.first_icon)

        }else if (currentFood.rank==2){
            holder.iv_badge.setBackgroundResource(R.drawable.second_icon)

        }
        else if (currentFood.rank==3){
            holder.iv_badge.setBackgroundResource(R.drawable.third_icon)

        }
        else{
            holder.leader_rank_TV.visibility=View.VISIBLE
            holder.leader_rank_TV.text = "#"+currentFood.rank.toString()

        }
    }

}

class FoodViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)
{
    val name_TV : TextView = itemView.findViewById(R.id.name_TV)
    val iv_badge : ImageView = itemView.findViewById(R.id.iv_badge)
    val leader_rank_TV : TextView = itemView.findViewById(R.id.leader_rank_TV)
    val tv_designation : TextView = itemView.findViewById(R.id.tv_designation)
    val tv_score : TextView = itemView.findViewById(R.id.tv_score)
    val tv_mobile : TextView = itemView.findViewById(R.id.tv_mobile)
}
