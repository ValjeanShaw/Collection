package Base;

/**
 *
 */
public class StaticLinkList {
	class Component{
		Object data;
		int cur;
	}
	
	final int MaxSize=1000;
	int length;
	Component[] staticLinkList=new Component[MaxSize];
	public StaticLinkList() {
		for(int i=0;i<MaxSize-1;i++) {
			staticLinkList[i] = new Component();
			staticLinkList[i].cur=i+1;
		}
		staticLinkList[MaxSize-1] = new Component();
		staticLinkList[MaxSize-1].cur=0;
		length=0;
	}
	//取出第一个可以用的结点标号
	public int malloc_SLL() {
		int i=staticLinkList[0].cur;//取出第一个可以用的结点标号
		staticLinkList[0].cur=staticLinkList[i].cur;//将下一个结点的标号存在staticLinkList[0].cur中
		return i;
	}
//	public void add(Object data) {
//		Component item=staticLinkList[length+1];
//		item.data=data;
//		length++;
//		staticLinkList[MaxSize-1].cur=1;//放置数据的第一个位置为1
//		
//	}
	public void listInsert(int loc,Object data) throws Exception {
		int i=malloc_SLL();
		int k=MaxSize-1,x=MaxSize-1;
		if(loc>length||loc<1) {
			throw new Exception("位置错误");
		}
		else if(loc==1) {
			Component com1=staticLinkList[i];//先将要插入的元素放在第一个空闲位置上
			com1.data=data;
			com1.cur=staticLinkList[1].cur;
			staticLinkList[MaxSize-1].cur=i;
			length++;
			for(int j=1;j<=length;j++) {
				k=staticLinkList[j].cur;
			}
			staticLinkList[k].cur=0;
		}
		else {
			Component com1=staticLinkList[i];//先将要插入的元素放在第一个空闲位置上
			com1.data=data;
			for(int j=1;j<loc;j++)//取出插入位置的前一个元素
				x=staticLinkList[j].cur;
			Component com=staticLinkList[x];
			com1.cur=com.cur;
			com.cur=i;
			length++;
			for(int j=1;j<=length;j++) {
				k=staticLinkList[j].cur;
			}
			staticLinkList[k].cur=0;
		}
	}
	public Object getItem(int i) {
		int x=MaxSize;
		for(int j=1;j<=i;j++) {
			x=staticLinkList[j].cur;
		}
		return staticLinkList[x].data;
	}


	public static void main(String[] args) {
		try{
			StaticLinkList sLink=new StaticLinkList();
			sLink.listInsert(1,1);
			sLink.listInsert(2,2);
			sLink.listInsert(3,3);
			sLink.listInsert(4,4);
			for(int i=1;i<=sLink.length;i++) {
				System.out.println(sLink.getItem(i));
			}
		}catch (Exception e){
			e.printStackTrace();
		}

	}

}
