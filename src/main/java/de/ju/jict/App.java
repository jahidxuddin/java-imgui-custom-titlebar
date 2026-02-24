package de.ju.jict;

import de.ju.jict.core.WindowHandler;
import imgui.app.Application;
import imgui.app.Configuration;

public class App extends Application {
    @Override
    protected void configure(Configuration config) {
        config.setTitle("Java ImGUI Custom Titlebar");
    }

    @Override
    protected void preRun() {
        super.preRun();
        this.colorBg.set(0.13f, 0.145f, 0.16f, 1.0f);
        WindowHandler.applyDarkMode(this.handle);
    }

    @Override
    public void process() {

    }

    public static void main(String[] args) {
        launch(new App());
    }
}