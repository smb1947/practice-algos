import java.util.*;

class Activity implements Comparable<Activity>{
	public double start;
	public double end;
	
	public Activity(double start, double end){
		this.start=start;
		this.end=end;
	}
	
	public int compareTo(Activity act){
		return (int)(this.end - act.end);
	}
	
}

public class ActivitySelection{
	public int n;
	public Activity[] activities;
	
	public ActivitySelection(int n, int[] start, int[] finish){
		this.n=n;
		activities= new Activity[n];
		for(int i=0;i<n;i++){
			Activity act = new Activity(start[i], finish[i]);
			activities[i]=act;
		}
	}
	
	public void printMaxActSel(){
		Arrays.sort(activities);
		double[] start= new double[n];
		double[] end= new double[n];
		int i=0;
		for(Activity act: activities){
			start[i]=act.start;
			end[i]=act.end;
			i++;
		}
		int maxActs=1;
		double prevFinish=end[0];
		System.out.println("Selected Activities:");
		System.out.println(start[0]+"-"+end[0]);
		for(i=1;i<n;i++){
			if(start[i]>prevFinish){
				maxActs++;
				prevFinish=end[i];
				System.out.println(start[i]+"-"+end[i]);
			}
		}
		System.out.println("Maximum of number of activities: "+maxActs);
	}
	
	public static void main(String[] args){
		int s[] =  {1, 3, 0, 5, 8, 5}; 
		int f[] =  {2, 4, 6, 7, 9, 9}; 
		int n = s.length; 
		ActivitySelection actSel = new ActivitySelection(n, s, f);
		actSel.printMaxActSel();
	}
}
