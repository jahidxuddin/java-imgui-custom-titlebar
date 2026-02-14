package de.ju.jict;

import de.ju.jict.core.Dwmapi;
import imgui.app.Application;
import imgui.app.Configuration;

import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.ptr.IntByReference;

import org.lwjgl.glfw.GLFWNativeWin32;

public class App extends Application {
    @Override
    protected void configure(Configuration config) {
        config.setTitle("Java ImGUI Custom Titlebar");
    }

    @Override
    protected void preRun() {
        super.preRun();

        this.colorBg.set(0.13f, 0.145f, 0.16f, 1.0f);

        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            try {
                long glfwWindow = this.handle;

                long hwndLong = GLFWNativeWin32.glfwGetWin32Window(glfwWindow);
                HWND hwnd = new HWND(new Pointer(hwndLong));

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

    @Override
    public void process() {

    }

    public static void main(String[] args) {
        launch(new App());
    }
}