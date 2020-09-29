import java.util.Random;

import processing.core.PApplet;

public class pongRunner extends PApplet {
	private float xBall;
	private float yBall;
	private float xSpeed;
	private float ySpeed;
	private float yOpponent;
	private Random r;

	public void settings() {
		size(1000,600);
	}
	
	public void setup() {
		background(0);
		rectMode(CENTER);
		xBall = width/2;
		yBall = yOpponent = height/2;
		r = new Random();
		if(r.nextFloat() > 0.5) {
			xSpeed = -5;
		} else {
			xSpeed = 5;
		}
		if(r.nextFloat() > 0.5) {
			ySpeed = 5;
		} else {
			ySpeed = -5;
		}
	}
	
	public void draw() {
		background(0);
		rect(50, mouseY, 20, 100);
		rect(width-50, yOpponent, 20, 100);
		rect(xBall, yBall, 10, 10);
		xBall += xSpeed;
		yBall += ySpeed;
		
		if(yBall >= height-5 || yBall <= 5) {
			ySpeed *= -1;
		}
		if(xBall >= width-5 || xBall <= 5) {
			xBall = width/2;
			yBall = yOpponent = height/2;
			if(r.nextFloat() > 0.5) {
				xSpeed = -5;
			} else {
				xSpeed = 5;
			}
			if(r.nextFloat() > 0.5) {
				ySpeed = 5;
			} else {
				ySpeed = -5;
			}
		}
		
		if((yBall >= mouseY - 50 && yBall <= mouseY + 50) && (xBall >= 40 && xBall <= 60)) {
			xSpeed *= -1;
		}
		
		if(yBall > yOpponent) {
			yOpponent += 4;
		} else if(yBall < yOpponent) {
			yOpponent -= 4;
		}
		
		if((yBall >= yOpponent - 50 && yBall <= yOpponent + 50) && (xBall >= 940 && xBall <= 960)) {
			xSpeed *= -1;
		}
	}
	
	public static void main(String[] args) {
		PApplet.main("pongRunner");
	}
	
}
