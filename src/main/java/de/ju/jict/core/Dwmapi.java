package de.ju.jict.core;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.ptr.IntByReference;

public interface Dwmapi extends Library {
    Dwmapi INSTANCE = Native.load("dwmapi", Dwmapi.class);
    int DWMWA_USE_IMMERSIVE_DARK_MODE = 20;

    void DwmSetWindowAttribute(WinDef.HWND hwnd, int dwAttribute, IntByReference pvAttribute, int cbAttribute);
}