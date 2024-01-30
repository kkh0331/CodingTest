package tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class baekjoon_5639 {

    public static Node head;
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int headValue = Integer.parseInt(br.readLine());
        head = new Node(headValue);
        String input = "";
        while((input = br.readLine()) != null && !input.isEmpty()){
            insertNode(head, Integer.parseInt(input));
        }
        postOrder(head);
        bw.close();
    }

    public static class Node{
        Node left;
        Node right;
        int value;

        public Node(int value){
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static void insertNode(Node head, int value){
        if(head.value < value){
            if(head.right == null){
                head.right = new Node(value);
            } else {
                insertNode(head.right, value);
            }
        } else {
            if(head.left == null){
                head.left = new Node(value);
            } else {
                insertNode(head.left, value);
            }
        }
    }

    public static void postOrder(Node head) throws Exception{
        if(head == null) return;
        postOrder(head.left);
        postOrder(head.right);
        bw.write(head.value+"\n");
    }

}
