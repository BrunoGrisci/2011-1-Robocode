package JBL;
import robocode.*;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/JuniorRobot.html

/**
 * Troll - a robot by Jorge Alberto Wagner Filho, Bruno Iochins Grisci, Luís Costa.
 */
public class Troll extends JuniorRobot
{
	/**
	 * run: Troll's default behavior
	 */
	public void run() {
		// Initialization of the robot should be put here

		// Some color codes: blue, yellow, black, white, red, pink, brown, grey, orange...
		// Sets these colors (robot parts): body, gun, radar, bullet, scan_arc
		setColors(white, black, white, red, green);

		// Robot main loop
		while(true) {
			// Replace the next 4 lines with any behavior you would like
			//ahead(100);
			turnAheadRight(100, 45);
			
			turnGunRight(scannedAngle);
			//back(1);
			//turnGunRight(90);
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot() {
		// Replace the next line with any behavior you would like
		if (scannedEnergy > 50) {
			if (energy > 50) fire(3);
			else {
				fire(1);
				back(5);
			}
		} 
		else {
			fire(2);
			ahead(10);
		}
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet() {
		// Replace the next line with any behavior you would like
		if (energy>25) {
			turnBackRight (100, 90); 
			turnGunTo (scannedAngle);
			fire (1);
			//turnGunLeft(90);
		}
		else {
		while (energy<=25) {
			//back(10);
			turnBackLeft (100, 45);
			turnGunRight(scannedAngle);
			fire(0.5);
			}
		}
	}
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitRobot() {
		turnGunTo (scannedAngle);
		fire(3);
		back(50);
	}
	
	public void onHitWall() {
		// Replace the next line with any behavior you would like
		//back(20);
		turnGunRight(scannedAngle);
		//back(100);
		turnBackLeft (100,45);
		//back(90);
		//turnTo(90);
		//ahead(50);
	}	
}
