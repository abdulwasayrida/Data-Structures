

/**
 * FriendNetwork.java    
 * @author abdulwasayrida
 * @author ameyadighe
 * CIS 22C, Lab 6
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FriendNetwork {
	public static void main(String[] args) throws FileNotFoundException {
		boolean b=false, rec;
		int vert,id,in, l = 0, c = -1;
		String name,friends;
		ArrayList<String>names=new ArrayList<>();
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome to the Friend Recommender!\n");
		while (b==false) {
			System.out.print("Enter the name of a file: ");
			String fileName=sc.nextLine();
			while(!(fileName.substring(fileName.length()-4).equals(".txt"))) {
				System.out.println("\nInvalid file name!");
				System.out.print("Enter the name of the file: ");
				fileName=sc.nextLine();
				System.out.println();
			}
			try {
				File file=new File(fileName);
				Scanner input=new Scanner(file);
				vert=input.nextInt();
				Graph g=new Graph(vert);
				while(input.hasNextLine()){
					id=input.nextInt();
					input.nextLine();
					name=input.nextLine();
					names.add(name);
					friends=input.nextLine();
					String[]arrFriends=friends.split(",");
					for(int i=0;i<arrFriends.length;i++) {
						if(arrFriends[i]==null) {
							;;
						}else{
							if(arrFriends[i].charAt(0)==' ') {
								arrFriends[i]=arrFriends[i].substring(1,arrFriends[i].length());
							}
							if(g.getAdjacencyList(id).linearSearch(Integer.parseInt(arrFriends[i]))==-1) {
								g.addUndirectedEdge(id,Integer.parseInt(arrFriends[i]));
							}
						}
					}
				}
				input.close();
				System.out.println("Enter Your User Number Below:");
				for(int i=0;i<names.size();i++) {
					System.out.println((i+1)+". "+names.get(i));
				}
				System.out.print("\nEnter your choice: ");
				in=sc.nextInt();
				sc.nextLine();
				do{
					if(l!=0){
						g.addUndirectedEdge(in,c);
					}
					System.out.print("\nHere are your current friends:\n");	
					g.getAdjacencyList(in).placeIterator();
					for(int i=1;i<=g.getAdjacencyList(in).getLength();i++) {
						System.out.print(g.getAdjacencyList(in).getIterator()+". ");
						System.out.println(names.get(g.getAdjacencyList(in).getIterator()-1));
						if(g.getAdjacencyList(in).getIterator()==g.getAdjacencyList(in).getLast()) {
							break;
						}
						g.getAdjacencyList(in).advanceIterator();
					}
					rec=false;
					System.out.println("\nHere are your recommended friends:");
					g.BFS(in);
					for(int i=1;i<=g.getNumVertices();i++){
						if(g.getDistance(i)>1){
							System.out.print(i+". ");
							System.out.println(names.get(i - 1));
							rec=true;
						}
					}
					if(rec==false){
						System.out.println("Sorry! We don't have any recommendations for you at this time.");
						c=-1;
						b=true;
						break;
					}else{
						l++;
						System.out.println("\nEnter the number of a friend to add or -1 to quit:");
						System.out.print("Enter your choice: ");
						c=sc.nextInt();
						sc.nextLine();
						if(c==-1){
							b=true; 
							break;
						}
					}
				}while(c!=-1);
			}catch(IOException e){
				System.out.println("Invalid File Name");	
			}
		}
		sc.close();
		System.out.println("\nGoodbye!");
	}
}



