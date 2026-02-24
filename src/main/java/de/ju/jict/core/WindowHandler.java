package de.ju.jict.core;

import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.ptr.IntByReference;
import org.lwjgl.glfw.GLFWNativeWin32;

public class WindowHandler {
    public static void applyDarkMode(long glfwWindow) {
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            try {
                long hwndLong = GLFWNativeWin32.glfwGetWin32Window(glfwWindow);
                WinDef.HWND hwnd = new WinDef.HWND(new Pointer(hwndLong));

                IntByReference pvAttribute = new IntByReference(1);
                Dwmapi.INSTANCE.DwmSetWindowAttribute(
                        hwnd,
                        Dwmapi.DWMWA_USE_IMMERSIVE_DARK_MODE,
                        pvAttribute,
                        4
                );
            } catch (Exception e) {
                System.err.println("Konnte Dark Titlebar nicht setzen: " + e.getMessage());
            }
        }
    }
}
