package homework;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
/**
 * 空间申请释放测试
 *
 */
public class bitmapTest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		bitmap v = new bitmap();
		//存储已申请的磁盘区
		List<phisicalAddress> list = new LinkedList<>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("原始位示图");
		v.show();
		System.out.println("------------------------------");
		System.out.println("请输入你想要申请的磁盘磁盘块数");
		int number = scanner.nextInt();  //得到想要申请的磁盘块数
		int i=0;
		for(i=0;i<number;i++) {
			int xiangdui = v.add();   //向位示图申请空间
			if(xiangdui == -1) {   //位示图满了，申请失败
				System.out.println("没有空闲位置了");
				break;
			}else {    //申请成功，将用户申请成功的物理地址放到空间列表list
				phisicalAddress p =new phisicalAddress(xiangdui);
				list.add(p);
				System.out.println("成功申请相对块号"+xiangdui+"；柱面号"+p.getZhumian()+"；磁道号"
					+p.getCidao()+";扇区号"+p.getShanqu()+"的磁盘空间");
			}
		}
		System.out.println("一共成功申请到"+i+"个位置");
		System.out.println("申请后的位示图:");
		v.show();
		System.out.println("-----------------------------");
		System.out.println("正在进行磁盘回收...........");
		for(phisicalAddress pA :list) {  //遍历列表中用户申请的物理地址，并一一释放
			//得到物理地址对应的相对地址
			int xiangdui = pA.getZhumian()*16+pA.getCidao()*4+pA.getShanqu();
			v.delete(xiangdui);
			System.out.println("成功释放相对块号为"+xiangdui+"；柱面号"+pA.getZhumian()+"；磁道号"
					+pA.getCidao()+";扇区号"+pA.getShanqu()+"的磁盘空间");
		}
		System.out.println("释放后的位示图:");
		v.show();
	}

}
