package BinaryTree;

import lombok.Data;

/**
 * @author: xiaoran
 * @date: 2018-07-13 13:14
 * 节点
 *
 */
@Data
public class Node {
    public Node(int vaule){
        this.value = vaule;
    }

    private int value;
    public Node leftNext;
    public Node rightNext;


    public static void main(String[] args) {
        Node header = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);


        header.leftNext = node1;
        header.rightNext = node2;
        node1.leftNext = node3;
        node1.rightNext = node4;
        node2.leftNext = node5;
        node2.rightNext = node6;
        node3.leftNext = node7;
        node3.rightNext = node8;
        node4.leftNext = node9;
        node4.rightNext = node10;


        Find find = new Find();
        find.preFind(header);
        System.out.println("");
        find.midFind(header);
        System.out.println("");
        find.afterFind(header);
        System.out.println("");

        FindNoRecursive findNoRecursive = new FindNoRecursive();
        findNoRecursive.preFind(header);
//        System.out.println("");
//        findNoRecursive.midFind(header);
//        System.out.println("");
//        findNoRecursive.afterFind(header);

    }


}
