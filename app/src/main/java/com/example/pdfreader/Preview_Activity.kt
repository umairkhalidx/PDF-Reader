package com.example.pdfreader

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.barteksc.pdfviewer.PDFView

class Preview_Activity : AppCompatActivity() {

    lateinit var pdf_obj: PDFView               //PDFView obj to access library Functions
    val PDF_SELECTION_CODE =100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)

        pdf_obj= findViewById(R.id.pdfView)                 //To display recieved data in PDF View

        //Selecting Files from Storage
        val browseStorage_obj = Intent(Intent.ACTION_GET_CONTENT)           //Defining Intent

        browseStorage_obj.type="application/pdf"
        browseStorage_obj.addCategory(Intent.CATEGORY_OPENABLE)    //Defining Storage Category as Openable

        startActivityForResult(Intent.createChooser(browseStorage_obj,"Select Pdf"),PDF_SELECTION_CODE)

    }

    fun Display_pdf_from_Uri(uri: Uri?){            //This Functions take selected pdf Uri as parameter
        pdf_obj.fromUri(uri)
            .defaultPage(0)             //These all are PDF View Library Functions
            .spacing(10)
            .load()                 //This function is used to load the file
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        super.onActivityResult(requestCode, resultCode, data)

        //if data not null and code matchs and result ok then display pdf
        if(requestCode==PDF_SELECTION_CODE && resultCode== Activity.RESULT_OK && data != null ){
            val selected_pdf_URI = data.data
            Display_pdf_from_Uri( selected_pdf_URI)            //Passes the URi to Display Function
        }
    }
}