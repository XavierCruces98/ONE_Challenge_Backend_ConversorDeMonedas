package com.conversormonedas;


import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class App {
  public static void main(String[] args) throws Exception{


    String[][] monedas={ {"Dólar", "$"}, {"Euros", "\u20AC"}, {"Libras Esterlinas", "\u00A3"}, {"Yen Japonés", "\u00A5"}, {"Won sur-coreano", "\u20A9"}, {"Soles", "PEN"}};

    Double[] conversorSoles = { 3.59744 , 3.95636, 4.61948, 0.0257398 , 0.00281183 };
    Double[] conversorDolares = { 1.09933 , 1.28266, 0.00717321, 0.000780820 , 0.277906  };
    String[] opciones_01 = new String[(monedas.length-1)*2];


    for(int i =0; i<monedas.length ; i++){
      if(i<(monedas.length-1))
        opciones_01[i] = monedas[monedas.length-1][0] + " a " + monedas[i][0];
      if (i>0)
        opciones_01[i+(monedas.length-2)] = monedas[0][0] + " a " + monedas[i][0] ;
    }

    Object[] options = {"Convertir divisas", "Convertir Temperatura","Salir"};
    int elige =JOptionPane.showOptionDialog(null, "¿Que quieras hacer?",  "Conversor", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
    
    if(elige==2){
      JOptionPane.showMessageDialog(null,"Programa Cerrado");
      System.exit(0);
    }

    if(elige==0){

      boolean continuarPrograma=true;

      while(continuarPrograma){

        String cambio=(String) JOptionPane.showInputDialog(null, "Elige una opcion", "Conversor de Moneda", JOptionPane.QUESTION_MESSAGE, null, opciones_01, opciones_01[0]);

        
        String input="";
        double numIngresado=0.00;

        if(cambio.equals(opciones_01[0])) 
          input= JOptionPane.showInputDialog("Ingrese los Soles a convertir a Dolares");
  
        if(cambio.equals(opciones_01[1])) 
          input= JOptionPane.showInputDialog("Ingrese los Soles a convertir a Euros");
        
        if(cambio.equals(opciones_01[2]))
          input= JOptionPane.showInputDialog("Ingrese los Soles a convertir a Libras Esterlinas");
         
        if(cambio.equals(opciones_01[3]))
          input= JOptionPane.showInputDialog("Ingrese los Soles a convertir a Yen Japones");
       
        if(cambio.equals(opciones_01[4]))
          input= JOptionPane.showInputDialog("Ingrese los Soles a convertir a Won sur-coreano");
   
        if(cambio.equals(opciones_01[5])) 
          input= JOptionPane.showInputDialog("Ingrese los Dolares a convertir a Euros");
      
        if(cambio.equals(opciones_01[6])) 
          input= JOptionPane.showInputDialog("Ingrese los Dolares a convertir a Libras Esterlinas");
        
        if(cambio.equals(opciones_01[7]))
          input= JOptionPane.showInputDialog("Ingrese los Dolares a convertir a Yen Japonés");
         
        if(cambio.equals(opciones_01[8])){
          input= JOptionPane.showInputDialog("Ingrese los Dolares a convertir a Won sur-coreano");
        }
        if(cambio.equals(opciones_01[9])){
          input= JOptionPane.showInputDialog("Ingrese los Dolares a convertir a Soles");
        }

          

        try{
          numIngresado = Double.parseDouble(input);
        } catch(NumberFormatException e){
          JOptionPane.showMessageDialog(null, "Valor no valido");
        }

        if(cambio.equals(opciones_01[0])) 
          conversor(numIngresado, monedas[0], conversorSoles[0],true);
  
        if(cambio.equals(opciones_01[1])) 
          conversor(numIngresado, monedas[1], conversorSoles[1], true);
        
        if(cambio.equals(opciones_01[2]))
          conversor(numIngresado, monedas[2], conversorSoles[2], true);
         
        if(cambio.equals(opciones_01[3]))
          conversor(numIngresado, monedas[3], conversorSoles[3], true);
       
        if(cambio.equals(opciones_01[4]))
          conversor(numIngresado, monedas[4], conversorSoles[4], true);
   
        if(cambio.equals(opciones_01[5])) 
          conversor(numIngresado, monedas[1], conversorDolares[0],false);
      
        if(cambio.equals(opciones_01[6])) 
          conversor(numIngresado, monedas[2], conversorDolares[1], false);
        
        if(cambio.equals(opciones_01[7]))
          conversor(numIngresado, monedas[3], conversorDolares[2], false);
         
        if(cambio.equals(opciones_01[8]))
          conversor(numIngresado, monedas[4], conversorDolares[3], false);
       
        if(cambio.equals(opciones_01[9]))
          conversor(numIngresado, monedas[5], conversorDolares[4], false);
   
    
        int confirma = JOptionPane.showConfirmDialog(null, "¿Desea continuar usando el programa?", "Confirmar",
          JOptionPane.YES_NO_CANCEL_OPTION);
          if(confirma == JOptionPane.NO_OPTION || confirma== JOptionPane.CANCEL_OPTION){
            continuarPrograma = false; 
            JOptionPane.showMessageDialog(null, "Programa Finalizado!");
          }
      }
    }

    // convertidor de temperatura
    if(elige==1){
      boolean seguirPrograma=true;
      while(seguirPrograma){
        DecimalFormat formatoTemperatura = new DecimalFormat("#.##");
        String[] opcionesTemperatura ={"Celsius a Fahrenheit", "Fahrenheit a Celsius"};
        int cambio =  JOptionPane.showOptionDialog(null,"Eliga una opcion:", "Conversor de Temperatura", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,  opcionesTemperatura, opcionesTemperatura[0]);

        String valorNominal ="";
        Double valor=0.00;
     


      if(cambio==0){
        valorNominal = JOptionPane.showInputDialog(null, "Ingrese los grados \u00B0C Celsius a convertir a grados \u00B0F Fahrenheit ");
      }
        
      if(cambio==1){
        valorNominal = JOptionPane.showInputDialog(null, "Ingrese los grados \u00B0F Fahrenheit  a convertir a grados \u00B0C Celsius ");
      }


      try{
        valor= Double.parseDouble(valorNominal);
      }catch(NumberFormatException e){
        JOptionPane.showMessageDialog(null,"Valor no valido");
        System.exit(0);
      }

      Double resultado=0.00;

      if(cambio==0){
        resultado = (valor*9/5)+32;
        JOptionPane.showMessageDialog(null, valor + " \u00B0C Celsius son: " + formatoTemperatura.format(resultado) + " \u00B0F Fahrenheit.");
      }
      
      if(cambio==1){
        resultado=(valor-32)*5/9; // (5/9) no pongas parentesis
        JOptionPane.showMessageDialog(null, valor + " \u00B0F Fahrenheit son: " + formatoTemperatura.format(resultado) + " \u00B0C Celsius ");
      }

      int confirma = JOptionPane.showConfirmDialog(null, "¿Desea continuar usando el programa?", "Confirmar",
        JOptionPane.YES_NO_CANCEL_OPTION);
        if(confirma == JOptionPane.NO_OPTION || confirma== JOptionPane.CANCEL_OPTION){
          seguirPrograma= false; 
          JOptionPane.showMessageDialog(null, "Programa Finalizado!");
        }

      }
    }
    
  }

  public static void conversor(  double monedaPrincipal, String[] texto, double conversor, boolean valor) {
    
    DecimalFormat formatoDivisa = new DecimalFormat("#.##");
    double moneda=monedaPrincipal/conversor;

    if(valor) 
       JOptionPane.showMessageDialog(null, 
       "S\u002f" + monedaPrincipal + " Soles son: " + formatoDivisa.format(moneda) + texto[1] + " " + texto[0] +".");

    if(!valor)
      JOptionPane.showMessageDialog(null, 
        monedaPrincipal + "$ Dolares son: " + formatoDivisa.format(moneda) + texto[1] + " " + texto[0] +".");


  }
}
