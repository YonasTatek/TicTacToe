package com.byt.tictactoe

import android.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.updateLayoutParams
import com.byt.tictactoe.databinding.ActivityMainBinding
import com.byt.tictactoe.databinding.ActivitySingleBinding
import kotlin.random.Random

class SingleActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySingleBinding
    var value=arrayOf(arrayOf(0,0,0),arrayOf(0,0,0),arrayOf(0,0,0));
    var turn:Boolean=true;
    var draw=false;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

     binding=ActivitySingleBinding.inflate(layoutInflater)
        setContentView(binding.root)
       var all=arrayOf(binding.r1,binding.r2,binding.r3,binding.r4,binding.r5,binding.r6,binding.r7,binding.r8,binding.r9)
        var cheked= mutableListOf(binding.r1,binding.r2,binding.r3,binding.r4,binding.r5,binding.r6,binding.r7,binding.r8,binding.r9);


        binding.ok.setOnClickListener{
            cheked.clear()
            cheked.addAll(mutableListOf(binding.r1,binding.r2,binding.r3,binding.r4,binding.r5,binding.r6,binding.r7,binding.r8,binding.r9));

            binding.type.text =""
            binding.showwinner.updateLayoutParams{
                width=0

            }
    Reset()
        }
     for(i in all)
        {
            i.setOnClickListener{



                  if( i.getTag()!=R.drawable.x && i.getTag()!=R.drawable.o){
                      i.setImageResource(R.drawable.x)
                      i.setTag(R.drawable.x)
                      cheked.remove(i)
                      Mark(i.id,1,i)

                          if(!turn){

                     if(cheked.size==0 ){

                             binding.type.text ="Draw"
                             binding.showwinner.updateLayoutParams{
                                 width=350

                             }
                         cheked.addAll(mutableListOf(binding.r1,binding.r2,binding.r3,binding.r4,binding.r5,binding.r6,binding.r7,binding.r8,binding.r9));





                     } else {
                      var temp:Int= Random.nextInt(cheked.size)

                      cheked[temp].setImageResource(R.drawable.o)
                      cheked[temp]?.setTag(R.drawable.o)
                      Mark(cheked[temp]!!.id,2,i);
                      cheked.remove(cheked[temp]);
                     }
                          }
                  else{
                      cheked.clear()
                           cheked= mutableListOf(binding.r1,binding.r2,binding.r3,binding.r4,binding.r5,binding.r6,binding.r7,binding.r8,binding.r9);

                          }
                  }


                else{
//                  if( i.getTag()!=R.drawable.x && i.getTag()!=R.drawable.o) {
//                      i.setImageResource(R.drawable.o)
//                      i.setTag(R.drawable.o)
//                      Mark(i.id, 2, i)
//                  }
              }
            }
        }



        binding.refresh.setOnClickListener{
            Reset()
        }



    }
    public fun Mark (value:Any,type:Int,checkturn:Any){


        when(value){
            binding.r1.id->{
                if(this.value[0][0]==0){
                this.value[0][0]=type;
                if(CheckWin(type)){
                    SetWinner(type,"111")
                }else {turn=!turn;}}
            }
            binding.r2.id->{
                if(this.value[0][1]==0)
                    this.value[0][1]=type;
                if(CheckWin(type)){
                    SetWinner(type,"111")
                }else {turn=!turn;}
            }
            binding.r3.id->{
                if(this.value[0][2]==0)
                    this.value[0][2]=type;
                if(CheckWin(type)){
                    SetWinner(type,"111")
                }else {turn=!turn;}
            }
            binding.r4.id->{
                if(this.value[1][0]==0)
                    this.value[1][0]=type;
                if(CheckWin(type)){
                    SetWinner(type,"111")
                }else {turn=!turn;}
            }
            binding.r5.id->{
                if(this.value[1][1]==0)
                    this.value[1][1]=type;
                if(CheckWin(type)){
                    SetWinner(type,"111")
                }else {turn=!turn;}
            }
            binding.r6.id->{
                if(this.value[1][2]==0)
                    this.value[1][2]=type;
                if(CheckWin(type)){
                    SetWinner(type,"111")
                }else {turn=!turn;}
            }
            binding.r7.id->{
                if(this.value[2][0]==0)
                    this.value[2][0]=type;
                if(CheckWin(type)){
                    SetWinner(type,"111")
                }else {turn=!turn;}
            }
            binding.r8.id->{
                if(this.value[2][1]==0)
                    this.value[2][1]=type;
                if(CheckWin(type)){
                    SetWinner(type,"111")
                }else {turn=!turn;}
            }
            binding.r9.id->{
                if(this.value[2][2]==0)
                    this.value[2][2]=type;
                if(CheckWin(type)){
                    SetWinner(type,"111")
                }else {turn=!turn;}
            }
        }
        if(CheckWin(type)){


//            Reset()
        }
//        var display:String=""
//for(i in this.value){
//
//    for (j in i)
//    {
//        display="$display ${j}"
//    }
//}
//        Log.d("cheking","${display}")


    }

    fun SetWinner(type:Int,goal:Any){


    if(type==1){
        binding.type.text ="You Win"
        binding.showwinner.updateLayoutParams{
            width=350

        }

    }
    else if(type==2){
        binding.type.text ="You Loss"
        binding.showwinner.updateLayoutParams{
            width=350

        }
    }

    }

    fun CheckWin(type: Int):Boolean{

        if(this.value[0][0]==type && this.value[0][1]==type && this.value[0][2]==type) return true;
        else if(this.value[1][0]==type && this.value[1][1]==type && this.value[1][2]==type) return true;
        else if(this.value[2][0]==type && this.value[2][1]==type && this.value[2][2]==type) return true;
        else if(this.value[0][0]==type && this.value[1][0]==type && this.value[2][0]==type) return true;
        else if(this.value[0][1]==type && this.value[1][1]==type && this.value[2][1]==type) return true;
        else if(this.value[0][2]==type && this.value[1][2]==type && this.value[2][2]==type) return true;
        else if(this.value[0][0]==type && this.value[1][1]==type && this.value[2][2]==type) return true;
        else if(this.value[0][2]==type && this.value[1][1]==type && this.value[2][0]==type) return true;


        return false


    }
        fun Reset(){
            turn=true;


            var all=arrayOf(binding.r1,binding.r2,binding.r3,binding.r4,binding.r5,binding.r6,binding.r7,binding.r8,binding.r9)
        for(i in all)
        {
            i.setImageResource(R.drawable.a)
             i.setTag(null);
            this.value=arrayOf(arrayOf(0,0,0),arrayOf(0,0,0),arrayOf(0,0,0));
        }
    }
}