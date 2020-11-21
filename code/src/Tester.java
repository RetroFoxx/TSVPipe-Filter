/**
 * @author: retrofoxx
 * Tester is a class for running tests for part1, part2 and part3 of the programming section.
 */

public class Tester {
    private final TestP1 PartOne;
    private final TestP2 PartTwo;
    private final TestP3 PartThree;

    public Tester(){
        PartOne = new TestP1();
        PartTwo = new TestP2();
        PartThree = new TestP3();
    }
    
    public void runTests(){
        PartOne.runTests();
        PartTwo.runTests();
        PartThree.runTests();
    }
}
