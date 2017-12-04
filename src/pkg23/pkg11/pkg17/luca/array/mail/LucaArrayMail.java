/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg23.pkg11.pkg17.luca.array.mail;

import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author tss
 */
public class LucaArrayMail {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //il programma permetterà di chiedere tante e-mail all'ingresso per darle poi in segreteria per fare una mail list 
        //fase 1: creare le variabili da utilizzare durante il programma 
        //elenco di mail tipo foglio in cui scrivo sempre a capo la nuova mail
        //lavoro con un foglio di carta gigante e un numero intero per sapere quanto lavoro fare
        String foglio;

        //dichiarazione di un array aggiungo le quadre in coda al nome della variabile
        String listamail[];
        int[] lista_anticipi;
        int quanti;
        int ultimi;

        //fase 2: caricamento dei dati  (input) 
        // prima cosa quanto lavoro ovvero quante mail raccolgo
        String tx = JOptionPane.showInputDialog("dimmi quanti mail prendi oggi");
        quanti = Integer.parseInt(tx);
        listamail = new String[quanti];
        lista_anticipi= new int[quanti];

        tx = JOptionPane.showInputDialog("quanti sono gli utlimi prima della fine del turno?");
        ultimi = Integer.parseInt(tx);

        //chiedo uno alla volta la mail e li inserisco
        //faccio comaprire la finestra per inserire la mail con la domanda dimmi la mail
        //con un JOption
        //cliente1
        foglio = "Registro interessati mail:"; //JOptionPane.showInputDialog("dimmi la mail");

        //fai per n volte la richiesta mail
        for (int i = 0; i < quanti; i++) {

            //richiesta mail
            //cliente2 concateno al primo il secondo arrivato magari andando prima a capo
            String mail;

            mail = JOptionPane.showInputDialog("dimmi la mail [" + (i + 1) + " di " + quanti + "]");
            String tx_anticipo=JOptionPane.showInputDialog("quanto lasci?","0");
            lista_anticipi[1]=Integer.parseInt(tx_anticipo);
          
           
            foglio += "\n" + (i + 1) + ") ";
            foglio += mail;
            listamail[i] = mail;

            //sono pronto per il prossimo ma verifico se avvisare che siano gli ultimi
            //caso sono gli ultimi avvisare con un messaggio
            //se quanti ne ho fatti tolti a quanti ne devo fare e' uguale a ultimi allora avvisare con un messaggio
            if (quanti - i - 1 == ultimi) {
                JOptionPane.showMessageDialog(null, "vai a dire che ne mancano solo " + ultimi + " e poi non ne passo piu'");
            }

        }

        //fase 3: elaborazione dei dati ---> inserirli in ordine alfabetico
        //metto la data
        String data = new Date().toString();
        foglio += "\n" + "Fine elenco." + "\n" + data;
        int quantemail = 0;
        int totale=0;
        for (int i = 0; i < listamail.length; i++) {
            //se incontro una mail compilata aumento il numero di quantemail
            //recupero la mail dell'iesimo tizio
            String mail = listamail[i];
            //verifico se diferso da doppi apici ovvero lasciato striscia vuota 
            if (!mail.equals("")) {
                quantemail++;
            }
            
            //calcolo e incremento il totale lasciti
            totale+=lista_anticipi[i];
            

        }
        foglio+= "\n mail compilate numero: "+ quantemail + " su " + quanti + "\ntotale soldi anticipati;";

        //fase 4: output dei dati 
        //presento i dati nella finestrella e in console così da poterli copiare e incollare su word
        System.out.println(foglio);
        
        System.out.println(totale);
    }

}
