/* 
 * LeJOS drive v1.2
 * Testing required
 * 	-Does not turn right
 * 		-All other buttons and if statements function fine
 * 	-Test again with isDown() instead of isPressed()
 */

import lejos.nxt.*;

public class LeJOS_Run {

	public static void main(String[] args) {
		
		//Sets motor speeds to 500
		//Possibly not fast enough? Certainly not for anything larger than current size
		Motor.A.setSpeed(500);
		Motor.B.setSpeed(500);
		
		boolean forward = false;
		boolean turnRight = false;
		boolean turnLeft = false;
		boolean stop = false;
		
		while (!stop) {
			
			if (Button.ENTER.isDown()) {
				forward = true;
				turnLeft = false;
				turnRight = false;
			}
			
			if (Button.RIGHT.isDown()) {
				forward = false;
				turnLeft = false;
				turnRight = false;
			}
			
			if (Button.LEFT.isDown()) {
				forward = false;
				turnLeft = true;
				turnRight = false;
			}
			
			if (Button.ESCAPE.isDown()) {
				stop = true;
			}
			
			if (forward) {
				Motor.A.forward();
				Motor.B.forward();
			}
			
			//Currently not working
			if (turnRight) {
				Motor.A.forward();
				Motor.B.backward();
			}
			
			if (turnLeft) {
				Motor.A.backward();
				Motor.B.forward();
			}
			
		}

	}

}
