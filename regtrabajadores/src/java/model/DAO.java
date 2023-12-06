package model;

import controller.InitListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    private List<Worker> trabajadores;
    
    public DAO() throws IOException, FileNotFoundException, ClassNotFoundException{
        File archivoTrabajadores 
                = new File(InitListener.RUTA_ARCHIVO_TRABAJADORES); 
        
        if(archivoTrabajadores.exists()){// si existe el archivo
            /*Lo cargo a la lista*/
            trabajadores = (List)IO.leerObjetoDesde(InitListener.RUTA_ARCHIVO_TRABAJADORES);
        }else{
            /*Si no, lo creo vacío*/
            trabajadores = new ArrayList<Worker>();
        }
    }
    
    public void create(Worker t) throws IOException{
        trabajadores.add(t);
        IO.escribirObjetoEn(trabajadores, InitListener.RUTA_ARCHIVO_TRABAJADORES);
    }
    
    public List<Worker> getAll(){
        return trabajadores;
    }
    
    public int getAguinaldo(String run){
        for(Worker w: trabajadores){
            if(w.getRun().equalsIgnoreCase(run)){
                return w.getAguinaldo();
            }
        }
        
        return -1;
    }
    
    public User exist(User u){
        if(!u.getMail().equalsIgnoreCase("edgar_eto@gmail.com") &&
                !u.getPass().equalsIgnoreCase("1234")){
            /*Malo*/
            u.addError(new Error(300, "Mail y Pass incorrecta"));
            return u;
        }else if(u.getMail().equalsIgnoreCase("edgar_eto@gmail.com")){
            /*OK*/
            if(u.getPass().equalsIgnoreCase("1234")){
                /*OK*/
                return new User(u.getMail(), u.getPass(), "Edgar Condori Polloquiri");
            }else{
                /*Pass Incorrecta*/
                User newUser = new User(u.getMail(), u.getPass(), "Edgar Condori Polloquiri");
                newUser.addError(new Error(100, "Pass Incorrecta"));
                return newUser;
            }
        }else{
            /*Email erróneo*/
            User newUser = new User(u.getMail(), u.getPass(), "Edgar Condori Polloquiri");
            newUser.addError(new Error(200, "Mail Incorrecto"));
            return newUser;
        }
    }
    
    
}
