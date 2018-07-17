package BinaryTree;

import java.util.Stack;

/**
 * @author: xiaoran
 * @date: 2018-07-13 16:26
 */
public class FindNoRecursive {


    /**
     * 非递归前序遍历
     *
     * @param header
     */
    public void preFind(Node header) {
        Stack<Node> stack = new Stack<Node>();
        stack.push(header);
        Node nowNode = null;
        while (!stack.isEmpty()) {
            nowNode = stack.pop();
            if (nowNode != null) {
                System.out.print("-" + nowNode.getValue() + "-");
                stack.push(nowNode.rightNext);
                stack.push(nowNode.leftNext);
            }
        }
    }



}
