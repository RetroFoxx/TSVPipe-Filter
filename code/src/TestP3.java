/**
 * @author: Brian Yen, bfy2101
 * TestP3 is a class for running different tests for part 3 of programming section.
 * Test terminate max and min on numbers and strings, terminate with select,
 * terminate without select, and null object.
 */

public class TestP3 {
    public void runTests(){
        System.out.println("Part 3 test: \n");
        testTerminateMaxNumber();
        testTerminateMinNumber();
        testTerminateMaxString();
        testTerminateMinString();
        testTerminateAndSelect();
        testNoTerminate();
        testNoTerminateOrSelect();
    }

    private void testTerminateMaxNumber(){
        System.out.println("terminate max number test");
        TSVFilter userTSVFilter = new TSVFilter
                .WhichFile("P3_terminateTestData.tsv")
                .terminate("Age", TerminalObservation.MAX)
                .done();
        System.out.println(userTSVFilter);
        new TSVPipeLine(userTSVFilter).doIt();
    }

    private void testTerminateMinNumber(){
        System.out.println("terminate min number test");
        TSVFilter userTSVFilter = new TSVFilter
                .WhichFile("P3_terminateTestData.tsv")
                .terminate("Age", TerminalObservation.MIN)
                .done();
        System.out.println(userTSVFilter);
        new TSVPipeLine(userTSVFilter).doIt();
    }

    private void testTerminateMaxString(){
        System.out.println("terminate max string test");
        TSVFilter userTSVFilter = new TSVFilter
                .WhichFile("P3_terminateTestData.tsv")
                .terminate("Name", TerminalObservation.MAX)
                .done();
        System.out.println(userTSVFilter);
        new TSVPipeLine(userTSVFilter).doIt();
    }

    private void testTerminateMinString(){
        System.out.println("terminate min string test");
        TSVFilter userTSVFilter = new TSVFilter
                .WhichFile("P3_terminateTestData.tsv")
                .terminate("Name", TerminalObservation.MIN)
                .done();
        System.out.println(userTSVFilter);
        new TSVPipeLine(userTSVFilter).doIt();
    }

    private void testTerminateAndSelect(){
        System.out.println("terminate and select test");
        TSVFilter userTSVFilter = new TSVFilter
                .WhichFile("P3_terminateTestData.tsv")
                .select("Name", "Frank")
                .terminate("Balance", TerminalObservation.MAX)
                .done();
        System.out.println(userTSVFilter);
        new TSVPipeLine(userTSVFilter).doIt();
    }

    private void testNoTerminate(){
        System.out.println("no terminate test");
        TSVFilter userTSVFilter = new TSVFilter
                .WhichFile("P3_terminateTestData.tsv")
                .select("Name", "Brian")
                .done();
        System.out.println(userTSVFilter);
        new TSVPipeLine(userTSVFilter).doIt();
    }

    private void testNoTerminateOrSelect(){
        System.out.println("no terminate or select test");
        TSVFilter userTSVFilter = new TSVFilter
                .WhichFile("P3_terminateTestData.tsv")
                .done();
        System.out.println(userTSVFilter);
        new TSVPipeLine(userTSVFilter).doIt();
    }
}
