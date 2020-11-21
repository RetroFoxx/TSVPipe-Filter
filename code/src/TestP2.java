/**
 * @author: Brian Yen, bfy2101
 * TestP2 is a class for running different tests for part 2 of programming section. Test
 * select on different string and two main primitive types. Also test for null select object.
 */

public class TestP2 {
    public void runTests(){
        System.out.println("Part 2 Tests: \n");
        testSelectOnString();
        testSelectOnDouble();
        testSelectOnInt();
        testNoSelect();
    }

    private void testSelectOnString(){
        System.out.println("Select on String test");
        TSVFilter userTSVFilter = new TSVFilter
                .WhichFile("P2_selectTestData.tsv")
                .select("Name", "Frank")
                .done();
        System.out.println(userTSVFilter);
        new TSVPipeLine(userTSVFilter).doIt();
    }

    private void testSelectOnDouble(){
        System.out.println("Select on double test");
        TSVFilter userTSVFilter = new TSVFilter
                .WhichFile("P2_selectTestData.tsv")
                .select("Balance", "20.00")
                .done();
        System.out.println(userTSVFilter);
        new TSVPipeLine(userTSVFilter).doIt();
    }

    private void testSelectOnInt(){
        System.out.println("Select on int test");
        TSVFilter userTSVFilter = new TSVFilter
                .WhichFile("P2_selectTestData.tsv")
                .select("Age", "30")
                .done();
        System.out.println(userTSVFilter);
        new TSVPipeLine(userTSVFilter).doIt();
    }

    private void testNoSelect(){
        System.out.println("no select test");
        TSVFilter userTSVFilter = new TSVFilter
                .WhichFile("P2_selectTestData.tsv")
                .done();
        System.out.println(userTSVFilter);
        new TSVPipeLine(userTSVFilter).doIt();
    }
}
