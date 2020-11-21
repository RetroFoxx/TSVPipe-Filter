/**
 * @author: Brian Yen, bfy2101
 * TestP1 is a class for running different tests for part 1 of programming section. Test for
 * a file with bad header, field, values and a test for a good file.
 */

public class TestP1 {
    public void runTests(){
        System.out.println("Part 1 Tests: \n");
        runNoFileExistTest();
        runBadFormatTest();
        runBadFieldTypeTest();
        runBadFieldValueTest();
        runGoodFileFormatTest();
    }

    private void runNoFileExistTest(){
        System.out.println("No file exist test");
        TSVFilter userTSVFilter = new TSVFilter
                .WhichFile("doesNotExist.tsv")
                .done();
        System.out.println(userTSVFilter);
        new TSVPipeLine(userTSVFilter).doIt();
    }

    private void runBadFormatTest(){
        System.out.println("Bad header formatting test");
        TSVFilter userTSVFilter = new TSVFilter
                .WhichFile("P1_badFormat.tsv")
                .done();
        System.out.println(userTSVFilter);
        new TSVPipeLine(userTSVFilter).doIt();
    }

    private void runBadFieldTypeTest(){
        System.out.println("Bad Field type test");
        TSVFilter userTSVFilter = new TSVFilter
                .WhichFile("P1_badFieldType.tsv")
                .done();
        System.out.println(userTSVFilter);
        new TSVPipeLine(userTSVFilter).doIt();
    }

    private void runBadFieldValueTest(){
        System.out.println("Bad field value test");
        TSVFilter userTSVFilter = new TSVFilter
                .WhichFile("P1_badFieldValue.tsv")
                .done();
        System.out.println(userTSVFilter);
        new TSVPipeLine(userTSVFilter).doIt();
    }

    private void runGoodFileFormatTest(){
        System.out.println("good file test");
        TSVFilter userTSVFilter = new TSVFilter
                .WhichFile("P1_goodFileFormat.tsv")
                .done();
        System.out.println(userTSVFilter);
        new TSVPipeLine(userTSVFilter).doIt();
    }
}
