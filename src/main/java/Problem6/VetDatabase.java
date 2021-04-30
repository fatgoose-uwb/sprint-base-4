package Problem6;


//  /\_/\
// ( o.o )
//  > ^ <

import Common.TreeNode;
import Problem6.Pets.Animal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/*
this database uses a BST (binary search tree) to store its pet record
data record is indexed by pet's age
 */
public class VetDatabase {

    // an index implemented using a BST to allow O(lgn) search time by age
    private TreeNode<Animal> ageIndexedData;

    /*
    TODO: improve the performance (running time) of this function
     */
    public List<Animal> rangeByAge(int ageStart, int ageEnd) {
        List<Animal> result = new ArrayList<>();
        if (ageIndexedData == null) {
            return result;
        }

        Stack<TreeNode<Animal>> stack = new Stack<>();
        stack.push(ageIndexedData);
        while (!stack.isEmpty()) {
            TreeNode<Animal> node = stack.peek();

            while (node.left != null) {
                stack.push(node.left);
                node = node.left;
            }

            while (!stack.isEmpty()) {
                node = stack.pop();

                int age = node.val.getAge();
                if (age >= ageStart && age <= ageEnd) {
                    result.add(node.val);
                }
                if (node.right != null) {
                    stack.push(node.right);
                    break;
                }
            }
        }
        return result;
    }

    // Do not make changes below this line

    public VetDatabase(List<Animal> petsData) {
        createAgeIndexedData(petsData);
    }

    /*
    Create a BST index based on pet's age
     */
    private void createAgeIndexedData(List<Animal> petsData) {
        // sort by age
        Collections.sort(petsData);
        ageIndexedData = createAgeIndexedData(petsData, 0, petsData.size() - 1);
    }

    private TreeNode<Animal> createAgeIndexedData(List<Animal> petsData, int startIdx, int endIdx) {
        if (startIdx > endIdx) {
            return null;
        }

        int mid = startIdx + (endIdx - startIdx) / 2;

        TreeNode<Animal> center = new TreeNode<>(petsData.get(mid));
        center.left = createAgeIndexedData(petsData, startIdx, mid - 1);
        center.right = createAgeIndexedData(petsData, mid + 1, endIdx);

        return center;
    }
}
