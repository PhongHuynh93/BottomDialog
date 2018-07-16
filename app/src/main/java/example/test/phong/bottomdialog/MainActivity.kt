package example.test.phong.bottomdialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var dialog: Dialog
    private lateinit var edt: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createDialog()

        button.setOnClickListener {
            showDialog()
        }
    }


    private fun createDialog() {
        dialog = Dialog(this, R.style.BottomDialogs)
        val viewComment = LayoutInflater.from(this).inflate(R.layout.dialog_layout, null)
        edt = viewComment.findViewById<EditText>(R.id.edtPostComment)
        dialog.setContentView(viewComment)
        dialog.window.setLayout(MATCH_PARENT, WRAP_CONTENT)
        dialog.window.setGravity(Gravity.BOTTOM)
    }


    private fun showDialog() {
        // must have the style for bottom dialog

        // show the dialog and the keyboard too
        edt.post {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            edt.requestFocus()
            imm.showSoftInput(edt, InputMethodManager.SHOW_IMPLICIT)
        }
        dialog.show()
    }
}
