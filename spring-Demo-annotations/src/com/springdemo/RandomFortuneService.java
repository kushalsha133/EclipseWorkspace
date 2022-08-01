package com.springdemo;
import java.util.Random;

import org.springframework.stereotype.Component;
@Component
public class RandomFortuneService implements FortuneService {
	
	private String[] fortune = new String[] {"good day", "bad day", "avg day"};
	Random rand = new Random();
//	File f = new File("fortunes");
//	FileReader fr = new FileReader(f);
//	BufferedReader br = new BufferedReader(fr);
//	
	@Override
	public String getFortuneService() {
		// TODO Auto-generated method stub
		int index = rand.nextInt(fortune.length);
		return fortune[index];
	}
}
