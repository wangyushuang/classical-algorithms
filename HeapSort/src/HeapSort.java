import java.util.Arrays;

/**
*堆排序
*1.堆排序是对简单排序的改进，也属于选择排序
*2.堆排序是一种基于完全二叉树的树形选择排序方法
*3.堆排序是原值排序
 */

public class HeapSort {
	private static void swap(int[] list, int i, int j) {
		/**
		 * 交换数组中两个元素
		 */
		int tmp=list[i];
		list[i]=list[j];
		list[j]=tmp;
	}
	/**
	 * 维护最大堆性质
	 * 节点i的左子树和右子树都是最大堆，使得i也为最大堆
	 * @param list 堆
	 * @param i	第i个节点
	 * @param size 堆的大小，即堆中节点个数
	 */
	public static void maxHeapify(int[] list, int i, int size) {
		//从list[i],list[LEFT(i)],list[right(i)]中选出最大值
		int iMax=i;
		if(2*i+1<size && list[2*i+1]>list[i]) {
			iMax=2*i+1;
		}
		if(2*i+2<size && list[2*i+2]>list[i]) {
			iMax=2*i+2;
		}
		if(iMax!=i) {
			swap(list,i,iMax);
			maxHeapify(list,iMax,size);
		}
	}
	/**
	 * 将数组list创建成最大堆，使其满足：
	 * 每一个节点都满足最大堆性质
	 * @param list 待生成最大堆数组
	 */
	public static void buildMaxHeap(int[] list) {
		int n=(list.length-1)>>1;
		for(int i=n;i>=0;i--) {
			maxHeapify(list,i,list.length);
		}
	}
	/**
	 * 堆排序：
	 * 1.创建最大堆
	 * 2.把堆顶元素（即最大值）与堆尾元素交换，堆大小减1
	 * 3.递归调用maxHeapify(),使其保持最大堆性质
	 * 4.重复2-3，直到堆大小为0
	 * @param list 待排序数组
	 */
	public static void heapSort(int[] list) {
		int len=list.length;
		buildMaxHeap(list);
		while(len>0) {
			swap(list,0,len-1);
			len--;
			maxHeapify(list,0,len);
		}
	}
	public static void main(String[] args) {
		int [] list= {6,5,4,3,2,1,7,0};
		heapSort(list);
		System.out.println(Arrays.toString(list));
	}
}
