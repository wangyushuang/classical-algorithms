import java.util.Arrays;
/**
 * 堆排序属于选择排序，是原值排序，不是稳定排序
 * @author WYS
 *
 */
public class HeapSort {

	private static void swap(int [] list, int i, int j) {
		int tmp=list[i];
		list[i]=list[j];
		list[j]=tmp;
	}
	/**维护堆的性质
	 * 假设根节点为LEFT(i)和RIGHT(i)的二叉树都是最大堆，通过让list[i]逐级下降，
	 * 使得以下标i为根节点的树也为最大堆
	 * @param list 二叉树数组
	 * @param i 待生成最大堆的节点下标
	 * @param size 树的节点个数
	 */
	public static void maxHeapify(int[] list, int i, int size) {
		int index=i;
		int l=2*i+1;
		int r=2*i+2;
		//选出下标为i，l，r中值最大的下标
		if(l<size && list[l]>list[i])
			index=l;
		if(r<size && list[r]>list[index])
			index=r;
		if(index!=i) {
			swap(list,i,index);
			maxHeapify(list,index,size);
		}
	}
	/**
	 * 将数组list转化为最大堆
	 * @param list 待生成最大堆的数组
	 */
	public static void buildMaxHeap(int[] list) {
		int n=(list.length-2)>>1;//具有子节点的最大下标
		//从底往上，将具有子节点的元素构建最大堆
		for(int i=n;i>=0;i--) {
			maxHeapify(list,i,list.length);
		}
	}
	/**
	 * 构建最大堆之后，将根元素（最大值）从堆中移除，刷新堆，使其更新为最大堆，再移除堆顶元素,……,循环至二叉树大小为1
	 * @param list 待排序数组
	 */
	public static void heapSort(int[] list) {
		buildMaxHeap(list);
		int len=list.length;
		while(len>0) {
			swap(list,0,len-1);
			len--;
			maxHeapify(list,0,len);
		}
	}
	public static void main(String[] args) {
		int[] list= {1,2,3,5,4,3,2,9,8,6,7,0};
		heapSort(list);
		System.out.println(Arrays.toString(list));
	}
}
