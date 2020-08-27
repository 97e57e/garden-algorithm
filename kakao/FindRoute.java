package kakao;

import java.util.PriorityQueue;

public class FindRoute {
    // 14:15 시작
    // 15:30 종료
    public static void main(String[] args) {
        FindRoute findRoute = new FindRoute();
        
        int[][] nodeInfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};

        int[][] solution = findRoute.solution(nodeInfo);

        System.out.println("답");
        for (int[] ints : solution) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println(" ");
        }
    }

    static Node root;
    static int nodeSize;
    public int[][] solution(int[][] nodeinfo) {
        // 노드 만들기
        PriorityQueue<Node> nodeQueue = new PriorityQueue<>();
        for (int i=0; i<nodeinfo.length; i++) {
            nodeQueue.add(new Node(i+1, nodeinfo[i][1], nodeinfo[i][0]));
        }
        nodeSize = nodeQueue.size();

        // 트리 생성
        root = nodeQueue.poll();
        while(!nodeQueue.isEmpty()) {
            insertNode(root, nodeQueue.poll());
        }

        int[][] answer = new int[2][nodeSize];

        answer[0] = getPreOrder();
        answer[1] = getPostOrder();

        return answer;
    }

    static int orderIdx;
    public int[] getPreOrder() {
        int[] order = new int[nodeSize];
        orderIdx = 0;
        preOrder(root, order);

        return order;
    }
    public void preOrder(Node node, int[] order) {
        if (node == null) {
            return;
        }

        order[orderIdx++] = node.id;
        preOrder(node.left, order);
        preOrder(node.right, order);
    }

    public int[] getPostOrder() {
        int[] order = new int[nodeSize];
        orderIdx = 0;
        postOrder(root, order);
        return order;
    }

    public void postOrder(Node node, int[] order) {
        if (node == null) {
            return;
        }

        postOrder(node.left, order);
        postOrder(node.right, order);
        order[orderIdx++] = node.id;
    }



    public void insertNode(Node parent, Node node) {
        if (node.x < parent.x) {
            //왼쪽으로
            if (parent.left != null) {
                insertNode(parent.left, node);
            } else {
                parent.left = node;
            }
        } else {
            // 오른쪽으로
            if (parent.right != null) {
                insertNode(parent.right, node);
            } else {
                parent.right = node;
            }
        }
    }

    static class Node implements Comparable<Node>{
        int id;
        int y;
        int x;

        Node left;
        Node right;

        public Node(int id, int y, int x) {
            this.id = id;
            this.y = y;
            this.x = x;
        }

        @Override
        public int compareTo(Node o) {
            return o.y - this.y;
        }
    }
}
