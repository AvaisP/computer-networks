import java.util.*;
import java.io.*;
class Node
{
	int[] dist=new int[20];
	int[] from=new int[20];
}

class dvr
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number of nodes:");
		int n = sc.nextInt();
		Node rt[] = new Node[n];
		int costmat [][] = new int[n][n];
		int i,j,k;
		for(i = 0; i < n; i++)
		{
			rt[i] = new Node();
			for(j = 0; j < n; j++)
			{
				System.out.println("Enter cost of "+i+","+j);
				costmat[i][j] = sc.nextInt();
				costmat[i][i] = 0;
				rt[i].dist[j] = costmat[i][j];
				rt[i].from[j] = j;
			}
		}
		int count;
		do{
			count = 0;
			for(i = 0; i < n; i++){
				for(j = 0; j < n; j++){
					for(k = 0; k < n; k++){
						if(rt[i].dist[j] > costmat[i][k] + rt[k].dist[j]){
							rt[i].dist[j] = costmat[i][k] + rt[k].dist[j];
							rt[i].from[j] = k;
							count += 1;
						}
					}
				}
			}

		}while(count!=0);

		for(i = 0; i < n; i++){
			System.out.println("For router " + (i+1));
			for(j = 0; j < n; j++){
				System.out.println("Node " +(j+1) + " via " + (rt[i].from[j]+1) + "distance " + rt[i].dist[j]);
			}
			System.out.println();
		}
	}
}