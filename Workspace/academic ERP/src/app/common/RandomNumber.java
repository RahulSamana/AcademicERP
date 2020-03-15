package app.common;

import java.util.Random;
public class RandomNumber {
	
	public int generateRandomNumber(int lowerLimit,int upperLimit){
		Random rand = new Random();
		int R = rand.nextInt(upperLimit-lowerLimit) + lowerLimit;
		return R;
	}
}
