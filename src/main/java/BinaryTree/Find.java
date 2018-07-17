package BinaryTree;

/**
 * @author: xiaoran
 * @date: 2018-07-13 13:35
 * 递归方式  前序，中序和后序遍历查找
 *
 */
public class Find {

    /**
     * 前序遍历
     * @param nowNode
     */
    public void preFind(Node nowNode){
        if(nowNode != null){
            System.out.print("-"+nowNode.getValue()+"-");
            preFind(nowNode.leftNext);
            preFind(nowNode.rightNext);
        }
    }

    /**
     * 中序遍历
     * @param nowNode
     */
    public void midFind(Node nowNode){
        if(nowNode != null) {
            midFind(nowNode.leftNext);
            System.out.print("-"+nowNode.getValue()+"-");
            midFind(nowNode.rightNext);
        }
    }

    /**
     * 后序遍历
     * @param nowNode
     */
    public void afterFind(Node nowNode){
        if(nowNode != null){
            afterFind(nowNode.leftNext);
            afterFind(nowNode.rightNext);
            System.out.print("-"+nowNode.getValue()+"-");
        }
    }

}
