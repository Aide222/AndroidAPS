package info.nightscout.androidaps.utils.biometric

import android.widget.Toast
import info.nightscout.androidaps.MainApp
import info.nightscout.androidaps.R


class BCCallback : BiometricCallback {
    override fun onSdkVersionNotSupported() {
        Toast.makeText(MainApp.instance().getApplicationContext(), MainApp.gs(R.string.biometric_error_sdk_not_supported), Toast.LENGTH_LONG).show()
    }

    override fun onBiometricAuthenticationNotSupported() {
        Toast.makeText(MainApp.instance().getApplicationContext(), MainApp.gs(R.string.biometric_error_hardware_not_supported), Toast.LENGTH_LONG).show()
    }

    override fun onBiometricAuthenticationNotAvailable() {
        Toast.makeText(MainApp.instance().getApplicationContext(), MainApp.gs(R.string.biometric_error_fingerprint_not_available), Toast.LENGTH_LONG).show()
    }

    override fun onBiometricAuthenticationPermissionNotGranted() {
        Toast.makeText(MainApp.instance().getApplicationContext(), MainApp.gs(R.string.biometric_error_permission_not_granted), Toast.LENGTH_LONG).show()
    }

    override fun onBiometricAuthenticationInternalError(error: String) {
        Toast.makeText(MainApp.instance().getApplicationContext(), error, Toast.LENGTH_LONG).show()
    }

    override fun onAuthenticationFailed() {
        //        Toast.makeText(getApplicationContext(), MainApp.gs(R.string.biometric_failure), Toast.LENGTH_LONG).show();
    }

    override fun onAuthenticationCancelled() {
        Toast.makeText(MainApp.instance().getApplicationContext(), MainApp.gs(R.string.biometric_cancelled), Toast.LENGTH_LONG).show()
// TODO        mBiometricManager.cancelAuthentication()
    }

    override fun onAuthenticationSuccessful() {
        Toast.makeText(MainApp.instance().getApplicationContext(), MainApp.gs(R.string.biometric_success), Toast.LENGTH_LONG).show()
    }

    override fun onAuthenticationHelp(helpCode: Int, helpString: CharSequence) {
        //        Toast.makeText(getApplicationContext(), helpString, Toast.LENGTH_LONG).show();
    }

    override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
        //        Toast.makeText(getApplicationContext(), errString, Toast.LENGTH_LONG).show();
    }

}