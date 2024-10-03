/**
 * This is used to test the Generic List code.
 * Author: JJB
 * Date: 5/27/2023
 */
public class TestGenericList {
    public static void main(String[] args) {
        GenericList<Integer> gList = new GenericList<Integer>();
        
        // add 0 - 9 to list
        for (int i = 0; i < 10; i++)
            gList.add(i, Integer.valueOf(i));

        System.out.println("Test Add 0 - 9: ");
        System.out.println(gList.toString());
        System.out.println("Test isEmpty (false): " + gList.isEmpty());
        System.out.println("Test Size: " + gList.size());
        System.out.println();

        System.out.println("Test get:");
        for (int i = 0; i < 10; i++)
            System.out.print("Get i=" + i + " : " + gList.get(i) + "\t");
        System.out.println();

        // remove odds from list
        for (int i = 9; i >= 0; i = i - 2) 
            gList.remove(i);

        System.out.println(        );
        System.out.println("Test Remove 0,2,4,6,8");
        System.out.println(gList.toString());
        System.out.println("Test isEmpty (false): " + gList.isEmpty());
        System.out.println("Test Size: " + gList.size());

        System.out.println();
        System.out.println("Test Remove All: ");
        gList.removeAll();
        System.out.println(gList.isEmpty());
        System.out.println("Test isEmpty (True): " + gList.isEmpty());
        System.out.println("Test Size: " + gList.size());
        System.out.println();
    }

}
