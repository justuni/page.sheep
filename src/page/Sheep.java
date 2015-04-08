package page;

import java.util.Random;
import was.GameBoard;
import was.Move;


/**
 * An example sheep
 * @author dr
 */
public class Sheep  extends was.SheepPlayer{
    
        int a = 0;  //Move x direction
        int b = 0;  //Move y direction
        
        int c = 0;
        int d = 0;
    
    private static Random rand = new Random();
    GameBoard board = null;
    Move direction = null; // direction we're taking
    
    
    @Override
    public void initialize() {
        // you cannot call "getGameBoard" in the constructor, as the
        // game board is created after all the players.

        board = getGameBoard();
        board.getPasturePositions();
        board.getSheepPositions();
        board.getPiece(a, b);
    }

    @Override
    public Move move() {
        // if direction is not yet set, choose a random one
        a = 0;
        b = 0;
        
        int pastChoose = 0;
                
    
       /** if ((Math.abs(board.getPasturePositions().get(0).x - board.getSheepPositions().get(0).x)) > (Math.abs(board.getPasturePositions().get(4).x - board.getSheepPositions().get(0).x))) {
            
              pastChoose = 4;
            
         
        }
        **/
        
        System.out.println(pastChoose);
        if(getLocation().x > board.getPasturePositions().get(pastChoose).x){
            a = -1;
            direction = new Move(a,b);
            direction = direction.scaledToLength(getMaxAllowedDistance()).quantized();
            System.out.println("Left One");

        }
        
        else if(getLocation().x < board.getPasturePositions().get(pastChoose).x){
            a = 1;
            direction = new Move(a,b);
            direction = direction.scaledToLength(getMaxAllowedDistance()).quantized();
            System.out.println("Right One");

        }
        
        if(getLocation().y > board.getPasturePositions().get(pastChoose).y){
            b = -1;
            direction = new Move(a,b);
            direction = direction.scaledToLength(getMaxAllowedDistance()).quantized();
            System.out.println("Up One");

        }
        
        else if(getLocation().y < board.getPasturePositions().get(pastChoose).y){
            b = 1;
            direction = new Move(a,b);
            direction = direction.scaledToLength(getMaxAllowedDistance()).quantized();
            System.out.println("Down One");

        }
        
       
        /* Note:
         * You may visualize a path using the visualizeTrack() method from Player.
         * The following code shows a path from the player's location to
         * location <5,5>.
         * You may visualize as many paths as you like.

            List<GameLocation> trk = new ArrayList();
            trk.add(getLocation());
            trk.add(new GameLocation(5,5));            
            removeVisualizations(); // remove all previously set tracks
            visualizeTrack(trk);
        */
    
    
    //Check is random point is blocked
    
     int sheepLocationX = getLocation().x;
        int sheepLocationY = getLocation().y;
        
        System.out.print(checkDirectPath(new was.GameLocation(sheepLocationX,sheepLocationY), new was.GameLocation(0,0)));
            
               
        return direction;
        
    }
    public boolean checkDirectPath(was.GameLocation a, was.GameLocation b){
        boolean result = true;
        
           int testLocationX = a.x;
           int testLocationY = a.y;
        
        while ((result == true) && (testLocationX != b.x) && (testLocationY != b.y)) {
            

            
            if ((board.getPiece(testLocationX, testLocationY)) == GamePiece.OBSTACLE) {
                
                   result = false;
            }


            if (testLocationX < b.x){
                 testLocationX += 1;
            }
            else if (testLocationX > b.x){
                 testLocationX -= 1;
            }

            if (testLocationY < b.y){
                 testLocationY += 1;
            }
            else if (testLocationY > b.y){
                 testLocationY -= 1;
            }
            
            
            }
        
        return result; 
    }
}
