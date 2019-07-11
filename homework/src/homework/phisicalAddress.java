package homework;
/**
 * 物理地址类
 *
 */
public class phisicalAddress {
	private int  zhumian;  //柱面号
	private int cidao;  //磁道号
	private int shanqu;  //扇区号
	public int getZhumian() {
		return zhumian;
	}
	public void setZhumian(int zhumian) {
		this.zhumian = zhumian;
	}
	public int getCidao() {
		return cidao;
	}
	public void setCidao(int cidao) {
		this.cidao = cidao;
	}
	public int getShanqu() {
		return shanqu;
	}
	public void setShanqu(int shanqu) {
		this.shanqu = shanqu;
	}
	public phisicalAddress(int zhumian, int cidao, int shanqu) {
		super();
		this.zhumian = zhumian;
		this.cidao = cidao;
		this.shanqu = shanqu;
	}
	/**
	 * 得到相对地址计算出的物理地址
	 * @param xiangdui
	 */
	public phisicalAddress(int xiangdui) {
		zhumian = xiangdui/16;  //柱面号=相对块号/16
		cidao = (xiangdui%16)/4;    //磁道号 = （相对块号/16的余数）/4
		shanqu = (xiangdui%16)%4;    //物理块号 = （相对块号/16的余数）%4
	}
	
	
}
