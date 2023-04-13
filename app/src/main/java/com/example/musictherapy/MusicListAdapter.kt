package com.example.musictherapy

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class MusicListAdapter(context: Context, files: List<MusicFile>) :
    ArrayAdapter<MusicFile>(context, 0, files) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context)
            .inflate(android.R.layout.simple_list_item_1, parent, false)

        val musicFile = getItem(position)
        val textView = view.findViewById<TextView>(android.R.id.text1)
        textView.text = musicFile?.name

        return view
    }
}
