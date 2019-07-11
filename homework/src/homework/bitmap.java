package homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 * 位示图类
 *
 */
public class bitmap {
	public static final int M = 40; //位示图的行数
	public static final int N = 16; //位示图的列数
	
	public int [][] bit;
	public bitmap() {
		bit = new int[M][N];
		//java.util.Random r =new java.util.Random(10);
		for(int i=0;i<40;i++) {
			for(int j=0;j<16;j++) {
				bit[i][j]=(int)(Math.random()*2);
			}
		}
	}
	
	//返回相对块号
	public int add() {

		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(bit[i][j]==0) {
					bit[i][j]=1;
					return 16*i+j;  //相对块号 = 字号*16+位号
				}
			}
		}
		return -1;
	}
	
	public void show() {
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(bit[i][j]+"  ");
			}
			System.out.println();
		}
	}
	
	public void delete(int xiangdui) {
		int zihao =xiangdui/16;
		int weihao = xiangdui%16;
		bit[zihao][weihao]=0;
	}
}
