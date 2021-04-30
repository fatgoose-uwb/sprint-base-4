import Common.TreeNode;
import Problem5.BinaryTree;
import Problem6.Pets.Animal;
import Problem6.Pets.Cat;
import Problem6.Pets.Dog;
import Problem6.VetDatabase;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Problem6Test {
    public static class RangeByAgeTestCase {
        int start;
        int end;
        List<Animal> expect;

        public RangeByAgeTestCase(int start, int end, List<Animal> animals) {
            this.start = start;
            this.end = end;
            this.expect = new ArrayList<>();

            // could use a better complexity algorithm
            for (Animal animal : animals) {
                int age = animal.getAge();
                if (age >= start && age <= end) {
                    expect.add(animal);
                }
            }

            // may not be necessary but kept here just to be agnostic to the order of Pets in the result
            Collections.sort(expect);
        }

        @Override
        public String toString() {
            return "RangeByAgeTestCase{" +
                    "start=" + start +
                    ", end=" + end +
                    ", expect=" + expect +
                    '}';
        }
    }

    @Test
    public void testSamplingRangeByAge() {
        List<Animal> animals = getAnimalsInBalancedBST();

        List<RangeByAgeTestCase> testCases = getSampleRangeByAgeTestCases(animals);

        VetDatabase db = new VetDatabase(animals);
        for (RangeByAgeTestCase testCase : testCases) {
            List<Animal> actual = db.rangeByAge(testCase.start, testCase.end);

            // may not be necessary but kept here just to be agnostic to the order of Pets in the result
            Collections.sort(actual);

            assertEquals(testCase.toString(), testCase.expect, actual);
        }
    }

    /*
    TODO: record your run times:
    BEFORE: ?? ms
    AFTER: ?? ms
    Improvement: ??
     */
    @Test
    public void benchmarkComprehensiveRangeByAge() {
        final int AnimalCount = 5000000;
        final int MaxAge = 50;
        List<Animal> animals = getLotsOfAnimals(AnimalCount, MaxAge);

        final int start = 3;
        final int end = 5;
        RangeByAgeTestCase testCase = new RangeByAgeTestCase(start, end, animals);

        VetDatabase db = new VetDatabase(animals);

        long startTime = System.nanoTime();

        List<Animal> actual = db.rangeByAge(testCase.start, testCase.end);

        long endTime = System.nanoTime();
        long durationInMs = (endTime - startTime) / 1000000;

        // may not be necessary but kept here just to be agnostic to the order of Pets in the result
        Collections.sort(actual);

        assertEquals(testCase.toString(), testCase.expect, actual);

        System.out.println("this run took " + durationInMs + " milliseconds.");
    }

    // call me crazy, but...
    @Test
    public void testComprehensiveRangeByAge() {
        final int AnimalCount = 10000;
        final int MaxAge = 20;
        List<Animal> animals = getLotsOfAnimals(AnimalCount, MaxAge);

        List<RangeByAgeTestCase> testCases = getComprehensiveRangeByAgeTestCases(animals);

        VetDatabase db = new VetDatabase(animals);
        for (RangeByAgeTestCase testCase : testCases) {
            List<Animal> actual = db.rangeByAge(testCase.start, testCase.end);

            // may not be necessary but kept here just to be agnostic to the order of Pets in the result
            Collections.sort(actual);

            assertEquals(testCase.toString(), testCase.expect, actual);
        }
    }

    @Test
    public void testAgeIndexEvenNumberOfNode() throws NoSuchFieldException, IllegalAccessException {
        List<Animal> animals = Arrays.asList(
                new Cat("Alex", "male", 2),
                new Dog("David", "male", 12, "Peng"),
                new Cat("Tommy", "male", 5),
                new Dog("Sally", "female", 1, "Seattle Humane")
        );

        TreeNode<Animal> expectRoot = new TreeNode<>(animals.get(0));
        expectRoot.left = new TreeNode<>(animals.get(3));
        expectRoot.right = new TreeNode<>(animals.get(2));
        expectRoot.right.right = new TreeNode<>(animals.get(1));

        // reflection to get access to a private field in the class.
        // not the best idea. let me know if you have a better way to test this.
        validateIndexedData(animals, expectRoot);
    }

    @Test
    public void testAgeIndexOddNumberOfNode() throws NoSuchFieldException, IllegalAccessException {
        List<Animal> animals = getAnimalsInBalancedBST();

        TreeNode<Animal> expectRoot = new TreeNode<>(animals.get(2));
        expectRoot.left = new TreeNode<>(animals.get(0));
        expectRoot.right = new TreeNode<>(animals.get(4));
        expectRoot.left.left = new TreeNode<>(animals.get(3));
        expectRoot.left.right = new TreeNode<>(animals.get(6));
        expectRoot.right.left = new TreeNode<>(animals.get(5));
        expectRoot.right.right = new TreeNode<>(animals.get(1));

        validateIndexedData(animals, expectRoot);
    }


    private List<RangeByAgeTestCase> getComprehensiveRangeByAgeTestCases(List<Animal> animals) {
        List<RangeByAgeTestCase> result = new ArrayList<>();
        final int RangeStart = -20;
        final int RangeEnd = 20 * 2;

        for (int start = RangeStart; start < RangeEnd; start++) {
            for (int end = start; end < RangeEnd; end++) {
                result.add(
                        new RangeByAgeTestCase(start, end, animals)
                );
            }
        }

        return result;
    }

    private static List<Animal> getLotsOfAnimals(int AnimalCount, int MaxAge) {
        List<Animal> animals = new ArrayList<>();
        for (int i = 0; i < AnimalCount; i++) {
            animals.add(
                    (i % 2 == 0) ?
                            (new Cat(i + " the cat", "female", i % MaxAge)) :
                            (new Dog(i + " the dog", "male", i % MaxAge, "Peng"))
            );
        }
        return animals;
    }

    private List<RangeByAgeTestCase> getSampleRangeByAgeTestCases(List<Animal> animals) {
        return Arrays.asList(
                new RangeByAgeTestCase(0, 0, animals),
                new RangeByAgeTestCase(-7, 0, animals),
                new RangeByAgeTestCase(0, 5, animals),
                new RangeByAgeTestCase(1, 2, animals),
                new RangeByAgeTestCase(-1, 3, animals),
                new RangeByAgeTestCase(2, 10, animals),
                new RangeByAgeTestCase(6, 12, animals),
                new RangeByAgeTestCase(7, 13, animals),
                new RangeByAgeTestCase(20, 300, animals)
        );
    }

    private static List<Animal> getAnimalsInBalancedBST() {
        //      5
        //    /   \
        //   3      8
        //  / \    /  \
        // 1   4  6    12
        return Arrays.asList(
                new Cat("Alex", "male", 3),
                new Dog("David", "male", 12, "Peng"),
                new Cat("Tommy", "male", 5),
                new Dog("Sally", "female", 1, "Peng"),
                new Dog("Wang", "female", 8, "Seattle Humane"),
                new Cat("Chloe", "female", 6),
                new Dog("Max", "male", 4, "Stella")
        );
    }

    private static void validateIndexedData(List<Animal> animals, TreeNode<Animal> expectRoot) throws NoSuchFieldException, IllegalAccessException {
        // reflection to get access to a private field in the class.
        // not the best idea. let me know if you have better way to test this.
        Field field = VetDatabase.class.getDeclaredField("ageIndexedData");
        field.setAccessible(true);

        VetDatabase db = new VetDatabase(animals);

        BinaryTree<Animal> actual = new BinaryTree<>((TreeNode<Animal>) field.get(db));
        BinaryTree<Animal> expect = new BinaryTree<>(expectRoot);

        // this uses problem 5's equals for testing
        assertEquals(expect, actual);
    }
}