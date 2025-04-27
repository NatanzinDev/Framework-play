package controllers;
import play.*;
import play.mvc.Controller;



public class Application extends Controller {
	
	//action
    public static void index() {
        render();
    }
    
    //action
    public static void ola(String nome) {
        render(nome); // render pode ser lido como tipo return
    }
    
    

}