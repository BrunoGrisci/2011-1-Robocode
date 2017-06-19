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
		setColors(white, gray, green, yellow, green);

		// Robot main loop
		while(true) {
			// Replace the next 4 lines with any behavior you would like
			if (others > 1)
				fire(0.1);
			ahead(1000);
			turnGunTo(360);
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot() {
		// Replace the next line with any behavior you would like
		//if (scannedEnergy > 50) 
		  // {
			if (energy > 50)
			{
				turnGunTo (scannedAngle); 
				fire(3);
			}
			else
			{
				if (energy > 25)
				{ 
				turnGunTo (scannedAngle);
				fire(2);
				}
				else
				{ 
				turnGunTo (scannedAngle);
				fire(1);
				}
		}
			//} 
		//else
		//	{
		//	bearGunTo (scannedAngle);
		//	fire (1.5);
		//	}
		}
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitRobot() {
		turnGunTo (hitRobotAngle);
		//turnGunTo (scannedAngle);
		fire(3);
		back(50);
	}
	
	public void onHitWall() {
		// Replace the next line with any behavior you would like
		turnBackLeft (100,180);
	}

	public void onHitByBullet() {
		bearGunTo(hitByBulletAngle);	
	
	}
}		