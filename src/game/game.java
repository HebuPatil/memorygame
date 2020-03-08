package game;

import java.util.*;
import java.awt.*;



class game {
	public static int getInt(int max) {
		  return (int) Math.floor(Math.random() * Math.floor(max));
		}
	public static void main(String args[]) {
		//Scanner
		boolean uneducated = true;
		
		Scanner myObj = new Scanner(System.in);
		System.out.println("Welcome to the Memory Game!\nIn this game you must remember all of the squares that blinked in order.\nFor example, if the red blinks, the blue blinks, and the red blinks again. You need to enter rbr.\nIn the same fashion, if red blinks, and then yellow blinks you must enter yr.\ny is yellow, r is red, b is blue, and g is green.\nIf you dont enter your answer in lowercase alphabets with no space your answer will be wrong.\nAlso, you must alt-tab quickly to get back to the display to see your next challenge, each time the game gets harder and you will have to remember more colors. ");
		while (uneducated) { 
			System.out.println("Here is a test:\nIf blue blinks, red blinks, and yellow blinks, what is the answer? ");
			String answer = myObj.nextLine();
			if (answer.equals("bry")) {
				System.out.println("Correct");
				break;
			}
		}
		System.out.println("Loading... (Alt-tab quick)");
		//Drawings
		final DrawingPanel panel = new DrawingPanel(500,450);
    	Graphics a = panel.getGraphics();
    	a.setColor(Color.GREEN);
    	a.fillRect (0, 0, 250, 225);
    	Graphics b = panel.getGraphics();
    	b.setColor(Color.RED);
    	b.fillRect (250, 0, 250, 225);
    	Graphics c = panel.getGraphics();
    	c.setColor(Color.YELLOW);
    	c.fillRect (0, 225, 250, 225);
    	Graphics d = panel.getGraphics();
    	d.setColor(Color.BLUE);
    	d.fillRect (250, 225, 250, 225);
    	panel.sleep(1000);
    	
    	//loop
    	String ans = "";
    	int count = 1;
		boolean ok = true;
    	while (ok) {
    		for (int i = 0; i <= count; i++) {
    			int theone = getInt(4);
    			switch (theone) {
    				case 0:
    					a.setColor(Color.BLACK);
    			    	a.fillRect (0, 0, 250, 225);
    			    	panel.sleep(250);
    			    	a.setColor(Color.GREEN);
    			    	a.fillRect (0, 0, 250, 225);
    			    	ans+="g";
    			    	break;
    				case 1:
    					b.setColor(Color.BLACK);
    			    	b.fillRect (250, 0, 250, 225);
    			    	panel.sleep(250);
    					b.setColor(Color.RED);
    			    	b.fillRect (250, 0, 250, 225);
    			    	ans+="r";
    					break;
    				case 2:
    					c.setColor(Color.BLACK);
    			    	c.fillRect (0, 225, 250, 225);
    			    	panel.sleep(250);
    			    	c.setColor(Color.YELLOW);
    			    	c.fillRect (0, 225, 250, 225);
    			    	ans+="y";
    					break;
    				case 3:
    					d.setColor(Color.BLACK);
    			    	d.fillRect (250, 225, 250, 225);
    			    	panel.sleep(250);
    			    	d.setColor(Color.BLUE);
    			    	d.fillRect (250, 225, 250, 225);
    			    	ans+="b";
    					break;
    			}
    			panel.sleep(250);
    		}
    	    System.out.println("what is the pattern? ");
    	    String user = myObj.nextLine();
    	    if (user.equals(ans)) {
    	    	System.out.println("Correct!");
    	    	System.out.println("Alt tab quick!");
    	    	ans = "";
    	    }else {
    	    	System.out.println("Wrong.\n");
    	    	System.out.println("The answer was: " + ans);
    	    	System.out.println("Your score was: " + count);
    	    	System.out.println("Good Job!");
    	    	panel.exit();
    	    	ok = false;
    	    	
    	    }
    	    
    		count += 1;
    		panel.sleep(2000);
    		System.out.println();
    	}
    	myObj.close();
	}
}