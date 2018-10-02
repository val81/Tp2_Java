import Multigame.Multi;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
/**
 *
 * @author valentin
 */
public class MultiTest {
    private Multi game ;
  
    
    
    
    @Before
	public void setUp() {
		game = new Multi();
               
                
	}
       @Test
	public void start() throws Exception{
            String playerName[] = {"Bea","Thomas"};
            game.startNewGame(playerName).equals("Prochain tir : joueur Bea tour n°1 boule n°1");
        }
        
        
       @Test
        public void lancerTest() throws Exception{
            String playerName[] = {"Bea","Thomas"};
            game.startNewGame(playerName);
            game.lancer(5);
            game.lancer(4);
            game.lancer(4);
            assertEquals(0,game.joueurcourant);
            


  }
        @Test
        public void  scoreTeset() throws Exception{
            String playerName[] = {"Bea"};
            game.startNewGame(playerName);
            rollMany(20, 0);
	    assertEquals(0, game.scoreFor("Bea"));
            
        }
        private void rollMany(int n, int pins) throws Exception {
		for (int i = 0; i < n; i++) {
			game.lancer(pins);
		}
	}
        
}