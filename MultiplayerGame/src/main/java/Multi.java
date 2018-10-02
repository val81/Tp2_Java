
import bowling.SinglePlayerGame;
import java.util.ArrayList;
import java.util.Hashtable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author valentin
 */

public class Multi implements bowling.MultiPlayerGame {
    
   Hashtable <String,bowling.SinglePlayerGame> h;
   ArrayList<String> nom;
   int joueurcourant = -1;
    public Multi(){
        this.h = new Hashtable <String,SinglePlayerGame>();
       joueurcourant=0;
    }
    @Override
    public String startNewGame(String[] playerName) throws Exception {
      
        for (int i=0; i<playerName.length; i++){
            nom.add(playerName[i]);
            this.h.put(playerName[i],new SinglePlayerGame());
            //liste de nom 
        }
       SinglePlayerGame joueur = h.get(playerName[this.joueurcourant]);
       String r = "Prochain tir : joueur " +nom.get(this.joueurcourant)+ " tour n° "+joueur.getCurrentFrame().getFrameNumber()+", boule n°" + joueur.getCurrentFrame().getBallsThrown();
       return r;
   }

    @Override
    public String lancer(int nombreDeQuillesAbattues) throws Exception {
        SinglePlayerGame joueur = h.get(nom.get(this.joueurcourant));
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   joueur.lancer(nombreDeQuillesAbattues);
    if(this.joueurcourant==-1){
        throw new UnsupportedOperationException("Partie non demarrer");
    }
    else if( joueur.getCurrentFrame().isFinished()){
        this.joueurcourant=(this.joueurcourant+1)% nom.size();
        
    }
    else if (joueur.getCurrentFrame()!=null){
        joueur.lancer(nombreDeQuillesAbattues);
        
    }
    else{
        throw new UnsupportedOperationException("Partie terminer");
    }
    return "Prochain tir : joueur " +nom.get(this.joueurcourant)+ " tour n° "+joueur.getCurrentFrame().getFrameNumber()+", boule n°" + joueur.getCurrentFrame().getBallsThrown();
   
    }

    @Override
    public int scoreFor(String playerName) throws Exception {
        if (h.containsKey(playerName)){
            return this.h.get(playerName).score();
    }
        else {
            throw new UnsupportedOperationException("Joueur inexistant");
        }
    }
    
}
