package info.nightscout.androidaps.utils.biometric

import android.content.Context
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetDialog
import info.nightscout.androidaps.R

class BiometricDialogV23(context: Context, biometricCallback: BiometricCallback) : BottomSheetDialog(context, R.style.BottomSheetDialogTheme), View.OnClickListener {

    private var ctx: Context? = null

    private var btnCancel: Button? = null
    private var imgLogo: ImageView? = null
    private var itemTitle: TextView? = null
    private var itemDescription: TextView? = null
    private var itemSubtitle: TextView? = null
    private var itemStatus: TextView? = null

    private var biometricCallback: BiometricCallback? = biometricCallback

    init {
        this.ctx = context.applicationContext
        setDialogView()
    }

    private fun setDialogView() {
        val bottomSheetView = layoutInflater.inflate(R.layout.view_bottom_sheet, null)
        setContentView(bottomSheetView)

        btnCancel = findViewById(R.id.btn_cancel)
        btnCancel!!.setOnClickListener(this)

        imgLogo = findViewById(R.id.img_logo)
        itemTitle = findViewById(R.id.item_title)
        itemStatus = findViewById(R.id.item_status)
        itemSubtitle = findViewById(R.id.item_subtitle)
        itemDescription = findViewById(R.id.item_description)

        updateLogo()
    }

    fun setTitle(title: String) {
        itemTitle!!.text = title
    }

    fun updateStatus(status: String) {
        itemStatus!!.text = status
    }

    fun setSubtitle(subtitle: String) {
        itemSubtitle!!.text = subtitle
    }

    fun setDescription(description: String) {
        itemDescription!!.text = description
    }

    fun setButtonText(negativeButtonText: String) {
        btnCancel!!.text = negativeButtonText
    }

    private fun updateLogo() {
        try {
            val drawable = getContext().packageManager.getApplicationIcon(context!!.packageName)
            imgLogo!!.setImageDrawable(drawable)

        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    override fun onClick(view: View) {
        dismiss()
        biometricCallback?.onAuthenticationCancelled()
    }
}
