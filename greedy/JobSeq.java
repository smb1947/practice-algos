import java.util.*;
class Job implements Comparable<Job>{
	int x;
	int deadline;
	int profit;
	
	public Job(int m, int d, int p){
		x=m;
		deadline=d;
		profit=p;
	}
	
	// copy constructor 
    public Job(Job c) { 
        System.out.println("Copy constructor called"); 
        x = c.x; 
        deadline = c.deadline;
        profit = c.profit; 
    }
	
	@Override
	public String toString(){
		return "( "+x+"-"+deadline+"-"+profit+" )";
	}
	
	// descending order
	public int compareTo(Job other){
		return other.profit - this.profit;
	}
}

public class JobSeq{

int n;
Job[] jobs;

public JobSeq(int m, int[] d, int[] p){
	n=m;
	jobs = new Job[n];
	for(int i=0;i<n;i++){
		jobs[i]= new Job(i+1,d[i],p[i]);
	}
}

public void doJobSeq(){
	
	Job[] sortedJobs = new Job[n];
	int maxDeadline =0;
	for(int i=0;i<n;i++){
		sortedJobs[i]= new Job(jobs[i]);
		if(maxDeadline<jobs[i].deadline)
			maxDeadline=jobs[i].deadline;
	}
	
	Arrays.sort(sortedJobs);
	System.out.println("Sorted jobs: ");
	for(int i=0;i<n;i++){
		System.out.println(sortedJobs[i]);
	}
	
	int maxProfit=sortedJobs[0].profit;
	int[] deadline = new int[maxDeadline+1];
	deadline[sortedJobs[0].deadline]=sortedJobs[0].x;
	System.out.println("Selected Jobs:");
	System.out.print(sortedJobs[0].x+" ");
	for(int i=1;i<n;i++){
		for(int j=sortedJobs[i].deadline;j>0;j--)
			if(deadline[j]==0){
				deadline[j]=sortedJobs[i].x;
				maxProfit= maxProfit+sortedJobs[i].profit;
				System.out.print(sortedJobs[i].x+" ");
				break;
			}
	}
	System.out.println();
	System.out.println("Max profit: "+ maxProfit);
}

public static void main(String args[]){
	int n=5;
	int[] d={2,1,2,1,3};
	int[] p={100,19,27,25,15};
	JobSeq js= new JobSeq(n,d,p);
	js.doJobSeq();
}
}