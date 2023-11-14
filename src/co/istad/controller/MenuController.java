package co.istad.controller;

import co.istad.view.MenuView;

public class MenuController {
    private final MenuView menuView;
    public MenuController(){
        menuView = new MenuView();
    }
    public void index() {
        menuView.menu();
    }
}
