
public class practice {
    public static void main(String[] args) {
        BST<Integer> B = new BST<Integer>();
        B.insert(50);
        B.insert(17);
        B.insert(76);
        B.insert(9);
        B.insert(23);
        B.insert(14);
        B.insert(19);
        B.insert(12);
        B.insert(54);
        B.insert(72);
        B.insert(67);

        B.inOrderPrint();
        B.preOrderPrint();
        B.postOrderPrint();


    }

}
