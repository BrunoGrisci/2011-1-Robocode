package toalha;
import robocode.*;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/JuniorRobot.html

/**
 * Krikkit - a robot by Jorge Alberto Wagner Filho, Bruno Iochins Grisci, Luís Costa.
 */
public class Krikkit extends JuniorRobot
{
	/**
	 * run: Krikkit's default behavior
	 */
	public void run() {
		// Initialization of the robot should be put here

		// Some color codes: blue, yellow, black, white, red, pink, brown, gray, orange...
		// Sets these colors (robot parts): body, gun, radar, bullet, scan_arc
		setColors(white, gray, green, red, green);

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
			if (energy > 0) {
				turnGunTo (scannedAngle);
				fire (1.5);
			}
			else {
				turnTo (scannedAngle);
				ahead(scannedDistance);
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

	public void onHitByBullet() {
		turnGunTo(hitByBulletAngle);
		fire(0.5);
	}
}
				