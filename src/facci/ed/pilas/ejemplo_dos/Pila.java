package facci.ed.pilas.ejemplo_dos;

//package pilas;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//import java.io.*;
//package pilas;
import java.io.*; //importa libreria de entrada y salida de datos
import javax.swing.JOptionPane; //cargaremos todas las librerías que contenga swing
/**
 *
 */
public class Pila { // declara la clase pila
   public static final int MAX_LENGTH = 5; //declara el tamaño de la cadena
   public static String Pila[] = new String[MAX_LENGTH]; //declara a pila igual a constructor del maximo de la cadena
   public static int cima = -1; //cima de la pila principal
   public static String Pilaaux[] = new String[MAX_LENGTH]; //declara a pila igual a constructor del maximo de la cadena
   public static int cimaaux = -1; //cima de la pila aux
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args)throws IOException{
        // TODO code application logic here
        Menu(); //funcion menu
    }
    
    public static void Menu()throws IOException{
        //salida en pantalla del menu
       String salida="====Menú Manejo Pila====\n"+"1- Insertar elemento\n"+"2- Eliminar elemento\n";
       salida=salida+"3- Buscar elemento\n"+"4- Imprimir pila\n"+"5- Contar repetición\n";
       salida=salida+"6- Salir\n";
       String entra=JOptionPane.showInputDialog(null, salida);
       int op = Integer.parseInt(entra);
       Opciones(op);
    }

    public static void Opciones(int op)throws IOException{ //llamada de las lbrerias
        String salio;
        switch(op){
			case 1: Insertar();
                                Menu();
			        break;
			case 2: salio=Pop();
                                if (!Vacia()){
                                   JOptionPane.showMessageDialog(null, "El dato que salio es "+salio); 
                                }
                                Menu();
			        break;
			case 3: Buscar();
                                Menu();
			        break;
			case 4: Imprimir();
                                Menu();
			        break;
                         case 5: contar();
                                Menu();
			        break;
			case 6: System.exit(0);
			        break;
			default:Menu();
			        break;
                        
	   } //final de case
    }

    public static void Insertar()throws IOException{ //llamada de la libreria io
       String entra = JOptionPane.showInputDialog("Digite un dato para la pila");
       Push(entra);
    }

    public static void Push(String dato)throws IOException{ //llamada de la libreria io
      if ((Pila.length-1)==cima){ // es pila-1 igual a cima?
        JOptionPane.showMessageDialog(null,"Capacidad de la pila al limite");
        Imprimir();
      }else{
            cima++; //incrementa a cima
            JOptionPane.showMessageDialog(null,"Cima en la posición "+cima);
            Pila[cima]=dato;
      }
    }

    public static void PushAux(String dato)throws IOException{ //llamada de la libreria io
      if ((Pilaaux.length-1)==cimaaux){ //es pila-1 igual a cima?
        JOptionPane.showMessageDialog(null,"Capacidad de la pila auxiliar al limite");
      }else{
         cimaaux++;//incrementa a cima
         Pilaaux[cimaaux]=dato;
       }
    }

    public static boolean VaciAaux(){
        return (cimaaux==-1);
    }

    public static boolean Vacia(){
        if (cima==-1){
            return (true);
        }
        else {
            return(false);{
        
    } 
        }

    public static void Imprimir()throws IOException{ //llamada de la libreria io
      String quedata,salida=" ";
      if (cima!=-1)
      { do {
            quedata=Pop();
            salida=salida+quedata+"\n"; //System.out.println mostrando
            PushAux(quedata);            
        }while(cima!=-1);
        do {
            quedata=PopAux();
            Push(quedata);
        }while(cimaaux!=-1);
        JOptionPane.showMessageDialog(null, salida);
      }
      else {
          JOptionPane.showMessageDialog(null, "La pila esta vacía");
      }
    }

    public static String Pop()throws IOException{ //llamada de la libreria io
      String quedato;
      if(Vacia()){
          JOptionPane.showMessageDialog(null,"No se puede eliminar, pila vacía !!!" );
          return("");
      }else{
              quedato=Pila[cima];
	      Pila[cima] = null; //fila llena
	      --cima;
              return(quedato);
            }
    }

    public static String PopAux()throws IOException{ //llamada de la libreria io
      String quedato;
      if(cimaaux== -1){ //es cima igual a-1?
            JOptionPane.showMessageDialog(null,"No se puede eliminar, pila vacía !!!" );
            return("");
      }else{
              quedato=Pilaaux[cimaaux];
	      Pilaaux[cimaaux] = null; //fila llena
	      --cimaaux;
              return(quedato);
           }
    }

    public static void Buscar()throws IOException{ //llamada de la libreria io
        if (Vacia()){
            JOptionPane.showMessageDialog(null, "La pila esta vacìa");
        }
        else{
            String cad = JOptionPane.showInputDialog("Digite la cadena a buscar: ");
            String quedata;
            int bandera=0; //no se encuentra
            do {
                    quedata=Pop();
                    if(cad.equals(quedata)){
                        bandera=1; //si esta
                    }
                    PushAux(quedata);            
            }while(cima!=-1);
            do {
                    quedata=PopAux();
                    Push(quedata);
            }while(cimaaux!=-1);
            if (bandera==1) {
                    JOptionPane.showMessageDialog(null,"Elemento encontrado");
            }else{
                    JOptionPane.showMessageDialog(null,"Elemento no encontrado :(");
            }
        }
    }
    public static void contar() throws IOException { //llamada de la libreria io
        String quedata;
        int contador = 0;
        if (cima!=-1)
          { do {
                quedata=Pop();
                contador = contador+1;
                PushAux(quedata);            
            }while(cima!=-1);
             
            JOptionPane.showMessageDialog(null,"Elementos en la pila: "+ contador);
          }
        else {
            JOptionPane.showMessageDialog(null, "La pila esta vacìa");
        }
    }           
}